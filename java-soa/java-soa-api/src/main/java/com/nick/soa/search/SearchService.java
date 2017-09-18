package com.nick.soa.search;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by ningyang on 2017/9/18.
 */
public class SearchService<T> {

    private CharColumn<T>[] columns = new CharColumn[Character.MAX_VALUE];
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public Collection search(String word, int limit){
        readLock.lock();
        try{
            int n = word.length();
            char[] chars = word.toCharArray();
            Context<T> context = new Context<>();
            for(int i=0;i<chars.length;i++){
                CharColumn<T> column = columns[chars[i]];
                if(column==null){
                    break;
                }
                if(!context.filter(column)){
                    break;
                }
                n--;
            }
            if(n==0){
                return context.limit(limit);
            }
            return Collections.emptySet();
        }finally {
            readLock.unlock();
        }
    }

    public void put(T t, String value){
        writeLock.lock();
        try{
            char[] chars = value.toCharArray();
            for(int i=0; i< chars.length; i++){
                char c = chars[i];
                CharColumn<T> column = columns[c];
                if(column == null){
                    column = new CharColumn<>();
                    columns[c] = column;
                }
                column.add(t, (byte)i);
            }
        }finally {
            writeLock.unlock();
        }
    }

    public void update(T t, String newValue){
        writeLock.lock();
        try {
            remove(t);
            put(t, newValue);
        }finally {
            writeLock.unlock();
        }
    }

    public boolean remove(T t){
        writeLock.lock();
        try{
            for(CharColumn<T> column: columns){
                if(column!=null){
                    if(column.remove(t)){
                        return true;
                    }
                }
            }
            return false;
        }finally {
            writeLock.unlock();
        }
    }

    private class CharColumn<T>{
        ConcurrentHashMap<T, byte[]> poxIndex = new ConcurrentHashMap<>();

        void add(T t, byte pox){
            byte[] arr = poxIndex.get(t);
            if(null==arr){
                arr = new byte[]{pox};
            }else{
                arr = copy(arr, pox);
            }
            poxIndex.put(t, arr);
        }

        private boolean remove(T id){
            if(poxIndex.remove(id)!=null){
                return true;
            }
            return false;
        }
    }

    private static byte[] copy(byte[] arr, byte value){
        Arrays.sort(arr);
        if(contain(arr, value)){
            return arr;
        }
        byte[] newArr = new byte[arr.length + 1];
        newArr[newArr.length-1] = value;
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        Arrays.sort(newArr);
        return newArr;
    }

    private static boolean contain(byte[] arr, byte value){
        int pox = Arrays.binarySearch(arr, value);
        return (pox>=0)?true:false;
    }

    private class Context<T>{
        Map<T, byte[]> result;
        boolean used = false;

        private boolean filter(CharColumn<T> columns){
            if(this.used == false){
                this.result = new TreeMap<>(columns.poxIndex);
                this.used = true;
                return true;
            }
            boolean flag = false;
            Map<T, byte[]> newResult = new TreeMap<>();
            Set<Map.Entry<T, byte[]>> entrySet = columns.poxIndex.entrySet();
            for(Map.Entry<T, byte[]> entry: entrySet){
                T id = entry.getKey();
                byte[] charPox = entry.getValue();
                if(!result.containsKey(id)){
                    continue;
                }
                byte[] before = result.get(id);
                boolean in = false;
                for(byte pox: before){
                    if(contain(charPox, (byte)(pox+1))){
                        in = true;
                        break;
                    }
                }
                if(in){
                    flag = true;
                    newResult.put(id, charPox);
                }
            }
            result = newResult;
            return flag;
        }

        public Collection<T> limit(int limit){
            if(result.size()<=limit){
                return result.keySet();
            }
            Collection<T> ids = new TreeSet<>();
            for(T id: result.keySet()){
                ids.add(id);
                if(ids.size()>=limit){
                    break;
                }
            }
            return ids;
        }
    }
}

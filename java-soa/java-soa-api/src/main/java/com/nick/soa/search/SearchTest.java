package com.nick.soa.search;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by ningyang on 2017/9/18.
 */
public class SearchTest {

    public static void main(String[] args) {
        SearchService searchService = new SearchService();
        searchService.put("东北", "东北");
        searchService.put("湖南", "湖南");
        searchService.put("北京", "北京");
        searchService.put("河北", "河北");
        searchService.put("河南", "河南");
        searchService.put("江西", "江西");
        Set<String> set = (Set) searchService.search("北", 10);
        for(Iterator iterator = set.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }
}

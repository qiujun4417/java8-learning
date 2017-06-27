package com.nick.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by nick on 2017/6/24.
 * 异步selector处理多个信道
 */
public class NioServer {

    private Integer serverPort;
    private Integer timeOut;

    public NioServer(Integer serverPort, Integer timeOut){
        this.serverPort = serverPort;
        this.timeOut = timeOut;
    }

    public void openServer() throws IOException {
        Selector selector = null;
        ServerSocketChannel serverSocketChannel = null;
        try{
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(serverPort));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while(true){
//                if(selector.select(timeOut)==0){
//                    continue;
//                }
                SocketChannel socketChannel = serverSocketChannel.accept();
                if(socketChannel!=null){
                    socketChannel.register(selector, SelectionKey.OP_ACCEPT);
                    if(selector.select(timeOut)==0)
                        continue;
                    Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                    while(iter.hasNext()){
                        SelectionKey key = iter.next();
                        if(key.isAcceptable()){
                            handleAccept(key);
                        }
                        if(key.isReadable()){
                            handleRead(key);
                        }
                        if(key.isWritable()){
                            handleWrite(key);
                        }
                        if(key.isConnectable()){

                        }
                        iter.remove();
                    }
                }
            }
        }finally {
            if(selector!=null){
                selector.close();
            }
            if(serverSocketChannel!=null){
                serverSocketChannel.close();
            }
        }

    }

    private void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false);
        sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(48));
    }

    private void handleRead(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buf = (ByteBuffer)key.attachment();
        long bytesRead = socketChannel.read(buf);
        while(bytesRead>0){
            buf.flip();
            while (buf.hasRemaining()){
                System.out.println((char)buf.get());
            }
            buf.clear();
            bytesRead = socketChannel.read(buf);
        }
        if(bytesRead == -1) socketChannel.close();
    }

    private void handleWrite(SelectionKey key) throws IOException {
        ByteBuffer buf = (ByteBuffer) key.attachment();
        buf.flip();
        SocketChannel socketChannel = (SocketChannel) key.channel();
        while(buf.hasRemaining()){
            socketChannel.write(buf);
        }
        buf.compact();
    }

    public static void main(String[] args) throws IOException {
        NioServer server = new NioServer(8088, 3000);
        server.openServer();
    }
}


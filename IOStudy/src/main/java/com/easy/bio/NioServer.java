package com.easy.bio;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
    public static void main(String[] args) throws Exception {
        //1.打开ServerSocketChannel 用于监听客户端连接
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2.绑定监听端口,设置连接为非阻塞,默认为阻塞模式
        SocketAddress socketAddress = new InetSocketAddress(6666);
        serverSocketChannel.bind(socketAddress);
        serverSocketChannel.configureBlocking(false);
        //3.打开一个Selector,并将serverSocketChannel 注册在selector 上
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            //注册在该selector 上
            int num = selector.select();
            System.out.println("num is "+num);
            if (num == 0) {
                continue;
            }
            Set<SelectionKey> selectorKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectorKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel sc=ssc.accept();
                    sc.configureBlocking(false);
                    sc.register(selector,SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    SocketChannel sc = (SocketChannel) selectionKey.channel();
                    sc.read(byteBuffer);
                    String readStr =new String(byteBuffer.array());
                    byteBuffer.clear();
                    System.out.println(String.format("From %s :%s",sc.getRemoteAddress(),readStr));
                    String responseMessage="you send message is :"+readStr;
                    sc.write(ByteBuffer.wrap(responseMessage.getBytes()));
                }
                iterator.remove();
            }
        }
    }
}

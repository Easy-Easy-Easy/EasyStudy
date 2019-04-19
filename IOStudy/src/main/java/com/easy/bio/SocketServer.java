package com.easy.bio;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer {
    //只能连接一个客户端
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器启动成功.............");
       while (true){
           Socket clentSocket= serverSocket.accept();
           System.out.println("Conneection from "+ clentSocket.getRemoteSocketAddress());
           Scanner input = new Scanner(clentSocket.getInputStream());
           while (true){
               String msg = input.nextLine();
               if(msg.equals("quit")){
                   break;
               }
               System.out.println(msg);
               String response ="hello "+msg;
               clentSocket.getOutputStream().write(response.getBytes());
           }
       }
    }
}

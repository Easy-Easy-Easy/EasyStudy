package com.easy.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//连接多个客户端
public class BioSockerServers {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务启动了......");
        while (true){
            Socket socket=serverSocket.accept();
            executorService.submit(new ClientHandler(socket));
        }


    }
}

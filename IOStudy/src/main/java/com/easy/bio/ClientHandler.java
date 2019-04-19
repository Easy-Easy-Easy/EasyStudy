package com.easy.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            Scanner input = new Scanner(clientSocket.getInputStream());
            while (true) {
                String msg = input.nextLine();
                if (msg.equals("quit")) {
                    break;
                }
                System.out.println(msg);
                String response = "hello " + msg;
                clientSocket.getOutputStream().write(response.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

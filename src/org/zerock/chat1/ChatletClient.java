package org.zerock.chat1;

import java.net.ServerSocket;
import java.net.Socket;

public class ChatletClient {

    public static void main(String[] args)throws Exception {

        Socket socket = new Socket("127.0.0.1", 7777);

        Chatlet chatlet = new Chatlet(socket);

        new Thread(() -> {
            try {
                chatlet.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {

            try {
                chatlet.write();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

        System.out.println("END");
    }
}

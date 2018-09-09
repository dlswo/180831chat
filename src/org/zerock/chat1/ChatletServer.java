package org.zerock.chat1;

        import java.net.ServerSocket;
        import java.net.Socket;

public class ChatletServer {

    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("READY.............");
        Socket socket = serverSocket.accept();

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

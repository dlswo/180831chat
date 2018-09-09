package org.zerock;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneClient {

    public static void main(String[] args) {

        System.out.println("연결 시작합니다. ");
        try (
                Socket socket = new Socket("127.0.0.1",7777);
                DataInputStream din = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                Scanner scanner = new Scanner(System.in);
                ){

            new Thread(() -> {
                try{

                    while(true){
                        String otherMsg = din.readUTF();
                        System.out.println(otherMsg);
                    }



                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }).start();

            while(true) {
                String myMsg = scanner.nextLine();
                dos.writeUTF(myMsg);
            }



        }catch(Exception e){
            System.out.println(e.getMessage());
        }//end catch
    }
}

package org.zerock.multi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class


  MultiServer1 {

    //bad code
    public static void main(String[] args) throws Exception{

        ServerSocket server = new ServerSocket(7777);

        System.out.println("READY................");
        List<DataOutputStream> dosList = new ArrayList<>();

        while(true){

            Socket client = server.accept();
            DataInputStream din = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dosList.add(dos);

            new Thread(() -> {
                try{
                    while(true){
                        String msg = din.readUTF();
                        System.out.println(client.getInetAddress()+ ":" +msg);

                        for(DataOutputStream ds:dosList){
                            ds.writeUTF("SERVER: " + msg);
                        }

                    }
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }).start();
        }

    }
}

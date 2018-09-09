package org.zerock.chat1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Chatlet {

    private Socket socket;
    private DataInputStream din;
    private DataOutputStream dos;
    private Scanner scanner;

    public Chatlet(Socket socket)throws Exception {
        this.socket = socket;
        this.din = new DataInputStream(socket.getInputStream());
        this.dos = new DataOutputStream(socket.getOutputStream());
        this.scanner = new Scanner(System.in);
    }

    public void write()throws Exception{
        while(true){
            String msg = scanner.nextLine();
            dos.writeUTF(msg);
        }
    }

    public void read()throws Exception {
        while(true){
            String msg = din.readUTF();
            System.out.println(msg);
        }
    }

    public void closeAll(){
        try{ scanner.close(); }catch(Exception e){}
        try{ din.close(); }catch(Exception e){}
        try{ dos.close(); }catch(Exception e){}
        try{ socket.close(); }catch(Exception e){}
    }

}

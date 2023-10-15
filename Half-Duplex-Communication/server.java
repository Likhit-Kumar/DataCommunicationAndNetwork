import java.net.*;
import java.util.Scanner;
import java.io.*;

public class server {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            ServerSocket ss = new ServerSocket(3000);
            System.out.println("SERVER IS READY");
            Socket s = ss.accept();
            while (true) {
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = dis.readUTF();
                System.out.println("Client : " + str);
                if (str.equals("STOP")) {
                    break;
                }
                System.out.print("Reply : ");
                String reply = scan.nextLine();
                OutputStream os = s.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF(reply);
                if (reply.equals("STOP"))
                    break;
            }
            ss.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
};
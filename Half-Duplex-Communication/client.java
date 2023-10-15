import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            // System.out.println(InetAddress.getLocalHost());
            Socket s = new Socket(InetAddress.getLocalHost(), 3000);
            System.out.println("CLIENT CONNECTED TO SERVER");
            while (true) {
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                System.out.print("Your Message: ");
                String data = scan.nextLine();
                dos.writeUTF(data);
                if (data.equals("STOP"))
                    break;
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String res = dis.readUTF();
                System.out.println("Server: " + res);
                if (res.equals("STOP"))
                    break;
            }
            scan.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
};
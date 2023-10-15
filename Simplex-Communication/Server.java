import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("Server Started");
            ServerSocket ss = new ServerSocket(3000);
            Socket s = ss.accept();
            System.out.println("Server Connected");

            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            // String str = "Hey Likhit";
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(str);
            dos.flush();
            dos.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
import java.io.*;
import java.net.*;
import java.util.*;

public class Server2 {

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5000);
            Socket s = ss.accept();
    
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = dis.readUTF();
            System.out.println(str);
        } catch(Exception e) {
            System.out.print(e);
        }

    }    
}

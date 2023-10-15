import java.io.*;
import java.net.*;
import java.util.*;
public class Client2 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 5000);
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
    
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(str);
        } catch(Exception e) {
            System.out.print(e);
        }

    }
}

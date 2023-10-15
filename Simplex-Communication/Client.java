import java.io.*;
import java.net.*;
public class Client {
    public static void main(String args[]) {
        try {
            Socket soc = new Socket ("localhost",3000);
            
            DataInputStream dis = new DataInputStream(soc.getInputStream());
            String str=(String)dis.readUTF();
            System.out.println("The Received Message is: "+ str);
            soc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
            
    }
}
import java.util.*;
import java.net.*;
import java.io.*;
public class echoserver
{
 public static void main(String[] args) throws Exception
 {
   System.out.println("waiting for client");
   ServerSocket ss=new ServerSocket(5000);
   Socket s=ss.accept();
   System.out.println("Client Connected");
   DataInputStream din=new DataInputStream(s.getInputStream());
   DataOutputStream dout= new DataOutputStream(s.getOutputStream());

   String cmsg="";
   while(!cmsg.equals("stop"))
   {
    cmsg=din.readUTF();
    dout.writeUTF(cmsg); 
    System.out.println(cmsg+" echoed the message to client");
   }
   dout.close();
   s.close();
   ss.close();
   din.close();
 }
}

import java.util.*;
import java.net.*;
import java.io.*;
public class echoclient
{
 public static void main(String[] args) throws Exception
 {
   Socket s=new Socket("localhost",5000);
   DataInputStream din=new DataInputStream(s.getInputStream());
   DataOutputStream dout= new DataOutputStream(s.getOutputStream());
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

   String cmsg="",emsg="";
   while(!cmsg.equals("stop"))
   {
    System.out.print("Enter Message: ");
    cmsg=br.readLine();
    dout.writeUTF(cmsg);
    emsg=din.readUTF();
    System.out.println("Echo Message from Server: "+emsg);
    dout.flush();
   }
   dout.close();
   s.close();
   din.close();
 }
}

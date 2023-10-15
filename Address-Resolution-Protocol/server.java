import java.io.*;
import java.net.*;
import java.util.*;
public class server {
    public static void main(String args[]) {
        try {
            ServerSocket obj=new ServerSocket(3030);
            Socket obj1=obj.accept();
            while(true)
            {
                DataInputStream din=new DataInputStream(obj1.getInputStream());
                DataOutputStream dout=new DataOutputStream(obj1.getOutputStream()); 
                String str=din.readLine();
                String ip[]={"165.165.80.80","165.165.79.1", "192.168.43.1"};
                String mac[]={"02:1A:43:18:F3:C9","00:1B:44:11:3A:B7", "2C:54:91:88:C9:E3"};
                for(int i=0;i<ip.length;i++) {
                    if(str.equals(ip[i])) {
                        dout.writeBytes(mac[i]+'\n');
                        break;
                    }
                }
                obj.close();
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
import java.io.*;
import java.net.*;
import java.util.*;
public class server {
    public static void main(String args[])
    {
        try {
            DatagramSocket server=new DatagramSocket(1309);
            while(true) {
                byte[] sendbyte=new byte[1024];
                byte[] receivebyte=new byte[1024];
                DatagramPacket receiver=new DatagramPacket(receivebyte,receivebyte.length);
                server.receive(receiver);
                String str=new String(receiver.getData());
                String s=str.trim(); 
                InetAddress addr=receiver.getAddress();
                int port=receiver.getPort();
                String ip[]={"165.165.80.80","165.165.79.1", "192.168.43.1"};
                String mac[]={"02:1A:43:18:F3:C9","00:1B:44:11:3A:B7", "2C:54:91:88:C9:E3"};
                for(int i=0;i<ip.length;i++) {
                    if(s.equals(mac[i])) {
                        sendbyte=ip[i].getBytes();
                        DatagramPacket sender=new DatagramPacket(sendbyte,sendbyte.length,addr,port);
                        server.send(sender);
                        break;
                    }
                }
                break;
            }
        }
        catch(Exception e)
        {
        System.out.println(e);
        }
    }
}
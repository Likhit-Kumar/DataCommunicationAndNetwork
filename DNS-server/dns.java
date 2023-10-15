import java.net.*;
import java.io.*;
import java.util.*;

public class dns
{
 public static void main(String[] args) throws IOException {
  int n;
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  do
  {
   System.out.println("\n Menu: \n 1. DNS 2. Exit \n");
   System.out.println("\n Enter your choice");
   String s = in.readLine();
   n = Integer.parseInt(s);
//    n = Integer.parseInt(System.console().readLine());
   
   if(n == 1) {
    try 
    {
     System.out.println("\n Enter the Host Name ");
     String hname=in.readLine();
     
    //  InetAddress add = InetAddress.getLocalHost();
    //  System.out.println("Host Name: " + add.getHostName());
    //  System.out.println("IP: " + add.getHostAddress());
     
    InetAddress address = InetAddress.getByName(hname);
     System.out.println("Host Name: " + address.getHostName());
     System.out.println("IP: " + address.getHostAddress());
    } 
    catch(IOException ioe) 
    {
     ioe.printStackTrace();
    }
   }
  } while(!(n==2));
 }
}

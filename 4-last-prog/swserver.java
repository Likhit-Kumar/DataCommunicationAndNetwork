// import java.io.*;

// import java.net.*;

// import java.util.*;

// public class swserver {

//     public static void main(String args[])

// {

//     String h="Serverhost";

//     int q=5000;

//     int i;

//         try

//         {         

//         ServerSocket ss2;

//             ss2 = new ServerSocket(8000);

//             Socket s1 =ss2.accept();

//         DataInputStream dd1= new DataInputStream(s1.getInputStream());

//         Integer i1 =dd1.read();

//         for(i=0;i<i1;i++)

//         {

//         DataInputStream dd= new DataInputStream(s1.getInputStream());

//         String sss1 = dd.readUTF();

//             System.out.println(sss1);

//             System.out.println("Frame "+ i%2+" received");

//         DataOutputStream d1 = new DataOutputStream(s1.getOutputStream());

//         d1.write(i);

//          System.out.println("ACK sent for "+ i%2); 

//         }

//         }

//         catch(Exception ex)

//         {

//          System.out.println("Error"+ex);

//                 }

// }

// }

import java.net.*;
import java.io.*;
public class swserver{
    public static void main(String Args[]){
        try{
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Waiting for Sender...");
            Socket s = ss.accept();
            System.out.println("Connected to Sender...");
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            int len = Integer.parseInt(din.readUTF());
            String msg;
            for(int i=0;i<len;i++){
                msg = (String) din.readUTF();
                System.out.println("The Data Received from Sender in "+(i+1)+"th frame is:"+msg);
                dout.writeUTF(Integer.toString(i+1));
                System.out.println("Acknowledgement sent.");
            }
        }catch(Exception e){
            System.out.println("Error occured:"+e);
        }
    }
}
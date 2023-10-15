// import java.io.*;
// import java.net.*;
// import java.util.Scanner;

// public class swSender {
//     public static void main(String args[])
// {
//    int p=5000,i,port=8000;
//     String h="localhost";
//     Socket s2;
//     try
//     {
//         Scanner scanner = new Scanner(System.in);
//     System.out.print("Enter number of frames : ");
//     int number = scanner.nextInt();
//     if(number==0)
//     {
//         System.out.println("No frame is sent");
//     }
//     else
//             {           

//         s2= new Socket(h,port);
//         DataOutputStream d1 = new DataOutputStream(s2.getOutputStream());
//         d1.write(number);
//           }
//     String str1;

//         for (i=0;i<number;i++)
//         {                 
//             System.out.print("Enter message : ");
//             String name = scanner.next();
//             System.out.println("Frame " + i%2 +" is sent"); 
//             Socket s1;
//             s1= new Socket(h,p+i);
//             DataOutputStream d = new DataOutputStream(s1.getOutputStream());
//             d.writeUTF(name);
//             DataInputStream dd= new DataInputStream(s1.getInputStream());
//             Integer sss1 = dd.read();
//             System.out.println("Ack for :" + sss1%2 + " is  received");
//         }
//     }
//     catch(Exception ex)
//             {
//                 System.out.println("ERROR :"+ex);
//             }
// } 
// }

import java.net.*;
import java.io.*;
import java.util.*;
public class swSender{
    public static void main(String Args[]){
        try{
            Socket s = new Socket("localhost",6666);
            System.out.println("Connected to Receiver...");
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            System.out.println("Enter the No.of.Frames:");
            Scanner sc = new Scanner(System.in);
            int len = sc.nextInt();
            sc.nextLine();
            dout.writeUTF(Integer.toString(len));
            String msg;
            for(int i=0;i<len;i++){
                System.out.println("Enter Data for "+(i+1)+"th Frame:");
                msg = sc.nextLine();
                dout.writeUTF(msg);
                System.out.println("Frame Sent.");
                int ack = Integer.parseInt(din.readUTF());
                System.out.println("The Acknowledgemnt received for "+(ack)+"th frame");
            }
        }catch(Exception e){
            System.out.println("Error occured:"+e);
        }
    }
}
import java.io.*;
import java.net.*;
import java.util.*;

public class client {
 public static void main(String[] args) throws Exception {
 //Initialize socket
 do{
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the Choice 1.Send file 2.exit");
        int choice = sc.nextInt();

        Socket socket = new Socket("localhost", 5000);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(Integer.toString(choice));

        switch (choice) {
            case 1:
            {
                System.out.println("Enter the File Name:");
                String fileName=sc.next();
                File file = new File(fileName);
                try {
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    //Get socket's output stream
                    OutputStream os = socket.getOutputStream();
                    //Read File Contents into contents array
                    byte[] contents;
                    long fileLength = file.length();
                    long current = 0;
                    long start = System.nanoTime();
                    while(current!=fileLength) { // 0 != 5
                        int size = 10000; // 5
                        if(fileLength - current >= size) // 5 - 0 = 5 >= 10000
                            current += size;
                        else {
                            size = (int)(fileLength - current); // 5
                            current = fileLength; // 5
                        }
                        contents = new byte[size]; // 5
                        bis.read(contents, 0, size); // 
                        os.write(contents); //
                    }
                    os.flush();
                    //File transfer done. Close the socket connection!
                    socket.close();
                    
                    System.out.println("File sent succesfully!");
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
                break;
            }
            case 2:
                System.exit(1);
                break;
        }
        
    } while(true);
       
 }

}
import java.net.*;
import java.io.*;
import java.util.*;

public class server {
public static void main(String args[]) {
try {
	ServerSocket ss = new ServerSocket(5000);
	Socket s = ss.accept();
	String str = "";

	DataInputStream dis = new DataInputStream(s.getInputStream());
	str = dis.readUTF();
 	dis.close();
	System.out.println(str);

} catch(IOException e) {
System.out.println(e);
}

}
}
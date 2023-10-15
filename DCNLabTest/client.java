import java.io.*;
import java.net.*;
import java.util.*;


public class client {
public static void main(String args[]) {
	try {
	Scanner scan = new Scanner(System.in);
	String str = scan.nextLine();	
	Socket s = new Socket(InetAddress.getLocalHost(), 5000);
	DataOutputStream dos = new DataOutputStream(s.getOutputStream());
	dos.writeUTF(str);
	dos.flush();
	dos.close();
	
} catch (IOException e) {
System.out.println(e);
}
}
}
import java.io.BufferedReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.*;
import java.io.*;

public class arp{
    public static void main(String[] args) throws Exception {
        try {

            // InetAddress address = InetAddress.getByName("10.1.24.55");

            // InetAddress address = InetAddress.getLocalHost();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String addr= br.readLine();
            InetAddress address = InetAddress.getByName(addr);
            // String host = address.getHostName();

            NetworkInterface ni = NetworkInterface.getByInetAddress(address);
            if (ni != null) {
                byte[] mac = ni.getHardwareAddress();
                if (mac != null) {
		    System.out.println("The MAC Address for the ip : " + address +" is \n");
                    for (int i = 0; i < mac.length; i++) {
                        System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "");
                    }
                } else {
                    System.out.println("Address doesn't exist or is not accessible.");
                }
            } else {
                System.out.println("Network Interface for the specified address is not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

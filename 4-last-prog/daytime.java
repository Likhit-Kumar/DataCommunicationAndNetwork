import java.io.*;
import java.net.*;
class daytime
{
    public static void main(String args[]) throws Exception
    {
        Socket soc=new Socket(InetAddress.getLocalHost(),5000);        
        BufferedReader in=new BufferedReader(new InputStreamReader(soc.getInputStream()  ));
        System.out.println(in.readLine());
    }    
}

import java.util.Scanner;
class Subnet {
  // ip address, mask  -> 192.168.1.1 / 21
  // So, No. of network, host address 
  // First Address, Last Address

  // 11111111.11111111.11111111.00000000
  // 11000000.10101000.00000001.00000001

 public static void main(String args[])
 {
  Scanner sc = new Scanner(System.in);
  System.out.print("Enter the ip address: ");
  String ip = sc.nextLine();

  String split_ip[] = ip.split("\\."); // 192.168.1.1
  String split_bip[] = new String[4]; 
  String bip = "";

  for(int i=0;i<4;i++) {
    // 192
    // 11000000
    // 1
    // 1 -> 
    // 00000001
    String ipbin = Integer.toBinaryString(Integer.parseInt(split_ip[i]));
    // System.out.println(ipbin);
    split_bip[i] = appendZeros(ipbin);
    // System.out.println(appendZeros(ipbin));
    bip += split_bip[i];
  }


  // 192.168.1.1
  System.out.println("IP in binary is "+bip); //----
  System.out.print("Enter the subnet mask:"); // 21
  int mask = sc.nextInt(); // 21
  int bits = 32-mask; // 11

  if(mask>24) {
      int over = mask-24;
      System.out.println("The No.of.networks :"+Math.pow(2,(mask-24)));
      System.out.println("The host Portion:"+(Math.pow(2,(8-over))-2));
  } else if(mask>16) {
    int over = mask-16; // 5
    System.out.println("The No.of.networks :"+Math.pow(2,(mask-16+8))); // 13 = 2^13
    System.out.println("The host Portion:"+(Math.pow(2,(8-over))-2)); // 6
  } else {
    int over = mask-8;
    System.out.println("The No.of.networks :"+Math.pow(2,(mask+8)));
    System.out.println("The host Portion:"+(Math.pow(2,(8-over))-2)); 
  }


  int fbip[] = new int[32];
  for(int i=0; i<32;i++) {
    fbip[i] = (int)bip.charAt(i)-48;
  }

  for(int i=31;i>31-bits;i--)
  fbip[i] &= 0;
  String fip[] = {"","","",""};
  
  for(int i=0;i<32;i++)
  fip[i/8] = new String(fip[i/8]+fbip[i]);
  System.out.print("First address is = ");
  
  for(int i=0;i<4;i++){
  System.out.print(Integer.parseInt(fip[i],2));
  if(i!=3) System.out.print(".");
  }
  System.out.println();
  int lbip[] = new int[32];
  
  for(int i=0; i<32;i++) lbip[i] = (int)bip.charAt(i)-48;
  
  for(int i=31;i>31-bits;i--)
  lbip[i] |= 1;
  String lip[] = {"","","",""};
  
  for(int i=0;i<32;i++)
  lip[i/8] = new String(lip[i/8]+lbip[i]);
  System.out.print("Last address is = ");
  
  for(int i=0;i<4;i++){
  System.out.print(Integer.parseInt(lip[i],2));
  if(i!=3) System.out.print(".");
  }
  System.out.println();
  }

  static String appendZeros(String s){ // 11000000
    // 1
  String temp = new String("00000000");
  // 0000 000
  return temp.substring(s.length())+ s; // 11000000
 }

}
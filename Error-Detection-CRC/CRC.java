import java.io.*;
public class CRC {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Generator:");
        String gen = br.readLine();

        System.out.println("Enter Data:");
        String data = br.readLine();
        String code = data;

        while(code.length() < (data.length() + gen.length() - 1))
            code = code + "0";
        
        code = data + div(code,gen);
        
        System.out.println("The transmitted Code Word is: " + code);
        
        System.out.println("Enter the received Code Word: ");
        String rec = br.readLine();
        
        if(Integer.parseInt(div(rec,gen)) == 0)
            System.out.println("The received code word contains no errors.");
        else
            System.out.println("The received code word contains errors.");
    }

    static String div(String num1,String num2) {

        int pointer = num2.length(); //4

        String result = num1.substring(0, pointer); // 1010 00
        String remainder = "";

        for(int i = 0; i < num2.length(); i++) {
            if(result.charAt(i) == num2.charAt(i)) // 1010 - 1001
            remainder += "0";
            else
            remainder += "1";
        } // rem = 0011

        while(pointer < num1.length()) { // 4 < 11

            if(remainder.charAt(0) == '0') { // 0 011
                remainder = remainder.substring(1, remainder.length()); // 011
                remainder = remainder + String.valueOf(num1.charAt(pointer)); // 0110
                pointer++; // 5
            }

            result = remainder; // 0110
            remainder = "";
            for(int i = 0; i < num2.length(); i++) {
                if(result.charAt(i) == num2.charAt(i)) // 0110 - 1001
                    remainder += "0";
                else
                    remainder += "1";
            }
        }
        return remainder.substring(1,remainder.length());
    }
}
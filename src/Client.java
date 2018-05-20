import java.io.*;
import java.net.*;

class Client{
	

     
     public static void main(String[] args) throws Exception {
    	 Socket s = new Socket("127.0.0.1", 9090);
         BufferedReader input =
             new BufferedReader(new InputStreamReader(s.getInputStream()));
         
         PrintWriter out = new PrintWriter(s.getOutputStream(), true);
         
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String str = br.readLine();
         
         str = Kripto.AESenc.encrypt(str);
         out.println(str);
         
         
         while(true) {
         String answer = input.readLine();
         answer = Kripto.AESenc.decrypt(answer);
         System.out.println(answer);
         }
     //    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
     //    out.println("hosbuldum");
     }
}
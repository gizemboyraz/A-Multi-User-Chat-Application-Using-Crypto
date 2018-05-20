import java.io.*;
import java.net.*;
import java.util.HashSet;

class CharServer{
	
	private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
     
     public static void main(String[] args) throws IOException {
         ServerSocket listener = new ServerSocket(9090);
         try {
             while (true) {             
                	                	 
                	 new Sait(listener.accept()).start();
                	 
             }
         }
         finally {
             listener.close();
         }
     }
	
	public static class Sait extends Thread {
		private Socket socket;
		BufferedReader in;
	    PrintWriter out;
	    
		public Sait(Socket socket) {
				this.socket = socket;
		}
		
		public void run() {
			try {
				BufferedReader in = new BufferedReader(
				        new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				 writers.add(out);
				 
				 String gelen = in.readLine();
				 
				 for (PrintWriter writer : writers) {
                     writer.println(gelen);
                 }
				 
				 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}		
	}     
}
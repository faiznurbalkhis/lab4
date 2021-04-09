package exercise4;

import java.net.*;
import java.io.*;

public class ServerTranslationApplication {

	public static void main(String[] args) throws IOException{
		
		ServerSocket serversocket = null;
		
		try {
			
			int portNo = 4228;
			serversocket = new ServerSocket(portNo);
			
			String text1 = "Good afternoon";
			System.out.println("Waiting for request!");
			
			while(true) {
				
				Socket clientSocket = serversocket.accept();
				
				DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
				
				outputStream.writeUTF(text1);
				
				clientSocket.close();
				
			}
			
		}catch(IOException ioe) {
			
			if(serversocket != null) {
				serversocket.close();
				
				ioe.printStackTrace();
			}
		}
	}
}

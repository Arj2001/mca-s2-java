import java.io.*;
import java.net.*;

public class ClientSocket {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		try {
			
			Socket s = new Socket("localhost", 6667);
			System.out.println("Connected to server with port 6667");
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hello server with port 657");
			dout.flush();
			dout.close();
			s.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

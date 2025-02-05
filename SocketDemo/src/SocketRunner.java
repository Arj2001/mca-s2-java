import java.io.*;

import java.net.*;
public class SocketRunner {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(6667);
			Socket s = ss.accept();
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = (String)dis.readUTF();
			
			System.out.println("message" + str);
			s.close();
			ss.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
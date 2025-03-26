import java.io.*;
import java.net.*;
public class TCPServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(12345);
			Socket s = ss.accept();
			DataInputStream in  = new DataInputStream(s.getInputStream());
			String value = in.readUTF();
			System.out.println(value);
			ss.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class TCPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket("localhost", 12345);
			
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			Scanner in = new Scanner(System.in);
			
			out.writeUTF(in.nextLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

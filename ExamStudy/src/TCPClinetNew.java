
import java.io.*;
import java.net.*;
import java.util.*;
public class TCPClinetNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Socket s = new Socket("localhost",7090);
			
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			DataInputStream input = new DataInputStream(s.getInputStream());
			Scanner in = new Scanner(System.in);
			
			while(true) {
				System.out.print("Client:");
				String str = in.nextLine();
				out.writeUTF(str);
				if(str.equals("exit")) break;
				str = input.readUTF();
				System.out.println("Server: "+ str);
			}
			s.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}

}

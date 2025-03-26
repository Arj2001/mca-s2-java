import java.io.*;
import java.net.*;
import java.util.*;
public class TCPServerNew {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket ss = new ServerSocket(7090);
			Socket s = ss.accept();
			
			DataInputStream input = new DataInputStream(s.getInputStream());
			DataOutputStream output = new DataOutputStream(s.getOutputStream());
			Scanner in = new Scanner(System.in);
			while(true) {
				String str = input.readUTF();
				if(str.equals("exit")) break;
				System.out.println("Client:"+str);
				System.out.print("Server:");
				str = in.nextLine();
				output.writeUTF(str);
			}
			in.close();
			s.close();
			ss.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

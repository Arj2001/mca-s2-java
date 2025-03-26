import java.net.*;
import java.io.*;
public class UDPServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket s = new DatagramSocket(1234);
			
			DatagramPacket p = new DatagramPacket(new byte[1024],1024);
			s.receive(p);
			String str =new String( p.getData()).trim();
			System.out.println(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

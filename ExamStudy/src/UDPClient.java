import java.net.*;
import java.io.*;
public class UDPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket s =  new DatagramSocket();
			InetAddress ip = InetAddress.getLocalHost();
			String input = "Hello";
			DatagramPacket p = new DatagramPacket(input.getBytes(), input.length(), ip,1234 );
			s.send(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

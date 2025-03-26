import java.io.*;
import java.net.*;
import java.util.*;
public class UDPClientNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket ds = new DatagramSocket();
			InetAddress ip = InetAddress.getLocalHost();
			Scanner in = new Scanner(System.in);
			byte[] input = new byte[1024];
			DatagramPacket dp = new DatagramPacket(input, input.length);
			while(true) {
				System.out.print("Client:");
				String str = in.nextLine();
				ds.send(new DatagramPacket(str.getBytes(), str.getBytes().length, ip, 1090));
				if(str.equals("exit")) break;
				ds.receive(dp);
				str = new String(dp.getData()).trim();
				System.out.println("Server:"+str);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

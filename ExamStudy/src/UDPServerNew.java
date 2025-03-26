import java.io.*;
import java.net.*;
import java.util.*;
public class UDPServerNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramSocket ds = new DatagramSocket(1090);
			Scanner in = new Scanner(System.in);
			byte input[] = new byte[1024]; 
			
			DatagramPacket dp = new DatagramPacket(input, input.length);
			while(true) {
				ds.receive(dp);
				String str = new String(dp.getData()).trim();
				System.out.println("Client:"+str);
				if(str.equals("exit")) break;
				System.out.print("Server:");
				str = in.nextLine();
				dp.setData(str.getBytes());
				ds.send(dp);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

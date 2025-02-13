package UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = null;
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter message: ");
            String message = in.nextLine();
            byte[] buffer = message.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, address,3560);
            socket.send(packet);
            if(message.equals("close")) break;
            socket.receive(packet);
            System.out.println("Received: "+new String(packet.getData()));
        }
        socket.close();
    }
}

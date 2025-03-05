package UDP;

import java.io.IOException;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws IOException{
        DatagramSocket socket = new DatagramSocket(3560);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        while(true){
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            if(received.equals("close")) break;
            System.out.println("Received: "+received);
            socket.send(packet); //echo back
        }
        socket.close();
    }
}

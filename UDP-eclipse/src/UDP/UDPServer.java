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
            String message =  new String(packet.getData()).trim();
            if(message.equals("close")) break;
            System.out.println("Received: "+new String(packet.getData()));
            socket.send(packet); //echo back
        }
        socket.close();
    }
}

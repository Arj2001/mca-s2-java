import java.net.*;
import java.io.*;

public class Clientpgm {
 public static void main(String[] args) throws IOException {
 Socket socket = new Socket("localhost", 5002);
 System.out.println("Connected to server");

 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
 BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

 String line;
 while (true) {
 System.out.print("Client: ");
 String clientMessage = console.readLine();
 out.println(clientMessage);
 if (clientMessage.equals("exit"))
 break;
 line = in.readLine();
 System.out.println("Server: " + line);
 }

 socket.close();
 }
}
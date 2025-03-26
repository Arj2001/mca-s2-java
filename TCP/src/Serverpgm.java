import java.net.*;
import java.io.*;

public class Serverpgm {
	public static void main(String[] args) throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(5002)) {
			Socket socket = serverSocket.accept();
			System.out.println("Client connected");

			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

			String line;
			while ((line = in.readLine()) != null) {
				System.out.println("Client: " + line);
				System.out.print("Server: ");
				String serverResponse = console.readLine();
				out.println(serverResponse);
				if (line.equals("exit"))
					break;
			}
		}
	}
}
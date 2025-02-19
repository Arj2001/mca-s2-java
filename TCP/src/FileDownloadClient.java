import java.io.*;
import java.net.*;

public class FileDownloadClient {
    public static void main(String[] args) {
        // Specify the server address and the file to download
        String serverAddress = "api.time.com"; // Replace with your server address
        int port = 80; // Use the appropriate port (default HTTP port 80)
        String filePath = "/wp-content/uploads/2025/02/early-onset-cancer-001.jpg"; // Path of the file on the server
        
        // Specify the location where you want to save the downloaded file
        String saveLocation = "early-onset-cancer-001.jpg";
        
        try (Socket socket = new Socket(serverAddress, port)) {
            // Output to the server (for requesting the file)
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            
            // Send an HTTP GET request (assuming a simple HTTP server)
            writer.println("GET " + filePath + " HTTP/1.1");
            writer.println("Host: " + serverAddress);
            writer.println("Connection: close");
            writer.println();
            
            // Input stream from the server
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            
            // Skip the HTTP headers (lines before the empty line)
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) {
                    break; // End of headers
                }
            }
            
            // Save the file content
            try (FileOutputStream fileOutputStream = new FileOutputStream(saveLocation)) {
                int bytesRead;
                byte[] buffer = new byte[4096]; // Buffer for reading the file data
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
                System.out.println("File downloaded successfully!");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

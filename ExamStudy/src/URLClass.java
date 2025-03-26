import java.io.*;
import java.net.*;

public class URLClass {
    
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.shutterstock.com/image-illustration/robot-crash-test-dummy-sitting-600nw-2051238215.jpg");
            URLConnection urlCon = url.openConnection();
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());

            InputStream inputStream = urlCon.getInputStream();
            int c;
            FileOutputStream fileOutputStream = new FileOutputStream("dummy.png");
            while ((c = inputStream.read()) != -1) {
                fileOutputStream.write(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

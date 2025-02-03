package Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderV {
    public static void main(String[] args) throws IOException {
        FileReader f = null;
        try {
            f = new FileReader("Files/sample.txt");
            BufferedReader b = new BufferedReader(f);
            String s;
            while ((s=b.readLine()) != null) {
                System.out.println(s);
            }
            b.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        f.close();
    }
}

package Files;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
    
    public static void main(String[] args) throws IOException{
        
        FileOutputStream f1 = null;
        try {
            f1 = new FileOutputStream("Files/new.txt");
            String str = "Hello World";
            for (int i = 0; i < str.length(); i++) {
                f1.write(str.charAt(i));
            }
            System.out.println("File wrote successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        f1.close();
    }
}

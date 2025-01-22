package Files;

import java.io.*;
public class ReadStringtoFile {

    public static void main(String[] args) throws IOException {
        FileOutputStream f1 = null;
        FileOutputStream f2 = null;
        FileOutputStream f3 = null;
        try {
            f1 = new FileOutputStream("Files/file1.txt");
            f2 = new FileOutputStream("Files/file2.txt");
            f3 = new FileOutputStream("Files/file3.txt");
            String str = "Hello World";
            for (int i = 0; i < str.length(); i=i+2) {
                f1.write(str.charAt(i));
            }
            for (int i = 0; i < str.length(); i++) {
                f2.write(str.charAt(i));
            }
            String str2 = str.substring(2, 7);
            for (int i = 0; i < str2.length(); i++) {
                f3.write(str2.charAt(i));
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
        f1.close();
        f2.close();
        f3.close();
    }

        
}

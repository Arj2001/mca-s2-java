package ExceptionHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileNotFound {
    
    public static void main(String[] args) throws IOException{
        FileInputStream f;
        try {
            f = new FileInputStream("ExceptionHandling/sample.txt");
            int c;
            do{
                c = f.read();
                if(c!=-1){
                    System.out.print((char)c);
                }
            }while(c!=-1);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
        f.close();
    }
}

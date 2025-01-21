package Files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RdfCopy{

    public static void main(String[] args) throws IOException{

        FileInputStream f1 = null;
        FileOutputStream f2 = null;
        try {
            f1 = new FileInputStream("Files/sample.txt");
            f2 = new FileOutputStream("Files/samplecopy.txt");
            int c;
            do{
                c = f1.read();
                if(c!=-1){
                    f2.write(c);
                    // System.out.print();
                }
            }while(c!=-1);
            System.out.println("File copied successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
        f1.close();
        f2.close();
    }
}
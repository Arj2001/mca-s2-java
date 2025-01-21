package Files;

import java.io.*;

public class ReadFile {
    public static void main(String[] arg) throws IOException{

        FileInputStream f;
        try {
            f = new FileInputStream("Files/sample.txt");
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

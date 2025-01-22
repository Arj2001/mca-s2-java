package Files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileCommand {
    
    public static void main(String[] args) throws IOException{
        FileInputStream f;
        Scanner scan = new Scanner(System.in);
        String file = scan.nextLine();
        
        try {
            f = new FileInputStream("Files/"+file);
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

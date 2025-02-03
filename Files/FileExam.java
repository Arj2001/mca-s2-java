package Files;

import java.io.File;

public class FileExam  {
    
    public static void main(String[] args) {
        File directory = new File("Files");
        if(directory.isDirectory()){
            File [] files = directory.listFiles();
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
}

package FileClasses;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class FileHandler {

    String fileContent;
    private String filePath;


    public FileHandler(String filePath) {
        if (filePath == null) {
            System.out.println("enter a valid value as filepath");
            return;
        }
        if (this.fileContent != null && filePath.equals(this.fileContent)) {
            // new file, remove old contents
            this.fileContent = null;
        }
        if (filePath != this.filePath) {
            this.fileContent = null;
        }
        this.filePath = filePath;
        
    }


    public void readFile() throws IOException {
        this.fileContent = new String(Files.readAllBytes(Paths.get(this.filePath)));
    }
    
    public void printContent() throws IOException {
        System.out.println(this.fileContent);
    }

    public String returnfileContent() throws IOException {
        return this.fileContent;
    }


    // public static void main(String[] args) {
    //     if (args.length != 1) {
    //         System.out.println("Usage: java FileHandler <path/to/file>");
    //         return;
    //     }
    //     FileHandler fileHandler = new FileHandler(args[0]);
        
    //     System.out.println("about to read file in main!");
    //     try {
    //         fileHandler.readFile();
    //         System.out.println("done reading file in main!");

    //         // fileHandler.printContent();
    //         // System.out.println("Hello, World2!");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
}
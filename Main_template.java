
import java.io.IOException;

import FileClasses.FileHandler;
import FileClasses.FileLineParser;

public class Main_template {
    public static void main(String[] args) {
        String content;
        // FileHandler myFileHandler = new FileHandler("/Users/luca.knobloch/repos/advent_of_code/Day03/day_03_debug.txt");
        // FileHandler myFileHandler = new FileHandler("/Users/luca.knobloch/repos/advent_of_code/Day03/day_03.txt");

        try {
            myFileHandler.readFile();
            content = myFileHandler.returnfileContent();
            FileLineParser myFileLineParser = new FileLineParser(content);
            String line = myFileLineParser.getLine();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

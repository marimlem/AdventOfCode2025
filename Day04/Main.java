package Day04;

import java.io.IOException;

import FileClasses.FileHandler;
import FileClasses.FileLineParser;

public class Main {
    public static void main(String[] args) {
        String content;
        FileHandler myFileHandler = new FileHandler("/Users/luca.knobloch/repos/advent_of_code/Day04/day_04_debug.txt");
        // FileHandler myFileHandler = new FileHandler("/Users/luca.knobloch/repos/advent_of_code/Day04/day_04.txt");

        try {
            myFileHandler.readFile();
            content = myFileHandler.returnfileContent();
            FileLineParser myFileLineParser = new FileLineParser(content);
            // String line = myFileLineParser.getLine();
            String [] myStringArr = myFileLineParser.getAllLines();

            // DAY FOUR
            Matrix myMatrix = new Matrix();
            myMatrix.initMatrixWStringArray(myStringArr);
            myMatrix.paperLogic();
            // myMatrix.printMatrix(0);
            // myMatrix.printMatrix(1);
            System.out.println("rolls accessible: " + myMatrix.countWhereBelowN(4));

            // myMatrix.printMatrix(0);
            // myMatrix.printMatrix(1);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

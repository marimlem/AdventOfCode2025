package Day03;

import java.io.IOException;

import FileClasses.FileHandler;
import FileClasses.FileLineParser;

public class Main {
    public static void main(String[] args) {
                String content;
        // FileHandler myFileHandler = new FileHandler("/Users/luca.knobloch/repos/advent_of_code/Day03/day_03_debug.txt");
        FileHandler myFileHandler = new FileHandler("/Users/luca.knobloch/repos/advent_of_code/Day03/day_03.txt");

        try {
            myFileHandler.readFile();
            content = myFileHandler.returnfileContent();
            FileLineParser myFileLineParser = new FileLineParser(content);
            String line = myFileLineParser.getLine();
            
            // day three  starts here
            Joltage myJoltage;
            int joltageSum = 0;
            long joltageSumPart2 = 0;
            while (line != null) {
                myJoltage = null;
                myJoltage = new Joltage(line);
                joltageSum += myJoltage.getDigitsAsInt();
                joltageSumPart2 += myJoltage.getDigitsAsIntPart2();
                line = null;
                line = myFileLineParser.getLine();
            }
            System.out.println("final result: " + joltageSum);
            System.out.println("final result part 2: " + joltageSumPart2);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

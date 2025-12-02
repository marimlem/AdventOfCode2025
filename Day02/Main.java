package Day02;

import java.io.IOException;

import FileClasses.FileHandler;
import FileClasses.FileLineParser;

public class Main {
    public static void main(String[] args) {

        String content;
        // FileHandler myFileHandler = new FileHandler("/Users/luca.knobloch/repos/advent_of_code/Day02/day_02-0_debug.txt");
        FileHandler myFileHandler = new FileHandler("/Users/luca.knobloch/repos/advent_of_code/Day02/day_02-0.txt");

        try {
            myFileHandler.readFile();
            // myFileHandler.printContent();
            content = myFileHandler.returnfileContent();
            // System.out.println(content);
            FileLineParser myFileLineParser = new FileLineParser(content);
            
            
            // day two  starts here
            String line = myFileLineParser.getLine();

            String []ranges;
            ranges = line.split(",");
            
            Range myRange = new Range(ranges[0]);
            long totalSumOfIds = 0;
            int index = 0;

            while (true) {

                System.out.println("\n---range: " + ranges[index] + "  ----");
                myRange.loopThroughIds();
                System.out.println("sumOfIds range " + index +": " + myRange.getSumOfIds());
                totalSumOfIds += myRange.getSumOfIds();
                index++;
                if (index >= ranges.length) {
                    break;
                }
                myRange = null;
                myRange = new Range(ranges[index]);
                
            }

            System.out.println("total sum of ids: " + totalSumOfIds);
            // while (true) {
    
                // System.out.println(ranges[0]);
                // System.out.println(ranges.length);


            // }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


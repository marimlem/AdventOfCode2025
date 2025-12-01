import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // hello world
        // System.out.println("Hello, World!");

        String content;
        // read file class
        // FileHandler myFileHandler = new FileHandler("/Users/luca.knobloch/repos/advent_of_code/day_01-0_debug.txt");
        // FileHandler myFileHandler = new FileHandler("/Users/luca.knobloch/repos/advent_of_code/day_01-0_debug-testing.txt");
        FileHandler myFileHandler = new FileHandler("/Users/luca.knobloch/repos/advent_of_code/day_01-0.txt");
        try {
            myFileHandler.readFile();
            // myFileHandler.printContent();
            content = myFileHandler.returnfileContent();
            // System.out.println(content);
            FileLineParser myFileLineParser = new FileLineParser(content);


            // the day one loop starts here

            String line = myFileLineParser.getLine();
            int currentDialPosition;
            int zeroCount = 0;
            Dial myDial = new Dial();

            while (line != null) {

                try {
                    // System.out.println(line.replaceAll("[LR]", ""));
                    int number = Integer.parseInt(line.replaceAll("[LR]", ""));
                    // System.out.println(line.charAt(0));
                    // System.out.println(number);

                    currentDialPosition = myDial.rotateDial(line.charAt(0), number);
                    // System.out.println("current dial position: " + currentDialPosition);
                    if (currentDialPosition > 99 || currentDialPosition < 0) {
                        System.out.println("something's wrong: "+ line + " -> " + currentDialPosition);
                    }
                    if (currentDialPosition == 0) {
                        zeroCount++;
                    }

                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format: " + line);
                }
                

                //new lines begins
                line = myFileLineParser.getLine();
            }
            System.out.println("this is the final zero count: " + zeroCount);





        } catch (IOException e) {
            e.printStackTrace();
        }        // String content2 = myFileHandler.

    }
}
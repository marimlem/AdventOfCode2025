package FileClasses;
public class FileLineParser {
    String[] lines; //= content.split("\n");
    int pointer;

    public FileLineParser(String content) {
        this.lines =  content.split("\n");
        pointer = 0;
    }

    public String getLine() {
        if (this.lines.length == this.pointer) {
            System.out.println("EOF; pointer is reset to first line");
            this.pointer = 0;
            return null;
        }
        return this.lines[this.pointer++];
    }
}
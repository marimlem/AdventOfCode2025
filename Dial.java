public class Dial {
    int number;

    public Dial() {
        number = 50;
    }

    public void rotateRight(int rotation) {
        int newnumber;
        newnumber = this.number + rotation;
        
        while (newnumber > 99) {
            newnumber -= 100;
        }
        this.number = newnumber;

        return ;
    }

    public void rotateLeft(int rotation) {
        int newnumber = this.number - rotation;
        // System.out.println("debug new number: " + newnumber);


        while (newnumber < 0){
            newnumber += 100;
        }
        this.number = newnumber;

    }

    public int rotateDial(char direction, int rotation) {
        if (direction == 'L') {
            // System.out.println("rotating left by " + rotation + " from current position: " + number);
            rotateLeft(rotation);
        }
        else if (direction == 'R') {
            // System.out.println("rotating right by " + rotation + " from current position: " + number);
            rotateRight(rotation);
        }
        return this.number;
    }
}

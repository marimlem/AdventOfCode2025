package Day01;
public class Dial {
    int number;
    int zeroClicks;

    public Dial() {
        number = 50;
        zeroClicks = 0;
    }

    public void rotateRight(int rotation) {
        int newnumber;
        newnumber = this.number + rotation;
        while (newnumber > 99) {
            newnumber -= 100;
            zeroClicks++;
        }

        this.number = newnumber;

        return ;
    }

    public void rotateLeft(int rotation) {
        int newnumber = this.number - rotation;
        // System.out.println("debug new number: " + newnumber);
        if (newnumber < 0 && this.number == 0) {
            zeroClicks--;
        }

        while (newnumber < 0){
            newnumber += 100;
            zeroClicks++;
        }
        if (newnumber == 0) {
            zeroClicks++;
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

    public int getZeroClicks() {
        return this.zeroClicks;
    }
}

package Day03;

public class Joltage {
    int firstDigit;
    int secondDigit;

    int []arrayDigits;

    int []battery;

    public Joltage (String bank) {
        if (bank == null) {
            return ;
        }
        this.firstDigit = 0;
        this.secondDigit = 0;

        this.battery = new int [bank.length()];
        this.arrayDigits = new int [12];

        for (int i = 0; i < bank.length(); i++) {
            this.battery[i] = Integer.valueOf(bank.charAt(i)) - 48;
            // System.out.println("battery " + battery[i]);
        }

        // PART ONE
        this.secondDigit = this.battery[this.battery.length - 1];
        this.firstDigit = this.battery[this.battery.length - 2];
        // System.out.println("first and second digit" + firstDigit + " " + secondDigit);

        findBiggestDigits();


        // PART TWO
        for (int c = 11, b = this.battery.length - 1 ; c >= 0; c--, b--) {
            // static int b = this.battery.length - 1;
            this.arrayDigits[c] = this.battery[b];
            // System.out.println("debug indexes b and c and value " + b + " " + c + " " + this.arrayDigits[c] );
        }
        findBiggestDigitsPart2();
    }

    public void compareReplace(int indexL, int indexR){ //index LEFT and index RIGHT
        // check if out of bounds indexR > len 
        if (this.arrayDigits.length <= indexR) {
            return ;
        }


        if (this.arrayDigits[indexL] >= this.arrayDigits[indexR]) {
            compareReplace(indexL + 1, indexR + 1);
            this.arrayDigits[indexR] = this.arrayDigits[indexL];
        }
        return ;
    }

    public void findBiggestDigitsPart2() {
        int a = 0;
        // for (int i = 0; i < this.arrayDigits.length; i++){
        //     System.out.print(this.arrayDigits[i]);
        // }
        // System.out.print("\n");
        for (int i = this.battery.length - 13; i >= 0; i --) {
            if (this.battery[i] >= this.arrayDigits[a]) {

                compareReplace(a, a + 1);
                this.arrayDigits[a] = this.battery[i];
            }

        }
        // for (int i = 0; i < this.arrayDigits.length; i++){
        //     System.out.print(this.arrayDigits[i]);
        // }
        // System.out.println("\n----\n");

        
    }

    public long getDigitsAsIntPart2() {
        long result = 0;
        for (int i = 0; i < this.arrayDigits.length; i++) {
            result = result * 10 + this.arrayDigits[i];
        }
        return (result);
    }

    public void findBiggestDigits() {
        for (int i = this.battery.length - 3; i >= 0; i --) {
            // System.out.println(this.battery[i]);
            if (this.battery[i] >= this.firstDigit) {
                if (this.secondDigit < this.firstDigit) {
                    this.secondDigit = this.firstDigit;
                    // System.out.println("replaced second digit to " + this.secondDigit);
                }
                this.firstDigit = this.battery[i];
                // System.out.println("replaced first digit to " + this.firstDigit);
            }
        }
        // System.out.println("final: " + this.firstDigit + " " + this.secondDigit);
    }

    public int getDigitsAsInt() {
        return (this.firstDigit * 10 + this.secondDigit);
    }
}

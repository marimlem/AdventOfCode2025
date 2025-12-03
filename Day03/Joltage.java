package Day03;

public class Joltage {
    int firstDigit;
    int secondDigit;

    int []battery;

    public Joltage (String bank) {
        if (bank == null) {
            return ;
        }
        this.firstDigit = 0;
        this.secondDigit = 0;

        this.battery = new int [bank.length()];

        for (int i = 0; i < bank.length(); i++) {
            this.battery[i] = Integer.valueOf(bank.charAt(i)) - 48;
            // System.out.println("battery " + battery[i]);
        }

        this.secondDigit = this.battery[this.battery.length - 1];
        this.firstDigit = this.battery[this.battery.length - 2];
        // System.out.println("first and second digit" + firstDigit + " " + secondDigit);

        findBiggestDigits();
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

package Day02;

public class Range {
    String range;

    String firstId;
    long firstId_int;
    String lastId;
    long lastId_int;

    long number_i;
    String number_s;

    long sumOfIds;

    public Range(String range) {
        this.sumOfIds = 0;
        this.range = range;
        String []tmp = range.split("-");
        if (tmp.length != 2) {
            System.err.println("Some error");
            return ;
        }
        this.firstId = tmp[0];
        this.firstId_int = Long.parseLong(firstId);
        this.lastId = tmp[1];
        this.lastId_int = Long.parseLong(lastId);
    }



    public long loopThroughIds() {
        this.number_i = Long.parseLong(this.firstId);
        this.number_s = this.firstId;

        // System.out.println("loop started");
        while (this.number_i <= this.lastId_int) {
            // System.out.println(number_i + " and " + number_s);
            //logic goes here


            if (this.number_i == 565656) {

                System.out.println("565656 whats happening " + number_s);
            }
            // if (isRepeatedTwice(this.number_s) == 1) {
            //     this.sumOfIds += number_i;
            // }
            if (isRepeatedAnyTimes(this.number_s) == 1) {
                this.sumOfIds += this.number_i;
            }
            else if (isAllOneNumber(this.number_s) == 1) {
                this.sumOfIds += this.number_i;
            }


            // to the next loop
            this.number_i++;
            this.number_s = String.valueOf(this.number_i);
        }
        return (this.sumOfIds);
    }

    public long getSumOfIds() {
        return this.sumOfIds;
    }

    public int isInvalidId(String id) {
        if (id.charAt(0) == '0') {
            return 1;
        }
        return 0;
    }

    public int isAllOneNumber(String id) {
        if (id.length() == 1) {
            return 0;
        }
        for (int i = 1 ; i < id.length(); i++) {
            if (id.charAt(0) != id.charAt(i)) {
                return 0 ;
            }
            else {
                continue ;
            }
        }
        System.out.println("is all one number: " + id);
        return 1;
    }
// len = 8, divider = 4;
// 0123 4567
// 0000 0000

//len = 6, divider = 3;
//len = 6, divider = 2;

    public int compareSetsOfD(String id, int d) {
        Long a, b;

        for (int i = d; i < id.length() ; i = i + d) {
            // System.out.println("debug id: "+ id +" i: " + i + " d: " + d + " len: " + id.length());
            if (i + d > id.length()) {
                return 0;
            }
            a = Long.parseLong(id.substring(0, d));
            b = Long.parseLong(id.substring(i, i+d));
            // System.out.println("a and b: " + a + " " +  b);
            if (!a.equals(b)) {
                return 0; // not the same
            }
        }
        System.out.println("set repeated: " + id);
        return 1; // the set is repeated
    }

    public int isRepeatedAnyTimes(String id){

        int len = id.length();
        int divider = id.length() / 2;

        if (this.number_i == 1188511885) {
            System.out.println("debug time 1188511885");
        }
        while (divider >= 2 && len % divider != 0) {
            divider --;
        }

        while (divider >= 2) {
            if (compareSetsOfD(id, divider) == 1) {
                return 1;
            }
            divider --;
            // while (len % divider != 0 && divider >= 2) {
            // }
        }
        return 0;
    }

    public int isRepeatedTwice(String id) {
        int len = id.length();
        if (len % 2 != 0) {
            // System.out.println("id is uneven");
            return 0;
        }
        String firstHalf = id.substring(0, len/2);
        String secondHalf = id.substring(len/2, len);
        // System.out.println("substr: " + firstHalf + " + " + secondHalf);
        if (firstHalf.equals(secondHalf)) {
            // System.out.println("numbers in ID are repeated twice! " + id);
            return 1;
        }
        // System.out.println("not a repeated id " + id);
        return 0;
    }
}

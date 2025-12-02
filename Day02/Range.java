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
        // System.out.println("firstId " + this.firstId + " " + this.firstId_int);
        // System.out.println("lastId " + this.lastId + " " + this.lastId_int);

        // if (isInvalidId(this.firstId) == 1) {
        //     System.out.println("0 in the beginning");
        //     this.sumOfIds += number_i;
        // }
        // System.out.println("Range constructor finished");
    }



    public long loopThroughIds() {
        this.number_i = Long.parseLong(this.firstId);
        this.number_s = this.firstId;

        // System.out.println("loop started");
        while (this.number_i <= this.lastId_int) {
            // System.out.println(number_i + " and " + number_s);
            //logic goes here


            if (isRepeatedTwice(this.number_s) == 1) {
                this.sumOfIds += number_i;
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

    public int isRepeatedTwice(String id) {
        int len = id.length();
        if (len % 2 != 0) {
            // System.out.println("id is uneven");
            return 0;
        }
        String firstHalf = id.substring(0, len/2);
        String secondHalf = id.substring(len/2, len);
        // System.out.println("substr: " + firstHalf + " + " + secondHalf);
        if (Long.parseLong(firstHalf) == Long.parseLong(secondHalf)) {
            // System.out.println("numbers in ID are repeated twice! " + id);
            return 1;
        }
        // System.out.println("not a repeated id " + id);
        return 0;
    }
}

package Day04;

public class Matrix {
    char [][] matrix;
    char [][] layer;

    int leny;
    int lenx;

    int y; // [y][x]
    int x; 
    

    public void initMatrixWStringArray(String []stringArray) {
        this.x = 0;
        this.y = 0;
        this.lenx = stringArray[0].length();
        this.leny = stringArray.length;
        // System.out.println("string array length and string array[]0 length: " + stringArray.length + " " + stringArray[0].length());
        this.matrix = new char[stringArray.length][stringArray[0].length()];
        this.layer = new char[stringArray.length][stringArray[0].length()];
        // System.out.println("matrix length " + this.matrix.length);

        for (int i = 0; i < this.matrix.length; i++) {
            this.matrix[i] = stringArray[i].toCharArray();
            for (int j = 0 ; j < this.matrix[i].length; j++) {
                this.layer[i][j] = '0';
            }
            // System.out.println(this.matrix[i]);
            // System.out.println(this.layer[i]);
        }

    }


    public int countWhereBelowN(int n) {
        this.x = 0;
        this.y = 0;
        int accessibleCount = 0;
        while (true) {
            if (this.matrix[this.y][this.x] == '@' && this.layer[this.y][this.x] < '4') {
                accessibleCount++;
            }
            if (traverseMatrix() == 1) {
                break;
            }
        }
        return accessibleCount;
    }

    public int checkAdjacentFields() {
        int tmpy = this.y;
        int tmpx = this.x;
        int count = 0;

        if (tmpy != 0) {
            tmpy = tmpy-1;
        }
        if (tmpx != 0) {
            tmpx = tmpx -1;
        }
        // if (this.x == 4 && this.y == 9) {
        //     System.out.println("debug time x=4 y=9");
        // }
        if (this.matrix[this.y][this.x] == '.') {
            return -2;
        }
        // System.out.println("\n\n=====\nadjacent fields for x=" + this.x + " y=" + this.y);
        for (; tmpy < this.leny && tmpy <= this.y + 1; tmpy++) {
            // System.out.println("\n\nstart of row " + tmpy);
            for (; tmpx < this.lenx && tmpx <= this.x + 1; tmpx ++) {
                // System.out.print("x=" + tmpx + " y=" + tmpy + "; ");
                if (tmpx == this.x && tmpy == this.y) {
                    continue ; // dont count the position itself
                }
                if (this.matrix[tmpy][tmpx] == '@') {
                    count++;

                }
            }
            if (this.x != 0){
                tmpx = this.x - 1;
            }
            else {
                tmpx = this.x;
            }
            // tmpy ++;

        }

        return (count);
    }

    public void paperLogic() {
        while (true) {
            layer[this.y][this.x] = (char) (checkAdjacentFields() + 48);
            if (traverseMatrix() == 1) {
                break ;
            }
        }
    }

    public int traverseMatrix() {
        if (this.x < this.lenx -1) {
            this.x++;
            return 0;
        }
        else if (this.y < this.leny -1) {
            this.y++;
            this.x = 0;
            return 0;
        }
        else {
            //eof
            this.y = 0;
            this.x = 0;
            return 1;
        }
    }

    public void printMatrix(int whichOne) {
        char [][] tmp;
        if (whichOne == 0) {
            tmp = this.matrix;
        }
        else {
            tmp = this.layer;
        }
        System.out.print("\n");
        while (true) {
            // System.out.println("y and x " + this.y + " " + this.x);
            System.out.print(tmp[this.y][this.x]);
            if (traverseMatrix() == 1) {
                System.out.print("\n");
                break ;
            }
            if (this.x == 0) {
                System.out.print("\n");
            }
        }
    }


}

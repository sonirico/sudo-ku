public class Sudoku {

    public static final int ROWS = 9, COLS = 9;
    private int [][] cells;

    public Sudoku(){
        this.cells = new int [ROWS][COLS];
        for(int r = 0; r < this.cells.length; r++){
            for(int c = 0; c < this.cells[r].length; c++){
                this.cells[r][c] = 0;
            }
        }
    }


    public Sudoku(int [][] newCells){
        this.cells = newCells;
    }

    public int[][] get(){
        return this.cells;
    }

    public void set(int [][] newCells){
        this.cells = newCells;
    }


    // ---

    public boolean emptyCell(int r, int c){
        //TODO: check bounds
        return this.cells[r][c] == 0;
    }


    public boolean inRow(int row, int n){
        if (row >= ROWS || row < 0 ) throw new Error("Row out of bounds: " + row);

        for(int c = 0; c < this.cells[row].length; c++){
            if ( this.cells[row][c] == n){
                //System.out.println("Found in row. ("+row+", "+c+") = " + n);
                return true;
            }
        }

        return false;
    }

    public boolean inCol(int col, int n){
        if (col >= COLS || col < 0 ) throw new Error("Col out of bounds: " + col);

        for(int r = 0; r < this.cells.length; r++){
            if ( this.cells[r][col] == n){
                //System.out.println("Found in col. ("+r+", "+col+") = " + n);
                return true;
            }
        }

        return false;
    }

    public boolean inDiagons(int n){

        for(int r = 0; r < this.cells.length; r++){
            if ( this.cells[r][r] == n){
                return true;
            }
            else if (this.cells[this.cells.length - r - 1][r] == n ){
                return true;
            }
        }

        return false;
    }



    public boolean inQuadrant(int row, int col, int n){
        int rmin = (row / 3) * 3;
        int rmax = rmin + 3;
        int cmin = (col / 3) * 3;
        int cmax = cmin + 3;
        for (int r = rmin; r < rmax; r++){
            for (int c = cmin; c < cmax; c++){
                if (this.cells[r][c] == n ){
                    //System.out.println("Found in row. ("+r+", "+c+") = " + n);
                    return true;
                }
            }
        }
        return false;
    }

    public void setCell(int r, int c, int n){
        //TODO: Check bounds
        this.cells[r][c] = n;
        //System.out.println("Set " + n + "in ( " + r + ", " + c + " )");
    }

    // ---

    public boolean hasZeros(){
        int nZeros = 0;
        for(int r = 0; r < this.cells.length; r++){
            for(int c = 0; c < this.cells[r].length; c++){
                if (this.cells[r][c] == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean looksPromising(int r, int c, int num){
        return !this.inCol(c, num) && !this.inRow(r, num) && !this.inQuadrant(r, c, num) ;//&& !this.inDiagons(num);		
    }




    public void print (){
        for(int r = 0; r < this.cells.length; r++){
            if (r % 3 == 0){
                System.out.print("\n");
            }
            for(int c = 0; c < this.cells[r].length; c++){
                if (c % 3 == 0){
                    System.out.print("\t");
                }
                if (this.cells[r][c] > 0){
                    System.out.print("|" + this.cells[r][c]);
                } else {
                    System.out.print("|·");
                }
            }
            System.out.print("|\n");

        }		
        System.out.print("--------------------------------------\n");
    }


}

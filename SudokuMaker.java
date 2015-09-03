public class SudokuMaker {

    public static final int [] numbers = new int [] {
        1, 2, 3, 4, 5, 6, 7, 8, 9
    };

    public static int nSolutions = 0;

    public static void main (String args[]){
        int [][] s = new int [][]{
                {9, 0, 6,   0, 7, 0,    4, 0, 3},
                {0, 0, 0,   4, 0, 0,    2, 0, 0},
                {0, 7, 0,   0, 2, 3,	0, 1, 0},

                {5, 0, 0,   0, 0, 0,    1, 0, 0},
                {0, 4, 0,   2, 0, 8,    0, 6, 0},
                {0, 0, 3,   0, 0, 0,    0, 0, 5},

                {0, 3, 0,   7, 0, 0,    0, 5, 0},
                {0, 0, 7,   0, 0, 5,    0, 0, 0},
                {4, 0, 5,   0, 1, 0,    7, 0, 8}
        };
        Sudoku sudoku = new Sudoku(s);

        System.out.println("Processing this sudoku ...");

        sudoku.print();

        backtracking(sudoku);
        System.out.println(nSolutions + " found");
    }

    private static boolean backtracking(Sudoku sk){


        if (!sk.hasZeros()) {
            sk.print();
            nSolutions++;
            return false;
        } else { 

            int r = -1, c= -1;


            for (r = 0 ; r < sk.ROWS; r++){
                boolean found = false;
                for ( c = 0; c < sk.COLS ; c++){
                    if (sk.emptyCell(r, c)){
                        found = true;
                        break;
                    }
                }
                if (found )break;
            }

            for ( int n : numbers ){

                if (sk.looksPromising(r, c, n)){
                    sk.setCell(r, c, n);
                    //backtracking(sk);

                    if ( backtracking(sk) ){
                        //continue;//return true;
                    }
                    else{
                        sk.setCell(r, c, 0);
                    }
                }

            }

            return false;
        }
    }
}


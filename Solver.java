package snippet;

public class Solver {


    Checker checker;

    public Solver(Checker grid) {this.checker = grid;}

    public boolean solve(int row, int column ) {

        //System.out.println(row+" "+column);
        if (column == 9 && row == 8) {
            return true;
        }

        if (column == 9) {
            row++;
            column = 0;
        }

        if (checker.Grid[row][column].getvalue() > 0) {
            return solve(row, column + 1);
        }

        for (int i = 1; i <= 9; i++) {
            if (checker.check(row, column, i).check == true) {
                checker.Grid[row][column].SetValue(i);

                if (solve(row, column + 1) == true)
                    return true;
            }
            checker.Grid[row][column].SetValue(0);
        }
        return false;
    }

}

package snippet;


import java.lang.*;
import snippet.Changeable;
public class Checker {

    public Changeable[][] Grid = new Changeable[9][9];


    public void initializing() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                Grid[i][j] = new Changeable(0,true);
            }
        }
    }


    public Pair check(int row, int column, int num) {
        Pair pair = new Pair();

        if ((checkRow(row, column, num).check == false)) {
            pair = checkRow(row, column, num);
            return pair;
        }

        if (checkColumn(row, column, num).check == false) {
            pair = checkColumn(row, column, num);
            return pair;
        }

        if ((checkSquare(row, column, num) == false)) {
            pair.check = false;
            return pair;
        }

        pair.check = true;
        return pair;

    }

    public Pair checkRow(int row, int column, int num) {
        Pair pair = new Pair();
        for (int i = 0; i < 9; i++) {
            if (Grid[row][i].getvalue() == num && i != column) {
                pair.x=row;
                pair.y = i;
                pair.check=false;
                return pair;
            }
        }
        return pair;
    }


    public Pair checkColumn(int row, int column, int num) {
        Pair pair = new Pair();
        for (int i = 0; i < 9; i++) {
            if (Grid[i][column].getvalue() == num && i != row) {
                pair.x=i;
                pair.y = column;
                pair.check=false;
                return pair;
            }
        }
        return pair;
    }

    private boolean checkSquare(int row, int column, int num) {
        int x = 0, y = 0, startx = 0, starty = 0;

        startx = row / 3 * 3;
        starty = column / 3 * 3;
        x = startx + 3;
        y = starty + 3;

        for (int i = startx; i < x; i++) {
            for (int j = starty; j < y; j++) {
                if ((num == Grid[i][j].getvalue()) && (i != row || j != column)) {

                    return false;
                }
            }
        }
        return true;
    }

    public boolean isFilled() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((Grid[i][j].getvalue() > 0) && (Grid[i][j].gety()==true)) return false;
            }
        }
        return true;
    }

    public int random(int max , int min ) {
        int range = (max - min) + 1;
        return (int) (Math.random() * range) + min;
    }

    public void generate(int numberOfGenerated) {
        int row = 0, column = 0, num = 0;

        for (int i = 0; i < numberOfGenerated; ) {
            row = random(0, 8);
            column = random(0, 8);
            num = random(1, 9);
            //System.out.println(row+" "+column+" "+ num);

            if ((check(row, column, num).check == true) && (Grid[row][column].gety() == true)) {
                Grid[row][column].SetValue(num);
                Grid[row][column].Sety(false);
                i++;
            }
        }
    }

   public Checker clon() {

       Checker cloned = new Checker();

       for (int i = 0; i < 9; i++) {
           for (int j = 0; j < 9; j++) {
               Changeable change = new Changeable(Grid[i][j].getvalue(),Grid[i][j].gety());
               cloned.Grid[i][j]=change;

           }
       }
       return cloned;
   }

    public void print() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(Grid[i][j].getvalue() + " ");
            }
            System.out.println();
        }
    }
}

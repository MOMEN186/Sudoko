package snippet;
import java.util.Scanner ;
public class Main {

    public static void main(String[] args) {

        Checker grid = new Checker();
        Checker clonedgrid = new Checker();

        grid.initializing();
        grid.generate(20);
        grid.print();

        clonedgrid = grid.clon();


        Solver solver = new Solver(grid);
        solver.solve(0, 0);

        System.out.println("solution");
        grid.print();

        System.out.println();
        System.out.println("cloned");
        clonedgrid.print();

        Scanner input = new Scanner(System.in);
        int x = 0, y = 0, num = 0, check = 0;

        String s = "";

        do {

            System.out.println("Enter row");
            x = input.nextInt();

            System.out.println("Enter column");
            y = input.nextInt();

            System.out.println("Enter num");
            num = input.nextInt();

            s = input.next();

            if (x > 8 || x < 0) {
                System.out.println("row index from 0 to 8 ");
            } else if (y > 8 || y < 0) {
                System.out.println("column index from 0 to 8 ");
            } else if (num > 9 || num <= 0) {
                System.out.println("numbers range from 1 to 9 ");
            } else {
                if (clonedgrid.check(x, y, num).check == true) {
                    check++;
                    clonedgrid.Grid[x][y].SetValue(num);
                } else
                    System.out.println(" intersected with Row " + grid.check(x, y, num).x + " Column " + grid.check(x, y, num).y);

                if (s.equals("hint")) {
                    int rr = 0, rc = 0; // random row and random column
                    grid = clonedgrid.clon();
                    Solver solver1 = new Solver(clonedgrid);
                    solver1.solve(0, 0);
                    rr = solver1.checker.random(0, 8);
                    rc = solver1.checker.random(0, 8);
                    System.out.println("HINT" + " Row " + rr + " column " + rc + " " + clonedgrid.Grid[rr][rc].getvalue());

                    grid.print();
                } else clonedgrid.print();
            }
        }
        while (grid.isFilled() == false  ||x > 8 || y > 8 || num > 9||x<0 || y<0 || 9<=0 );
    }
}

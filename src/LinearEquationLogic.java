import java.util.Scanner;
public class LinearEquationLogic {
    Scanner scan = new Scanner(System.in);
    public LinearEquationLogic() {
    }
    public void start() {
        System.out.println("Hello, please enter your coordinate points in this format: \"(x, y)\" ");
        String coordinates = scan.nextLine();
        int x1 = getX(coordinates);
        int y1 = getY(coordinates);
        System.out.println(x1 + " and " + y1);
        System.out.println("Please enter another pair of coordinate points in this format: \"(x, y)\" ");
        String coordinates2 = scan.nextLine();
        int x2 = getX(coordinates2);
        int y2 = getY(coordinates2);
        System.out.println(x2 + " and " + y2);
        LinearEquation linearEquation = new LinearEquation(x1, y1, x2, y2);
        System.out.println(linearEquation.lineInfo());
        System.out.print("Please enter an x value. ");
        double x3 = scan.nextDouble();
        System.out.print(linearEquation.coordinateForX(x3));
        restart();
    }
    private void restart() {
        int loop = 0;
        while (loop != 1) {
            scan.nextLine();
            System.out.print("\nDo you want to repeat the process for another pair of coordinates? (yes/no) ");
            String choice = scan.nextLine();
            if (choice.equals("no")) {
                loop = 1;
            } else {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                start();
            }
        }
    }
    private int getX(String coords) {
        return Integer.parseInt((coords.substring(1, coords.indexOf(","))));
    }
    private int getY(String coords) {
        return Integer.parseInt((coords.substring(coords.indexOf(",") + 2, coords.length() - 1)));
    }
}
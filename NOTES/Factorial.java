public class Factorial {
    int counter = 0;
    public static void main (String[] args) {
        int num = 5; // factorial: 5 * 4 * 3 * 2 * 1 = 120

        System.out.println(visFactorial(num));
        System.out.println(solveFactorial(num));
    }

    // recursively visualize factorial
    public static int visFactorial(int num) {
        // base case
        if (num <= 1) {
            return 1;
        }
        else {
            // visually check iterations of num
            System.out.print(num + " * ");
            return visFactorial(num - 1);
        }
    }

    // recursively solve factorial
    public static int solveFactorial(int num) {
        // base case
        if (num <= 1) {
            return 1;
        }
        else {
            return num * solveFactorial(num - 1);
        }
    }

}
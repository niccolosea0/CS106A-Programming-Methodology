import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("This program lists Fibonacci sequence.");

        Scanner scanner = new Scanner(System.in);
        int MAX_TERM_VALUE;

        while (true)  {
            System.out.print("Enter number: ");
            MAX_TERM_VALUE = scanner.nextInt();
            // If entered number is negative prompt user again.
            if (MAX_TERM_VALUE < 0) {
                System.out.println("Number must be non-negative");
                continue;
            }
            break; // Stop the loop if entered number is positive
        }

        fib(MAX_TERM_VALUE);
    }

    // Method to calculate fibonacci sequence
    private static void fib(int n)
    {
       int x = 0;
       int y = 1;

       System.out.println(x);
       int result = 0;
       while (result < n)
       {
           result = x + y;
           System.out.println(result);
           x = y;
           y = result;
       }
    }
}
/* File: Fibonacci.java */
/* This program prints fibonacci sequence upto the number that is provided
 * If negative number would be provided, user would be prompted to enter number again
 */


import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("This program lists Fibonacci sequence.\n");

        Scanner scanner = new Scanner(System.in);
        int MAX_TERM_VALUE;

        // Prompt user until, valid number is not entered!
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
       int t0 = 0;
       int t1 = 1;

       if (n == 0) {
           System.out.println(t1);
           return;
       }

       while (t0 <= n)
       {
           int t3 = t0 + t1;
           System.out.println(t0);
           t0 = t1;
           t1 = t3;
       }
    }
}

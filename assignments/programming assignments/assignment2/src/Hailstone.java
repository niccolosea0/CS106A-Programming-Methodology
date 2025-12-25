import java.util.Scanner;

public class Hailstone {
    public static void main(String[] args) {
        // Scanner to read integers
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        int count = 0; // To count steps in while loop

        while (n != 1) {
            if (n % 2 != 0) {
                n = 3*n + 1;
                System.out.println(n + " is odd, so I make 3n + 1: " + n);
            }
            else {
                n /= 2;
                System.out.println(n + " is even, so I make it half: " + n);
            }
            count++;
        }
        System.out.println("The process took " + count + " steps to reach 1");
    }
}

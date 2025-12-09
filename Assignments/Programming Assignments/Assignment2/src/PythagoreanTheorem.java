import java.util.Scanner;

public class PythagoreanTheorem {
   public static void main(String[] args) {

       // Scanner for reading the integers
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a first number: ");
        int a = scanner.nextInt();

       System.out.print("Enter a second number: ");
       int b = scanner.nextInt();

       double c = Math.sqrt(a + b);
       System.out.println("Square of sum: " + c);

       scanner.close();
   }
}

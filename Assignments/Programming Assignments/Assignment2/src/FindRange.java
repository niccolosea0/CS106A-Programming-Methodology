import java.util.ArrayList;
import java.util.Scanner;

public class FindRange {
    public static void main(String[] args) {
        System.out.println("This program finds the largest and smallest numbers.");

        // Scanner for reading integers
        Scanner scanner = new Scanner(System.in);

        // ArrayList for storing numbers
        ArrayList<Integer> list = new ArrayList<>();

        // Sentinel value for stoping the while cycle
        int sentinel = 0;

        // While ture read numbers and add it in list
        while (true)
        {
            System.out.print("? ");
            int value = scanner.nextInt();
            if (value == sentinel) {
                break;
            }
            list.add(value);
        }

        // If list is empty (no numbers in it) print message and stop program
        if (list.isEmpty()){
            System.out.println("List is empty");

            scanner.close();
            return;
        }

        // Calculate the smallest number from the list
        int smallest = findSmallest(list);
        System.out.println("Smallest: " + smallest);

        // Calculate the largest number from the list
        int largest = findLargest(list);
        System.out.println("Largest: " + largest);

        scanner.close();

    }

    // Function to calculate the smallest number in the list
    public static int findSmallest(ArrayList<Integer> arrayList) {
        int smallest = arrayList.getFirst();

        for (int num : arrayList) {
            if (num < smallest) {
                smallest = num;
            }
        }

       return smallest;
    }

    // Function to calculate the largest number in the list
    public static int findLargest(ArrayList<Integer> arrayList) {
        int largest = arrayList.getFirst();

        for (int num : arrayList) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }
}

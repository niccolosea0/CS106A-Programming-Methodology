import acm.graphics.*;
import acm.program.*;

public class Palindrome extends ConsoleProgram {

    public void run() {

        setFont("Arial-24");
        String str = readLine("Enter string: ");

        if (isPalindrome(str)) {
            println("How beatiful, your string is Palindrome!");
        } else {
            println("Good string, but it is not a Palindrome!");
        }

    }

    private boolean isPalindrome(String str) {

        int length = str.length();

        for (int i = 0; i < length - 1; i++) {

            if (str.charAt(i) != str.charAt(length - (i + 1))) {
                return false;
            }
        }

        return true;
    }

}

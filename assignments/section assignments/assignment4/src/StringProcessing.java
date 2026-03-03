import acm.program.*;

public class StringProcessing extends ConsoleProgram {

    private String addCommasToNumericString(String digits) {
        
        int length = digits.length();
        int count = 1;
        
        for (int i = length - 1; i >= 0; i--) {
            if (count % 3 == 0) {

                // Get part of the String before particular index
                String oneString = digits.substring(0, i);

                // Get part of the String from index to end
                String secondString = digits.substring(i, digits.length());

                // Update String with 
                digits = oneString + "," + secondString;
            }

            count++;
        }

        return digits;
    }

    public void run() {

        setFont("Arial-20");
        while (true) {
            String digits = readLine("Enter a numeric string: ");
            if (digits.length() == 0) { 
                println("Byee");
                break;
            }

            println("Updated value: " + addCommasToNumericString(digits));
        }
    }
}

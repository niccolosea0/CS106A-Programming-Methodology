import acm.program.*;
import acm.util.*;
import java.util.*;
import java.io.*;

public class Histogram extends ConsoleProgram {

    public void run() {

        BufferedReader fileReader = openFile("Please enter a filename: ");

    }

    // Method to open file carefully
    private BufferedReader openFile(String prompt) {

        BufferedReader reader = null;

        while (reader == null) {
            try {
                String filename = readLine(prompt);
                reader = new BufferedReader(new FileReader(filename));
            } catch (IOException e) {
                println("Who are you fooling by entering invalid filename ?!");
            }
        }

        return reader;
    }
}

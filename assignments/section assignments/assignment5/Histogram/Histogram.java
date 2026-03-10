import acm.program.*;
import acm.util.*;
import java.util.*;
import java.io.*;

public class Histogram extends ConsoleProgram {

    public void run() {

        setFont("Arial-19");
        BufferedReader fileReader = openFile("Please enter a filename: ");
        List<Integer> scoreList = readFile(fileReader);
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

    private List<Integer> readFile(BufferedReader reader) {

        List<Integer> list = new ArrayList<>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                try {
                    int score = Integer.parseInt(line.trim());
                    println("Read integer: " + score);
                    list.add(score);
                } catch (NumberFormatException e) {
                    println("Skiping non-integer line - " + line);
                }
            }
        } catch (IOException ex) {
            throw new ErrorException(ex);
        }
        return list;
    }
}

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;


public class WordCount extends ConsoleProgram {
    public void run() {

        BufferedReader fileReader = openFile("Please enter a filename: ");
        List<String> list = readFile(fileReader);

    }

    // Method to openFile carefully (Invalid filename would be rejected)
    private BufferedReader openFile(String prompt) {
        BufferedReader reader = null;

        while (reader == null) {
            try {
                String filename = readLine(prompt);
                reader = new BufferedReader(new FileReader(filename));
            } catch (IOException e) {
                println("Invalid filename, please provide valid one!");
            }
        }

        return reader;
    }

    // Method to read content of file and return it as a list
    private List<String> readFile(BufferedReader reader) {

        List<String> list = new ArrayList<>();


        try {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                println("read: " + line);
                list.add(line);
            }
            // close file
            reader.close();
        } catch (Exception ex) {
                throw new ErrorException(ex);
        }
        return list;
    }
}

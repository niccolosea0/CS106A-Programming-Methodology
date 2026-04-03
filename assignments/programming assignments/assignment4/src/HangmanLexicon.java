import java.util.*;
import java.io.*;

public class HangmanLexicon {
    /** Returns the number of words in the lexicon. */

    List<String> lines;

    public HangmanLexicon() {

        BufferedReader file = openFile("HangmanLexicon.txt");
        lines = readFile(file);
    }

    public int getWordCount() {

        // Size of the list is count of words
        System.out.println(lines.size());
        return lines.size();
    }

    /** Returns the word at the specified index. */
    public String getWord(int index) {
        return lines.get(index);
    }

    private List<String> readFile(BufferedReader reader) {

        List<String> lines = new ArrayList<>();

        try {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                
                lines.add(line);
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }

    private BufferedReader openFile(String filename) {

        BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(filename));
            } catch (IOException e) {
                System.out.println("File does not exist! Provide valid filename!");
            }
        return reader;
    }
}

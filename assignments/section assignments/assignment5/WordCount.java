import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;


public class WordCount extends ConsoleProgram {
    public void run() {

        BufferedReader fileReader = openFile("Please enter a filename: ");
        List<String> list = readFile(fileReader);

        calculateLines(list);
        calculateWords(list);
        calculateCharacters(list);
    }

    // Method that prints number of lines
    private void calculateLines(List<String> wordList) {

         int lines = wordList.size();
         println("Lines = " + lines);
    }

    private void calculateWords(List<String> wordList) {
        
        int size = wordList.size();

        // list to store words
        List<String> words = new ArrayList<>();

        // Outer loop for lines
        for (int i = 0; i < size; i++) {

            // Get specific line
            String line = wordList.get(i);

            // Get size of this line
            int lineSize = line.length();

            // String to store words via characters
            String word = "";

            for (int j = 0; j < lineSize; j++) {

                // Get character
                char ch = line.charAt(j);
                
                if (Character.isLetterOrDigit(ch)) {
                    word += ch;
                } else {
                    // If character is not letter or digit, it means we 
                    // have one full word, we add that word to array and emptying previous word
                    if (!word.isEmpty()) {
                        words.add(word);
                    }
                    word = "";
                }
            }

            if (!word.isEmpty()) {
                words.add(word);
            }
        }

        int wordsCount = words.size();
        println("Words = " + wordsCount);
    }

    private void calculateCharacters(List<String> wordList) {

        int size = wordList.size();

        // count of characters
        int count = 0;

        for (int i = 0; i < size; i++) {

            String line = wordList.get(i);
            // if you uncommnet this following comment you do would not need another for loop
            // count += line.length();
            int lineSize = line.length();

            for (int j = 0; j < lineSize; j++) {
                count++;
            } 
        }

        println("Chars = " + count);
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

import acm.program.*;
import acm.util.*;
import java.util.*;
import java.io.*;

public class Histogram extends ConsoleProgram {

    public void run() {

        setFont("Arial-19");
        BufferedReader fileReader = openFile("Please enter a filename: ");
        List<Integer> scoreList = readScores(fileReader);
        int[] arrayHistogram = setupBin(scoreList);
        displayHistogram(arrayHistogram);
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

    // Method to read scores from the file
    private List<Integer> readScores(BufferedReader reader) {

        List<Integer> list = new ArrayList<>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                try {
                    int score = Integer.parseInt(line.trim());
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

    // This method creates array which stores 
    // count of scores for corresponding binIndex (score / 10)
    private int[] setupBin(List<Integer> list) {

        int[] bin = new int[11];    

        for (Integer score : list) {
            // determine bin index
            int index = score / 10;

            bin[index]++;
        }

        return bin;
    }

    private void displayHistogram(int[] histogramBins) {

        for (int i = 0; i < histogramBins.length; i++) {

            String label;
            if (i == 10) {
                label = "   100: ";
            } else {
                int start = i * 10;
                int end = start + 9;
                label = String.format("%02d-%02d: ", start, end);
            }

            println(label + "*".repeat(histogramBins[i]));
        }
    }
}

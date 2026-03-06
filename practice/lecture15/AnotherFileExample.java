import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class AnotherFileExample extends ConsoleProgram {

    private BufferedReader openFile(String prompt) {
        BufferedReader rd = null;

        while (rd == null) {

            try {
                String filename = readLine(prompt);
                rd = new BufferedReader(new FileReader(filename));
            } catch (IOException e) {
                println("Nice try punk, That file does not exists.");
            }
        }

        return rd;
    }

    public void run() {
        setFont("Arial-20");
        BufferedReader rd = openFile("Please enter filename: ");

        try {
            while (true) {
                String line = rd.readLine();
                if (line == null)
                    break;
                println("Read line: [" + line + "]");
            }

            println("\nIt was nice to meet you, bye now!");
            rd.close();
        } catch (IOException ex) {
            throw new ErrorException(ex);
        }
    }
}



import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class CopyFile extends ConsoleProgram {

    private BufferedReader openFile(String prompt) {

        BufferedReader rd = null;

        while (rd == null) {
            try {
                String filename = readLine(prompt);
                rd = new BufferedReader(new FileReader(filename));
            } catch (IOException e) {
                println("Nice try punk, this file does not exists.");
            }
        }

        return rd;
    }

    public void run() {
        setFont("Arial-18");

        BufferedReader rd = openFile("Please enter a filename: ");

        try {
            PrintWriter wr = new PrintWriter(new FileWriter("copy.txt"));

            while (true) {
                String line = rd.readLine();
                if (line == null) 
                    break;
                println("Read line: " + line);
                wr.println(line);
            }

            println("Good work, text is successfuly written into the file");

            rd.close();
            wr.close();
        } catch (IOException ex) {
            throw new ErrorException(ex);
        }
    }
}

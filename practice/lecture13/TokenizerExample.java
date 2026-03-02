import java.util.*;
import acm.program.*;

public class TokenizerExample extends ConsoleProgram {

    private void printTokens(String str) {
        StringTokenizer tokenizer = new StringTokenizer(str, ", ");
        for (int count = 0; tokenizer.hasMoreTokens(); count++) {
            println("Token #" + count + ": " + tokenizer.nextToken());
        }
    }

    public void run() {
        setFont("Arial-18");
        String line = readLine("Enter line to tokenize: ");
        println("The tokens of the string are: ");
        printTokens(line);
    }
}

    

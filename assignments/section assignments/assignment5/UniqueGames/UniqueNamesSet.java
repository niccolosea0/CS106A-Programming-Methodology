import acm.program.*;
import java.util.Set;
import java.util.LinkedHashSet;

public class UniqueNamesSet extends ConsoleProgram {
    public void run() {
        
        setFont("Arial-19");
        Set<String> uniqueNames = getUniqueSet();

        println("Unique names list contains:");
        for (String name : uniqueNames) {
            println(name);
        }
    }

    private Set<String> getUniqueSet() {

        Set<String> uniqueNames = new HashSet<>();

        while (true) {

            String userInput = readLine("Enter name: ");

            if (userInput.equals("")) {
                break;
            }

            // Duplicate values will be automatically rejected
            uniqueNames.add(userInput);
        }

        return uniqueNames;
    }
}

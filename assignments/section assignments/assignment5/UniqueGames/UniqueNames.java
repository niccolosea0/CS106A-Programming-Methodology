import acm.program.*;
import java.util.List;
import java.util.ArrayList;

public class UniqueNames extends ConsoleProgram {

    public void run() {

        setFont("Arial-19");
        List<String> namesList = getNames();

        // List where we will add unique names
        List<String> uniqueNames = new ArrayList<>();

        for (int i = 0; i < namesList.size(); i++) {

            String specificName = namesList.get(i);

            // If name is already in unique list, skip adding it
            if (uniqueNames.contains(specificName)) {
                continue;
            }

            // If name is not in the uniqueList, add it
            uniqueNames.add(specificName);
        }

        println("Unique names list contains:");
        for (String name : uniqueNames) {
            println(name);
        }
    }

    private List<String> getNames() {

        List<String> names = new ArrayList<>();
        String userInput;

        while (true){

            userInput = readLine("Enter name: ");

            if (userInput.equals("")) {
                break;
            }

            names.add(userInput);
        }

        return names;
    }
}


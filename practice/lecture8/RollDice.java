import acm.util.*;
import acm.program.*;

public class RollDice extends ConsoleProgram {

    private static final int NUM_SIDES = 6;
    
    public void run() {
        // rgen.setSeed(1); // enable it if you want same random sequence each time you run the program.

        int numDice = readInt("Number of dice: ");
        int maxRoll = numDice * NUM_SIDES;
        int numRolls = 0;

        while (true) {
            int roll = numRolls(numDice);
            println("rolled: " + roll);
            numRolls++;
            if (roll == maxRoll) {
                break;
            }
        }

        if (numRolls != 1) {
            println("\nUser rolled: " + maxRoll + " after " + numRolls + " rolls");
        }
        else {
            println("\nUser rolled: " + maxRoll + " after " + numRolls + " roll");
        }


                
    }

    private int numRolls(int numDice) {
        int total = 0;

        for (int i = 0; i < numDice; i++) {
            total += rgen.nextInt(1, NUM_SIDES);
        }

        return total;
    }


    private RandomGenerator rgen = RandomGenerator.getInstance();
}

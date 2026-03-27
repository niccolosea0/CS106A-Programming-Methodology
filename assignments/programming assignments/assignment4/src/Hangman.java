import acm.program.*;
import acm.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Hangman extends ConsoleProgram {

    private static final int MAX_GUESSES = 8;

    public void run() {
        setup();
   }

   public void setup() {

       setFont("Arial-20");
       RandomGenerator rgn = RandomGenerator.getInstance();
       HangmanLexicon lexicon = new HangmanLexicon();

       String word = lexicon.getWord(rgn.nextInt(0, lexicon.getWordCount() - 1));
       playGame(word);
   }

    public void playGame(String word) {

        int guessesLeft = MAX_GUESSES;

        char[] display = new char[word.length()];

        Set<Character> guessedLetters = new HashSet<>();

        // Fill the display with dashes
        for (int i = 0; i < display.length; i++) {
            display[i] = '-';
        }

        println("Welcome to Hangman!");

        // Loop where we play the game
        while (guessesLeft != 0 && !new String(display).equals(word)) {

            println("The word now looks like this: " + new String(display));
            println("You have " + guessesLeft + " guesses left.");

            char guess = getValidGuess(guessedLetters);
            guessedLetters.add(guess);

            // Call method
            guessesLeft = checkGuess(guess, word, display, guessesLeft);
       }

       printFinalMessage(word, display);

    }

    private void printFinalMessage(String word, char[] display) {

        if (new String(display).equals(word)) {
            println("You guessed the word: " + word + " - You WIN!");
        } else {
            println("You Lost!, the word was: " + word);
        }
    }

    // If guess is in the word, it will be added to display
    // Method returns guessesLeft
    private int checkGuess(char guess, String word, char[] display, int guessesLeft) {

        if (word.indexOf(guess) >= 0) {
            println("That guess is correct!");

            // Check all of the letters
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    display[i] = guess;
                }
            }
        } else {
            println("There are no " + guess + "'s  in the word");
            guessesLeft--;
        }

        return guessesLeft;
    }

    private char getValidGuess(Set<Character> guessedLetters) {

        while (true) {

            String input = readLine("Your guess: ").toUpperCase().trim();

            char letter = input.charAt(0);

            if (input.length() != 1 || !Character.isLetter(letter)) {
                println("Please enter a letter!");
                continue;
            } else if (guessedLetters.contains(letter)) {
                println("You have already guessed that letter, try another!");
                continue;
            }

            return letter;
        }
    }
}

class HangmanLexicon {
    /** Returns the number of words in the lexicon. */
    public int getWordCount() {
        return 10;
    }

/** Returns the word at the specified index. */
    public String getWord(int index) {
        switch (index) {
            case 0: return "BUOY";
            case 1: return "COMPUTER";
            case 2: return "CONNOISSEUR";
            case 3: return "DEHYDRATE";
            case 4: return "FUZZY";
            case 5: return "HUBBUB";
            case 6: return "KEYHOLE";
            case 7: return "QUAGMIRE";
            case 8: return "SLITHER";
            case 9: return "ZIRCON";
            default: throw new ErrorException("getWord: Illegal index");
        }
    }
}

import acm.program.*;
import acm.util.*;
import java.util.Set;
import java.util.HashSet;

public class Hangman extends ConsoleProgram {

    private static final int MAX_GUESSES = 8;
    private HangmanCanvas canvas;

    public void init() {
        setSize(1280, 720);
        canvas = new HangmanCanvas();
        add(canvas);
    }

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

        canvas.reset();
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

            String dispWord = new String(display);
            canvas.displayWord(dispWord);
            println("The word now looks like this: " + dispWord);
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
            canvas.noteIncorrectGuess(guess);
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

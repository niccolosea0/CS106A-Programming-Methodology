import acm.program.*;
import acm.util.*;
import java.util.List;
import java.util.ArrayList;

public class Hangman extends ConsoleProgram {

    public void run() {

        setup();

   }

    public void setup() {

        setFont("Arial-20");
        
        // Instance variable
        HangmanLexicon hangmanLexicon = new HangmanLexicon();

        // Variables
        String word = hangmanLexicon.getWord(0);

        // Word length
        int wordLength = word.length();

        // Number of allowed guesses
        int guessesCount = 8;

        // List that contains word letter by letter
        List<String> charactersList = getCharactersList(word);

        // List<Character> guessedChars = new ArrayList<>();
        String[] guessedChars = getCharacters(wordLength);
        //
        // Variable to track, if user guessed the word
        String guessedWord = getString(guessedChars);


        println("Welcome to Hangman!");


        // Loop where we play the game
        while (guessesCount > 0 && !guessedWord.equals(word)) {

            println("The word now looks like this: " + guessedWord);
            println("You have " + guessesCount + " guesses left.");

            String guess = readLine("Your guess: ").toUpperCase();

            // Validate user input
            if (guess.length() > 1) {
                println("Invalid guess, enter one letter!");
                continue;
            }

            if (charactersList.contains(guess)) {
                println("That guess is correct!");
                int index = charactersList.indexOf(guess);
                guessedChars[index] = guess;
                guessedWord = "" + getString(guessedChars);

            } else {
                println("There are no " + guess + "'s in the word!");
                guessesCount--;
            }
        
        }

        if (!guessedWord.equals(word)) {
            println("The word was: " + word);
            println("You Lose!");
        } else {
            println("You guessed the word: " + guessedWord);
            println("You Win!");
        }
    }

    public String getString(String[] array) {

        String result = "";
        for (String elem : array) {
            result += elem;
        }

        return result;
    }

    // Method tjhat takes word length as parameter and returns string array
    public String[] getCharacters(int length) {
        String[] array = new String[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = "-";
        }

        return array;
    }

    // Method that takes word as parameter
    // and returns List<String> with seperate characters
    public List<String> getCharactersList(String word) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            list.add("" + word.charAt(i));
        }

        return list;
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

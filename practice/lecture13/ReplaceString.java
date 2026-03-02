import acm.program.*;

public class ReplaceString extends ConsoleProgram{
    public void run() {

        setFont("Arial-24");
        String sentence = "How old are you my friend?";
        println("Sentence is: " + sentence);
        String updatedSentence = replaceOccurance(sentence, "old", "well");
        println("Changed sentence: " + updatedSentence);
         
    }

    public String replaceOccurance(String str, String orig, String repl) {

        int index = str.indexOf(orig);
        if (index != -1) {
            str = str.substring(0, index) + repl + str.substring(index + orig.length()); 
        }

        return str;
    }
}

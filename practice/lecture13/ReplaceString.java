public class ReplaceString {
    public static void main(String[] args) {

        String sentence = "How old are you my friend?";
        System.out.println("Sentence is: " + sentence);
        String updatedSentence = replaceOccurance(sentence, "old", "well");
        System.out.println("Changed sentence: " + updatedSentence);
         
    }

    public static String replaceOccurance(String str, String orig, String repl) {

        int index = str.indexOf(orig);
        if (index != -1) {
            str = str.substring(0, index) + repl + str.substring(index + orig.length()); 
        }

        return str;
    }
}

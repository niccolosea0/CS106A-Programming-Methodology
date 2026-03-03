import acm.program.*;

public class DeleteCharacters extends ConsoleProgram {

    public String removeAllOccurrences(String str, char ch) {

        str = str.replaceAll( ("" + ch), "");
        return str;
        
    }
    public void run() {
        setFont("Arial-18");
        println(removeAllOccurrences("This is a test", 't'));
        println(removeAllOccurrences("Summer is here!", 'e'));
        println(removeAllOccurrences("---0---", '-'));
    }
}

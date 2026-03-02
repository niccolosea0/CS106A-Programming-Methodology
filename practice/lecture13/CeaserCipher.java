import acm.program.*;

public class CeaserCipher extends ConsoleProgram {

    private char encryptChar(char ch, int key) {

        if (Character.isUpperCase(ch)) {
            ch = (char) ('A' + (ch - 'A' + key) % 26);
        } else if (Character.isLowerCase(ch)) {
            ch = (char) ('a' + (ch - 'a' + key) % 26);
        }
        return ch;
    }

    private String encryptCeaser(String str, int key) {

        if (key < 0) {
            key = 26 - (-key);
        }

        String result = "";

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            result += encryptChar(ch, key);
        }
        return result;
    }


    public void run() {
       setFont("Arial-18");
       println("This program uses a Ceaser Cipher for encryption");
       int key = readInt("Enter encryption key: ");
       String plainText = readLine("Enter plain text: ");
       String cipherText = encryptCeaser(plainText, key);
       println("Cipher text: " + cipherText);
    }
}

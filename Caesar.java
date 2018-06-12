import java.text.Normalizer;
import java.util.regex.Pattern;

public class Caesar {
    static String cypher(String s, int delta) {

        //Transform the initial string to upper case and create a StringBuilder whose value is the string s
        s = s.toUpperCase();
        StringBuilder result = new StringBuilder(s);

        //The alphabet contains only 26 letters so, with this loop, we control that the delta will never be out of our range.
        while (delta > 26) {
            delta -= 26;
        }

        for (int i = 0; i < s.length(); i++) {
            //Now for each letter inside the string, we keep the ascii value for the letter inside a variable.
            char c = (char) s.codePointAt(i);

            //In case that the ascii code is outside the range from the uppercase letters we just ignore the letter or symbol.
            if (c < 65 || c > 90) continue;

            //If the ascii code plus the delta is bigger than 90, we deduct 26 so we will enter in our range again.
            if (c + delta > 90) {
                c += delta - 26;
                //If the value is inside our range we will just add the delta to the ascii value of the letter.
            } else {
                c += delta;
            }
            //Finally we set the letter that we are looping back on it's position on the string.
            result.setCharAt(i, c);
        }
        return result.toString();
    }


    static String decypher(String s, int delta) {

        //to perform the decryption we will follow the same steps, except for those indicated below.
        s = s.toUpperCase();
        StringBuilder result = new StringBuilder(s);

        while (delta > 26) {
            delta -= 26;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = (char) s.codePointAt(i);

            if (c < 65 || c > 90) continue;
            //In this case instead of controlling that the number exceeds the range by the maximum, we control that it does not go out for the minimum.
            if (c - delta < 65) {
                c += 26 - delta;
            } else {
                c -= delta;
            }
            result.setCharAt(i, c);
        }
        return result.toString();
    }

    static String magic(String s, String ss) {

        //First we transform the string 's' to upper case and we count how many times does the letters 'A' and 'E' apper on the 'ss' string.
        //We need to do that to guess the idiom from the encrypted string.
        s = s.toUpperCase();
        int es = find(ss, 'E');
        int pt = find(ss,'A');

        if (es > pt){
            //If the letter 'E' is the one that appears most that means the text is spanish or catalan
            //then we search the letter that appears most on the encrypted string
            //and then we deduct the ascii number for te letter 'E' to guess the delta.
            char c = find2(s);
            int delta = c - 69;
            //After that we just need to send the string and the delta to our decrypt function.
            StringBuilder result = new StringBuilder(decypher(s,delta));
            return result.toString();

        } else {
            //If the letter 'A' is the one that appears most that means the text is Portuguese
            //we deduct the ascii value for the letter 'A' to guess the delta and do the same procedure than before.
            char c = find2(s);
            int delta = c - 65;
            StringBuilder result = new StringBuilder(decypher(s,delta));
            return result.toString();
        }
    }

    public static int find(String s, char c) {

        //This funcions tells us how many times does a specific letter appears on a text.
        //We save the number of times it appears on a variable called contador.

        int  contador = 0;
        s = limpia(s.toUpperCase());

        //We will compare the character c with the letter on the loop
        // if they are the same we add 1 to the result value of the function.
        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                contador++;
            }
        }
        return contador;
    }

    public static char find2(String s){

        //This function tells us which is the most repeated letter on a string.
        char lletra = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            //On this case we have to evade spaces and other special characters
            // so we check if the letter on the loop is on the letters range or not.
            if (s.codePointAt(i) < 65 || s.codePointAt(i) > 90) { continue; }

            if (find(s, s.charAt(i)) > find(s, lletra)) {
                lletra = s.charAt(i);
            }
        }
        return lletra;
    }

    static String limpia(String str) {

        //This function is used to erase the accents in our string.

        String nfdNormalizedString = Normalizer.normalize(str,  Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
}

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Vigenere {

    static String encode(String s, String password) {

        //We create a String that we will use to check the position of a letter on the alphabet
        //we have to add a 0 on the start to make the values match.
        String alf = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        //This counter will be used to select the letter from the password.
        int cont = 0;

        //First of all we erase accents from our string and password and save the string inside a StringBuilder.
        s = limpia(s.toUpperCase());
        password = limpia(password.toUpperCase());
        StringBuilder result = new StringBuilder(s);


        for (int i = 0; i < s.length(); i++) {

            //First of all we check if the character on the loop is a letter or a symbol.
            if (s.codePointAt(i) < 65 || s.codePointAt(i) > 90) { continue; }

            //Here we control that the counter is not greater than the length of the key.
            if (cont == password.length()) { cont = 0; }

            //We take the value on the alphabet of the letter on the loop
            //and add the value of the letter from the password.
            int conta = alf.indexOf(s.charAt(i)) + alf.indexOf(password.charAt(cont));

            //We control that the result of the sum is less than 26.
            while (conta >= alf.length()) { conta -= 26; }

            //Finally we select the resulting letter and replace it on the StringBuilder, incrementing the counter.
            char c = alf.charAt(conta);
            cont++;

            result.setCharAt(i, c);
        }
        return result.toString();
    }

    static String decode(String s, String password) {

        //To perform the decryption we will follow the same steps, except for those indicated below.
        String alf = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        s = limpia(s.toUpperCase());
        password = limpia(password.toUpperCase());
        StringBuilder result = new StringBuilder(s);

        int cont = 0;

        for (int i = 0; i < s.length(); i++) {

            //Same checks.
            if (s.codePointAt(i) < 65 || s.codePointAt(i) > 90) { continue; }
            if (cont == password.length()) { cont = 0; }

            //Instead of adding the values, we substract both values to know the position of the new letter.
            int conta = alf.indexOf(s.charAt(i)) - alf.indexOf(password.charAt(cont));

            //We control that the result of the sum is greater than 0.
            while (conta < 0) { conta += 26; }

            char c3 = alf.charAt(conta);
            cont++;

            result.setCharAt(i, c3);
        }
        return result.toString();
    }

    static String limpia(String str) {

        //This function is used to erase the accents in our string.

        String nfdNormalizedString = Normalizer.normalize(str,  Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
}



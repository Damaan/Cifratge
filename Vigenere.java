
public class Vigenere {

    static String encode(String s, String password) {

        String alf = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        s = s.toUpperCase();
        StringBuilder result = new StringBuilder(s.toUpperCase());

        int cont = 0;

        s = limpia(s);
        password = limpia(password);

        for (int i = 0; i < s.length(); i++) {

            char x = (char) s.codePointAt(i);
            char c = s.charAt(i);

            if (x < 65 || x > 90) {
                continue;
            }

            int c2 = alf.indexOf(c);

            if (cont == password.length()) {
                cont = 0;
            }

            int valornum = alf.indexOf(password.toUpperCase().charAt(cont));
            int conta = c2 + valornum;

            if (conta >= alf.length()) {
                conta = conta - 26;
            }

            char c3 = alf.charAt(conta);
            cont++;

            result.setCharAt(i, c3);

        }

        return result.toString();
    }


    static String limpia(String s) {

        StringBuilder result = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {

            char c = (char) s.codePointAt(i);

            //a con acentos
            if (c == 'á' || c == 'à' || c == 'Á' || c == 'À') {
                c = 65;
                result.setCharAt(i, c);
            }
            //e con acentos
            if (c == 'É' || c == 'È' || c == 'é' || c == 'è') {
                c = 69;
                result.setCharAt(i, c);
            }
            //i con acentos
            if (c == 'í' || c == 'ì' || c == 'Í' || c == 'Ì') {
                c = 73;
                result.setCharAt(i, c);
            }
            //o con acentos
            if (c == 'Ò' || c == 'Ó' || c == 'ó' || c == 'ò') {
                c = 79;
                result.setCharAt(i, c);
            }
            //u con acentos
            if (c == 'ú' || c == 'ù' || c == 'Ù' || c == 'Ú') {
                c = 85;
                result.setCharAt(i, c);
            }

        }
        return result.toString();
    }

    static String decode(String s, String password) {

        String alf = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        s = s.toUpperCase();
        StringBuilder result = new StringBuilder(s.toUpperCase());

        int cont = 0;

        s = limpia(s);
        password = limpia(password);

        for (int i = 0; i < s.length(); i++) {

            char x = (char) s.codePointAt(i);
            char c = s.charAt(i);

            if (x < 65 || x > 90) {
                continue;
            }

            int c2 = alf.indexOf(c);

            if (cont == password.length()) {
                cont = 0;
            }

            int valornum = alf.indexOf(password.toUpperCase().charAt(cont));
            int conta = c2 - valornum;

            if (conta < 0) {
                conta = conta + 26;
            }

            char c3 = alf.charAt(conta);
            cont++;

            result.setCharAt(i, c3);
        }
        return result.toString();
    }
}



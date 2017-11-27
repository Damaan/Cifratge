public class Caesar {
    static String cypher(String s, int delta) {

        s = s.toUpperCase();
        StringBuilder result = new StringBuilder(s.toUpperCase());

        while (delta > 26) {
            delta -= 26;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = (char) s.codePointAt(i);

            if (c < 65 || c > 90) continue;
            if (delta + s.codePointAt(i) > 90) {
                c += delta - 26;
            } else {
                c += delta;
            }

            result.setCharAt(i, c);
        }
        return result.toString();
    }


    static String decypher(String s, int delta) {

        s = s.toUpperCase();
        StringBuilder result = new StringBuilder(s);

        while (delta > 26) {
            delta -= 26;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = (char) s.codePointAt(i);


            if (c < 65 || c > 90) {
                continue;
            }
            if (s.codePointAt(i) - delta < 65) {
                c -= delta;
                c += 26;
            } else {
                c -= delta;
            }
            result.setCharAt(i, c);
        }
        return result.toString();

    }

    static String magic(String s, String ss) {

        s = s.toUpperCase();

        int es = find(ss, 'E');
        int pt = find(ss,'A');

        if (es > pt){
            char c = find2(s);
            int delta = c - 69;
            StringBuilder result = new StringBuilder(decypher(s,delta));
            return result.toString().toUpperCase();

        } else {
            char c = find2(s);
            int delta = c - 65;
            StringBuilder result = new StringBuilder(decypher(s,delta));
            return result.toString().toUpperCase();

        }

    }

    public static int find(String s, char c) {

        int  contador = 0;
        s = limpia(s);
        s= s.toUpperCase();

        int pos = s.indexOf(c);

        for (int i = 0; i < s.length(); i++) {
            if (pos != -1) {
                contador++;
                pos = s.indexOf(c, pos + 1);
            }
        }
        return contador;
    }

    public static char find2(String s){

        char lletra = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (s.codePointAt(i) < 65 || s.codePointAt(i) > 90) { continue; }

            if (find(s, s.charAt(i)) > find(s, lletra)) {
                lletra = s.charAt(i);
            }
        }
        return lletra;
    }

    static String limpia(String s) {

        StringBuilder result = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {

            char c = (char) s.codePointAt(i);

            //a con acentos
            if (c == 'á' || c == 'à') {
                c = 97;
                result.setCharAt(i, c);
            }
            //e con acentos
            if ( c == 'é' || c == 'è') {
                c = 101;
                result.setCharAt(i, c);
            }
            //i con acentos
            if (c == 'í' || c == 'ì') {
                c = 105;
                result.setCharAt(i, c);
            }
            //o con acentos
            if (c == 'ó' || c == 'ò') {
                c = 111;
                result.setCharAt(i, c);
            }
            //u con acentos
            if (c == 'ú' || c == 'ù') {
                c = 117;
                result.setCharAt(i, c);
            }

        }
        return result.toString();
    }

}

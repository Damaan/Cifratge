import java.util.Arrays;

public class Transposition {
    static String cypher(String s, int dim) {

        int agadagla =s.length();
        StringBuilder cars = new StringBuilder(s);

        while (agadagla % dim != 0){
            agadagla++;
            cars.append("#");
        }

        s = cars.toString();
        char[] jojo = s.toCharArray();
        int ae = jojo.length;
        int col = ae / dim;
        char[][] shiza = new char[col][dim];
        int contador = 0;
        StringBuilder result = new StringBuilder();


        //Le da valor al array bidimensional
        for (int i = 0; i < shiza.length; i++) {
            for (int j = 0; j < shiza[0].length; j++) {
                shiza[i][j] = jojo[contador] ;
                contador++;
            }
        }

        //pega en el string builder el array ya traducido, forma final.
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < shiza.length; j++) {
                if (shiza[j][i] == '#'){ continue;}
                result.append(shiza[j][i]);
            }
        }
        return result.toString();
    }

    static String cypher(String s, String key) {

        int agadagla =s.length();
        int dim = key.length();
        StringBuilder cars = new StringBuilder(key);
        cars.append(s);

        while (agadagla % dim != 0){
            agadagla++;
            cars.append("#");
        }

        s = cars.toString();
        char[] jojo = s.toCharArray();
        int ae = jojo.length;
        int col = ae / dim;
        char[][] shiza = new char[col][dim];
        int contador = 0;
        StringBuilder result = new StringBuilder();


        //Le da valor al array bidimensional
        for (int i = 0; i < shiza.length; i++) {
            for (int j = 0; j < shiza[0].length; j++) {
                shiza[i][j] = jojo[contador] ;
                contador++;
            }
        }

        for (int j = shiza[0].length; j > 0; j--) {

            for (int i = 1; i < j; i++) {

                if(shiza[0][i-1]> shiza[0][i]) {
                    char t = shiza[0][i];
                    shiza[0][i] =shiza[0][i-1];
                    shiza[0][i-1] =t;
                    for (int k = 1; k < shiza.length; k++) {
                        char x = shiza[k][i];
                        shiza[k][i] =shiza[k][i-1];
                        shiza[k][i-1] =x;

                    }
                }
            }
        }

        //pega en el string builder el array ya traducido, forma final.
        for (int i = 0; i < dim; i++) {
            for (int j = 1; j < shiza.length; j++) {

                if (shiza[j][i] == '#'){ continue;}
                result.append(shiza[j][i]);
            }
        }
        return result.toString();
    }

    static String decypher(String s, int dim) {
        int agadagla =s.length();
        StringBuilder cars = new StringBuilder(s);

        while (agadagla % dim != 0){
            agadagla++;
            cars.append("#");
        }

        s = cars.toString();
        char[] jojo = s.toCharArray();
        int ae = jojo.length;
        int col = ae / dim;
        char[][] shiza = new char[col][dim];
        int contador = 0;
        StringBuilder result = new StringBuilder();


        //Le da valor al array bidimensional
        for (int i = 0; i < shiza.length; i++) {
            for (int j = 0; j < shiza[0].length; j++) {
                shiza[i][j] = jojo[contador] ;
                contador++;
            }
        }

        //pega en el string builder el array ya traducido, forma final.
        for (int i = 0; i < shiza[0].length; i++) {
            for (int j = 0; j < dim; j++) {
                if (shiza[j][i] == '#'){ continue;}
                result.append(shiza[j][i]);
            }
        }
        return result.toString().trim();
    }

    static String decypher(String s, String key) {
        return "";
    }

    // Funció que mostra una matriu per pantalla
    static void printMat(double[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.printf("%06.2f ", mat[i][j]);
            }
            System.out.println();
        }
    }
}

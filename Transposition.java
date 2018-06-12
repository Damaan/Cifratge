import java.util.Arrays;

public class Transposition {
    static String cypher(String s, int dim) {

        int llarg =s.length();
        StringBuilder sb = new StringBuilder(s);

        //Check if the length of the string is multiple of the dimension
        //and add an additional character to the string in case that is not multiple.
        while (llarg % dim != 0){ llarg++; sb.append("#"); }

        //Update s to contain the additional characters.
        s = sb.toString();

        //Calculate how many rows will our matrix have,create the matrix and empty the StringBuilder to save the result there.
        int row = (int) (Math.ceil(s.length() / (double) dim));
        char[][] matrix = new char[row][dim];
        //this counter is used to tell us which character from the string we have to use.
        int contador = 0;
        sb.delete(0,sb.length());


        //Insert all the characters from the string 1 by 1 into the matrix in horizontal order.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = s.charAt(contador);
                contador++;
            }
        }


        //Insert the characters 1 by 1 into the StringBuilder in vertical order ignoring the additional characters.
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == '#'){ continue;}
                sb.append(matrix[j][i]);
            }
        }
        return sb.toString();
    }

    static String cypher(String s, String key) {

        int llarg =s.length();
        //This time we add the key to the string.
        StringBuilder sb = new StringBuilder(key);
        sb.append(s);

        //Same checks as before.
        while (llarg % key.length() != 0){ llarg++; sb.append("#"); }

        //Same calculations and updates as seen on the normal cypher.
        s = sb.toString();
        int row = (int) (Math.ceil(s.length() / (double) key.length()));
        char[][] matrix = new char[row][key.length()];
        int contador = 0;
        sb.delete(0,sb.length());


        //Insert all the characters from the string 1 by 1 into the matrix in horizontal order.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = s.charAt(contador);
                contador++;
            }
        }

        //We use bubble sorting to sort the matrix based on the key
        for (int i = matrix[0].length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if(matrix[0][j-1]> matrix[0][j]) {
                    for (int k = 0; k < matrix.length; k++) {
                        char x = matrix[k][j];
                        matrix[k][j] =matrix[k][j-1];
                        matrix[k][j-1] =x;
                    }
                }
            }
        }

        //Insert the characters 1 by 1 into the StringBuilder in vertical order ignoring the additional characters.
        for (int i = 0; i < key.length(); i++) {
            for (int j = 1; j < matrix.length; j++) {
                if (matrix[j][i] == '#') { continue; }
                sb.append(matrix[j][i]);
            }
        }
        return sb.toString();
    }

    static String decypher(String s, int dim) {

        //This counter will tell us how many empty spaces will we have
        int cont = 0;
        int contador = 0;

        //Check if the length of the string is multiple of the dimension
        //and increment the counter in case that is not multiple.
        while ((s.length() + cont) % dim != 0){ cont++; }
        //Same calculations and updates as seen on the normal cypher.
        int row = (int) (Math.ceil(s.length() / (double) dim));
        char[][] matrix = new char[row][dim];
        StringBuilder result = new StringBuilder();

        //If we have any empty spaces we put the symbol '#' to fill them
        if (cont > 0) {
            for (int i = matrix.length; i > 0; i--) {
                int x = matrix[0].length -1;
                for (int j = cont; j > 0; j--) {
                    matrix[i - 1][x] = '#';
                    x--;
                }
                break;
            }
        }

        //Insert all the characters from the string 1 by 1 into the matrix in vertical order.
        for (int i = 0; i < matrix[0].length; i++) {
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[k][i] == '#'){continue;}
                matrix[k][i] = s.charAt(contador);
                contador++;
            }
        }

        //Insert the characters 1 by 1 into the StringBuilder in vertical order ignoring the additional characters.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '#'){ continue;}
                result.append(matrix[i][j]);
            }
        }
        return result.toString();
    }

    static String decypher(String s, String key) {

        //Same checks as seen on the normal decypher.
        int cont = 0;
        int contador = 0;
        while ((s.length() + cont) % key.length() != 0) {
            cont++;
        }

        //This time we will add the key too to the matrix
        // so this time in the row calculation we need the string and key length.
        int row = (int) (Math.ceil((s.length() + key.length()) / (double) key.length()));
        char[][] matrix = new char[row][key.length()];
        StringBuilder result = new StringBuilder();

        //Same procedure to fill the empty spaces with '#'
        if (cont > 0) {
            for (int i = matrix.length; i > 0; i--) {
                int x = matrix[0].length -1;
                for (int j = cont; j > 0; j--) {
                    matrix[i - 1][x] = '#';
                    x--;
                }
                break;
            }
        }

        //Insert all the characters from the key into the matrix on the first row.
        for (int i = 0; i < 1; i++) {
            for (int k = 0; k < matrix[0].length ; k++) {
                if (matrix[i][k] == '#') { continue; }
                matrix[i][k] = key.charAt(k);
            }
        }

        //We use bubble sorting to sort the matrix based on the key
        //at this moment the matrix only contains the key and the filled empty spaces.
        for (int i = matrix[0].length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if(matrix[0][j-1]> matrix[0][j]) {
                    for (int k = 0; k < matrix.length; k++) {
                        char x = matrix[k][j];
                        matrix[k][j] =matrix[k][j-1];
                        matrix[k][j-1] =x;
                    }
                }
            }
        }

        //We add the characters from the string into the matrix in vertical order
        for (int i = 0; i < matrix[0].length; i++) {
            for (int k = 1; k < matrix.length; k++) {
                if (matrix[k][i] == '#') { continue; }
                matrix[k][i] = s.charAt(contador);
                contador++;
            }
        }

        //We create a array with the sorted key inside it.
        char[] clau = key.toCharArray();
        Arrays.sort(clau);
        //We create a numeric array to save the original position of each letter from the key.
        int[] ordre = new int[key.length()];

        // We search for each character on the key, its position once ordered and save that value on the int array
        // this way we will have for example that the position 0 on the array 'ordre' is 5,
        // so we know that the first letter of the key is now on the fifth column.
        for (int i = 0; i < key.length(); i++) {
            for (int j = 0; j < key.length(); j++) {
                if (key.charAt(i) == clau[j]) {
                    ordre[j] = i;
                    clau[j] = '#';
                    break;
                }
            }
        }

        //Insert the characters into the StringBuilder but this time we use the function search
        // to find the original order of the key and insert the characters following that order.
        for (int i = 1; i < matrix.length; i++) {
            int conta = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                int x =search(ordre,conta);
                if (matrix[i][x] == '#') {   continue; }
                result.append(matrix[i][x]);
                conta++;
            }
        }
        return result.toString();
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

    static int search(int[] ordre, int k) {

        //this function searches the position of a specific number on a int array, and returns that value.
        StringBuilder x = new StringBuilder();
        for (int h = 0; h < ordre.length; h++) {
            x.append(ordre[h]);
        }
        String ae = x.toString();

        for (int i = 0; i < ordre.length; i++) {
            char y = ae.charAt(i);
            if (ordre[i] == k) {
                return ae.indexOf(y);
            }
        }
        return 0;
    }
}

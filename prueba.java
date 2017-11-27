import java.util.Arrays;

public class prueba {
    public static void main(String[] args) {

        String s = "ABCDEFG";
        String key = "BAC";
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
            System.out.println(Arrays.toString(shiza[0]));
        }

            //pega en el string builder el array ya traducido, forma final.
        for (int i = 0; i < dim; i++) {
            for (int j = 1; j < shiza.length; j++) {

                if (shiza[j][i] == '#'){ continue;}
                result.append(shiza[j][i]);
            }
        }


        System.out.println(result.toString());


        //ver array

        for (int x=0; x < shiza.length; x++) {
            System.out.print("|");
            for (int y=0; y < shiza[x].length; y++) {
                System.out.print (shiza[x][y]);
                if (y!=shiza[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }

    }


}

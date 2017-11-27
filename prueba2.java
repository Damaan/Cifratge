public class prueba2 {
    public static void main(String[] args) {
        String s = "ADGBECF";
        int dim = 2;
        StringBuilder cars = new StringBuilder(s);
        int cont = 0;

        while ((s.length() + cont) % dim != 0){
            cont++;
            cars.append("#");
        }

        s = cars.toString();
        char[] jojo = s.toCharArray();
        int ae = jojo.length + cont;
        int col = ae / dim;
        char[][] shiza = new char[col][dim];
        int contador = 0;
        StringBuilder result = new StringBuilder();


        //Le da valor al array bidimensional
        for (int i = 0; i < shiza.length; i++) {
            if (i == 0 & contador == 0) {
                for (int k = 0; k < shiza[0].length; k++) {
                    shiza[i][k] = jojo[contador];
                    contador++;
                }

            } else {
                for (int j = 0; j < shiza[0].length; j++) {
                    if (shiza[i][j] == '#'){ continue;}
                    shiza[i][j] = jojo[contador];
                    contador++;
                }
            }
        }

        //pega en el string builder el array ya traducido, forma final.
        for (int i = 0; i < shiza[0].length; i++) {
            for (int j = 0; j < dim; j++) {
                if (shiza[j][i] == '#'){ continue;}
                result.append(shiza[j][i]);
            }
        }

        //ver array

        for (int x=0; x < shiza.length; x++) {
            System.out.print("|");
            for (int y=0; y < shiza[x].length; y++) {
                System.out.print (shiza[x][y]);
                if (y!=shiza[x].length-1) System.out.print("\t");
            }
            System.out.println("|");
        }

        System.out.println(result.toString().trim());

    }


    }


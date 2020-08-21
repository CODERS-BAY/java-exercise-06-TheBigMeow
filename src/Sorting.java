import java.util.Random;

public class Sorting {
    public static void main(String[] args) {

        for (int l = 10; l <= 16; l = l +2) {
            Random rd = new Random();
            int[] myArray = new int[l];
            int[] myArray2 = new int[l];

            System.out.println("First Array: ");
            for (int i = 0; i < myArray.length; i++) {
                myArray[i] = rd.nextInt(100); //Zufällige Zahlen zwischen 0 und 99
                System.out.print(myArray[i] + " ");
            }
            System.out.println();
            long startTime = System.nanoTime();
            quicksort(myArray, 0, myArray.length - 1); //Für ersten Haufen 0 - länge damit QS weiß wo er teilen kann
            long endTime = System.nanoTime();
            System.out.println("Quick Sort: ");
            for (int x : myArray) {
                System.out.print(x + " ");
            }
            System.out.println();
            System.out.println("Quick Sort Time:" + (endTime - startTime));


            System.out.println();
            System.out.println("Second Array:");
            for (int i = 0; i < myArray2.length; i++) {
                myArray2[i] = rd.nextInt(100);
                System.out.print(myArray2[i] + " ");
            }
            System.out.println();
            System.out.println("Bogo Sort:");
            startTime = System.nanoTime();
            bogosort(myArray2);
            endTime = System.nanoTime();
            for (int y : myArray2) {

                System.out.print(y + " ");
            }
            System.out.println();
            System.out.print("Bogo Sort Time:" + (endTime - startTime));
            System.out.println();
        }
    }

    private static void quicksort(int[] myArray, int first, int last) {

        if (first < last) {
            int x = myArray[(first + last) / 2]; //x = Wert genau in der Mitte
            int i = first;
            int j = last;

            //Das Element wird in der Mitte genommen, schauen alles kleiner ist als x bzw größer als x
            while (i <= j) {

                while (myArray[i] < x) {
                    i++;
                }
                while (x < myArray[j]) {
                    j = j - 1;
                }

                // Wenn i <= j tausche beide Seiten

                if (i <= j) {
                    int y = myArray[i]; //Dreieckstausch
                    myArray[i] = myArray[j];
                    myArray[j] = y;
                    i++; //rutschen weiter nach Innen
                    j--;
                }
            }
            //rekursiver Aufruf
            quicksort(myArray, first, j); //sortiert linke Seite mit obrigen Code
            quicksort(myArray, i, last);  //sortiert rechte Seite mit obrigen Code
            //DIVIDE AND CONQUER !!!!!!
        }

    }

    private static void bogosort(int[] myArray) {
        //Nimmt zufällig zwei Index Zahlen und tauscht dessen Werte

        boolean isSorted = false; // Wenn es nicht sortiert is
        while (!isSorted) { //Solange es nicht sortiert is
            isSorted = true; //Wir nehmen an dass es sortiert ist
            for (int i = 0; i < myArray.length - 1; i++) {
                if (myArray[i] > myArray[i + 1]) { //i wird mit der nächsten Stelle (1) verglichen darum +1
                    isSorted = false; //Wir wissen dass es nicht sortiert is
                    break;
                }
            }
            if (!isSorted) { //Wenn nicht sortiert ist...
                Random rd = new Random();
                int random1 = rd.nextInt(myArray.length); //Zwei zufällige Index Zahlen werden genommen und dessen Werten im Array getauscht
                int random2 = rd.nextInt(myArray.length);

                int y = myArray[random1]; //tausche die Werte der zufälligen Werte
                myArray[random1] = myArray[random2];
                myArray[random2] = y;
            }
        }
    }


}


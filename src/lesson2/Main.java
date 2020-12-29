package lesson2;

public class Main {
    public static void main(String[] args) {
        // 1
        byte[] someArray = {1,1,1,0,0,0,0,1,0,0,1};
        for (int i = 0; i < someArray.length; i++) {
            if (someArray[i] == 0) {
                someArray[i] = 1;
            } else {
                someArray[i] = 0;
            }
        }
        for (byte b : someArray) {
            System.out.print(b + " ");
        }
        System.out.println("");

        // 2
        byte[] array = new byte[8];
        byte element = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = element;
            element += 3;
        }
        for (byte b : array) {
            System.out.print(b + " ");
        }
        System.out.println("");

        // 3
        byte[] arrayForMult = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrayForMult.length; i++) {
            if (arrayForMult[i] < 6) {
                arrayForMult[i] *= 2;
            }
        }
        for (byte b : arrayForMult) {
            System.out.print(b + " ");
        }
        System.out.println("");

        // 4
        int[][] squareArray = new int[9][9];
        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray.length; j++) {
                if (i == j || i == squareArray.length - 1 - j) {
                    squareArray[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray.length; j++) {
                System.out.print(squareArray[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");

        // 5
        int[] minMaxArray = {3,345,67,-213,67,34,78,23,9,1,34,7};
        int min = 0;
        int max = 0;
        for (int i = 0; i < minMaxArray.length; i++) {
            if (minMaxArray[i] < min) {
                min = minMaxArray[i];
            }
            if (minMaxArray[i] > max) {
                max = minMaxArray[i];
            }
        }
        System.out.println("Min: " + min + ", Max: " + max);

        // 6
        System.out.println(checkBalance(new int[]{2,2,2,1,2,2,10,2}));

        // 7
        int[] arrayToMove = new int[]{1,2,3,4,5,6,7,8,9};
        moveArray(arrayToMove,3);
        for (int i = 0; i < arrayToMove.length; i++) {
            System.out.print(arrayToMove[i] + " ");
        }
        System.out.println();
        moveArray(arrayToMove,-5);
        for (int i = 0; i < arrayToMove.length; i++) {
            System.out.print(arrayToMove[i] + " ");
        }
    }

    // 6
    public static boolean checkBalance(int[] arrayToCheck) {
        for (int i = 1; i < arrayToCheck.length - 1; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft += arrayToCheck[j];
            }
            for (int k = i; k < arrayToCheck.length; k++) {
                sumRight += arrayToCheck[k];
            }
            if (sumLeft == sumRight) return true;
        }
        return false;
    }

    // 7
    public static void moveArray(int[] arrayToMove, int steps) {
        int temp;
        if (steps < 0) {
            steps = -steps;
            for (int i = 0; i < steps; i++) {
                temp = arrayToMove[0];
                for (int j = 0; j < arrayToMove.length - 1; j++) {
                    arrayToMove[j] = arrayToMove[j+1];
                }
                arrayToMove[arrayToMove.length - 1] = temp;
            }

        } else {
            for (int i = 0; i < steps; i++) {
                temp = arrayToMove[arrayToMove.length - 1];
                for (int j = arrayToMove.length - 1; j > 0; j--) {
                    arrayToMove[j] = arrayToMove[j-1];
                }
                arrayToMove[0] = temp;
            }
        }



    }
}

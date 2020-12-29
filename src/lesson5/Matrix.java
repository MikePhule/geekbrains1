package lesson5;

public class Matrix {
    private int sizeX;
    private int sizeY;
    private int nextInt = 1;

    private int[][] matrix;

    public Matrix(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        matrix = new int[sizeY][sizeX];
    }

    public void print() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void spiralFill() {
        int maxSize = Math.max(sizeX, sizeY);

        for (int i = 0; i < maxSize/2; i++) {
            fillUp(i,i + 1);
            fillRight(i + 1,sizeX - 1 - i);
            fillDown(sizeY - 1 - i, i );
            fillLeft(i , i);
        }

        if (sizeX == sizeY && maxSize%2 != 0) {
            matrix[maxSize/2][maxSize/2] = nextInt;
        }
    }

    private void fillUp(int row, int subX) {
        for (int i = 0; i < sizeX; i++) {
            if (matrix[row][i] == 0) {
                matrix[row][i] = nextInt;
                nextInt++;
            }
        }
//        for (int i = column; i < sizeX - subX; i++) {
//                matrix[row][i] = nextInt;
//                nextInt++;
//        }
    }
    private void fillRight(int subY, int col) {
        for (int i = 0; i < sizeY; i++) {
            if (matrix[i][col] == 0) {
                matrix[i][col] = nextInt;
                nextInt++;
            }
        }
//        for (int j = subY - 1; j < sizeY - subY; j++) {
//            matrix[j][col] = nextInt;
//            nextInt++;
//        }
    }
    private void fillDown(int row, int subX) {
        for (int i = sizeX - 1; i >= 0; i--) {
            if (matrix[row][i] == 0) {
                matrix[row][i] = nextInt;
                nextInt++;
            }
        }
//        for (int i = sizeX - 1 - subX ; i > subX; i--) {
//            matrix[row][i] = nextInt;
//            nextInt++;
//        }
    }
    private void fillLeft(int subY, int col) {
        for (int i = sizeY - 1; i >= 0 ; i--) {
            if (matrix[i][col] == 0) {
                matrix[i][col] = nextInt;
                nextInt++;
            }
        }
//        for (int j = sizeY - 1 - row; j > subY; j--) {
//            matrix[j][col] = nextInt;
//            nextInt++;
//        }
    }

}

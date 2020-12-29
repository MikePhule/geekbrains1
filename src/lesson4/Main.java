package lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static final int SIZE_X = 5;
    public static final int SIZE_Y = 5;
    public static final int COUNT_TO_WIN = 4;

    public static final char DOT_AI = 'O';
    public static final char DOT_PL = 'X';
    public static final char DOT_EMPTY = '.';


    public static char[][] field = new char[SIZE_Y][SIZE_X];

    public static void initField() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printField() {
        for (int i = 0; i < SIZE_X -1; i++) {
            System.out.print("--");
        }
        System.out.println("---");
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print("|"+field[i][j]);
            }
            System.out.println("|");
            for (int k = 0; k < SIZE_X -1; k++) {
                System.out.print("--");
            }
            System.out.println("---");
        }
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean isMoveValid(int x, int y) {
        if (x < 0 || x > SIZE_X || y < 0 || y > SIZE_Y) {
            return false;
        }
        return field[y][x] == DOT_EMPTY;
    }

    public static void playerMove() {
        int moveX;
        int moveY;
        do {
            System.out.println("Enter X and Y values for move: ");
            moveX = scanner.nextInt() - 1;
            moveY = scanner.nextInt() - 1;
        } while (!isMoveValid(moveX,moveY));
        field[moveY][moveX] = DOT_PL;
    }

    public static void aiMove() {
        System.out.println("AI move:");
        Random random = new Random();
        int moveX;
        int moveY;
        int[] smartMove = smartAI();
        if (smartMove[0] == -1) {
            do {
                moveX = random.nextInt(SIZE_X);
                moveY = random.nextInt(SIZE_Y);
            } while (!isMoveValid(moveX, moveY));
        } else {
            System.out.println("Smart AI move :)");
            moveY = smartMove[0];
            moveX = smartMove[1];
        }
        field[moveY][moveX] = DOT_AI;
    }

    public static int[] smartAI() {
        int[] coordinates = new int[]{-1,-1};

        int xCountRows = 0;
        int xCountColumns = 0;
        int oCountRows = 0;
        int oCountColumns = 0;
        int dotCountRows = 0;
        int dotCountColumns = 0;
        boolean canWin = false;

        for (int k = 0; k < SIZE_Y; k++) {
            for (int i = 0; i <= SIZE_X - COUNT_TO_WIN; i++) {
                for (int j = i; j < COUNT_TO_WIN + i; j++) {
                    if (field[k][j] == 'X') {
                        xCountRows++;
                    }
                    if (field[k][j] == 'O') {
                        oCountRows++;
                    }
                    if (field[k][j] == '.') {
                        dotCountRows++;
                    }

                    if (field[j][k] == 'X') {
                        xCountColumns++;
                    }
                    if (field[j][k] == 'O') {
                        oCountColumns++;
                    }
                    if (field[j][k] == '.') {
                        dotCountColumns++;
                    }
                }

                if (oCountRows == 3 && dotCountRows > 0) {
                    canWin = true;
                    for (int j = i; j < COUNT_TO_WIN + i; j++) {
                        if (field[k][j] == '.') {
                            coordinates[0] = k;
                            coordinates[1] = j;
                        }
                    }
                }
                if (oCountColumns == 3 && dotCountColumns > 0) {
                    canWin = true;
                    for (int j = i; j < COUNT_TO_WIN + i; j++) {
                        if (field[j][k] == '.') {
                            coordinates[0] = j;
                            coordinates[1] = k;
                        }
                    }
                }

                if (xCountRows > 1 && dotCountRows > 0 && oCountRows == 0 && !canWin) {
                    for (int j = i; j < COUNT_TO_WIN + i; j++) {
                        if (field[k][j] == '.') {
                            coordinates[0] = k;
                            coordinates[1] = j;
                        }
                    }
                }
                if (xCountColumns > 1 && dotCountColumns > 0 && oCountColumns == 0 && !canWin) {
                    for (int j = i; j < COUNT_TO_WIN + i; j++) {
                        if (field[j][k] == '.') {
                            coordinates[0] = j;
                            coordinates[1] = k;
                        }
                    }
                }

                xCountColumns = 0;
                xCountRows = 0;
                oCountColumns = 0;
                oCountRows = 0;
                dotCountRows = 0;
                dotCountColumns = 0;
            }
        }

        int xCountUpperDiag = 0;
        int xCountLowerDiag = 0;
        int oCountUpperDiag = 0;
        int oCountLowerDiag = 0;
        int dotCountUpperDiag = 0;
        int dotCountLowerDiag = 0;

        for (int i = 0; i <= SIZE_X - COUNT_TO_WIN ; i++) {
            for (int j = 0; j <= SIZE_Y - COUNT_TO_WIN; j++) {
                for (int k = i; k < COUNT_TO_WIN + i; k++) {
                    if (field[k][k + j - i] == 'X') {
                        xCountUpperDiag++;
                    } else if (field[k][k + j - i] == 'O') {
                        oCountUpperDiag++;
                    } else {
                        dotCountUpperDiag++;
                    }
                    if (field[SIZE_X - 1 - k][k + j - i]  == 'X') {
                        xCountLowerDiag++;
                    } else if (field[SIZE_X - 1 - k][k + j - i]  == 'O') {
                        oCountLowerDiag++;
                    } else {
                        dotCountLowerDiag++;
                    }
                }

                if (oCountUpperDiag == 3 && dotCountUpperDiag > 0) {
                    canWin = true;
                    for (int k = i; k < COUNT_TO_WIN + i; k++) {
                        if (field[k][k + j - i] == '.') {
                            coordinates[0] = k;
                            coordinates[1] = k + j - i;
                        }
                    }
                }
                if (oCountLowerDiag == 3 && dotCountLowerDiag > 0) {
                    canWin = true;
                    for (int k = i; k < COUNT_TO_WIN + i; k++) {
                        if (field[SIZE_X - 1 - k][k + j - i]  == '.') {
                            coordinates[0] = SIZE_X - 1 - k;
                            coordinates[1] = k + j - i;
                        }
                    }
                }

                if (xCountUpperDiag > 1 && dotCountUpperDiag > 0 && oCountUpperDiag == 0 && !canWin) {
                    for (int k = i; k < COUNT_TO_WIN + i; k++) {
                        if (field[k][k + j - i] == '.') {
                            coordinates[0] = k;
                            coordinates[1] = k + j - i;
                        }
                    }
                }
                if (xCountLowerDiag > 1 && dotCountLowerDiag > 0 && oCountLowerDiag == 0 && !canWin) {
                    for (int k = i; k < COUNT_TO_WIN + i; k++) {
                        if (field[SIZE_X - 1 - k][k + j - i]  == '.') {
                            coordinates[0] = SIZE_X - 1 - k;
                            coordinates[1] = k + j - i;
                        }
                    }
                }

                xCountUpperDiag = 0;
                xCountLowerDiag = 0;
                oCountUpperDiag = 0;
                oCountLowerDiag = 0;
                dotCountUpperDiag = 0;
                dotCountLowerDiag = 0;
            }
        }

        return coordinates;
    }


    public static boolean isWon(char player) {
        // Horizontal and vertical check
        int rowCount = 0;
        int columnCount = 0;
        for (int k = 0; k < SIZE_Y; k++) {
            for (int i = 0; i <= SIZE_X - COUNT_TO_WIN; i++) {
                for (int j = i; j < COUNT_TO_WIN + i ; j++) {
                    if (field[k][j] == player) {
                        rowCount++;
                    }
                    if (field[j][k] == player) {
                        columnCount++;
                    }
                }
                if (rowCount == COUNT_TO_WIN || columnCount == COUNT_TO_WIN) return true;
                rowCount = 0;
                columnCount = 0;
            }
        }

        // Diagonal check
        int countUpperDiag = 0;
        int countLowerDiag = 0;

        for (int i = 0; i <= SIZE_X - COUNT_TO_WIN ; i++) {
            for (int j = 0; j <= SIZE_Y - COUNT_TO_WIN; j++) {
                for (int k = i; k < COUNT_TO_WIN + i; k++) {
                    if (field[k][k + j - i] == player) {
                        countUpperDiag++;
                    }
                    if (field[SIZE_X - 1 - k][k + j - i]  == player) {
                        countLowerDiag++;
                    }
                }
                if (countUpperDiag == COUNT_TO_WIN || countLowerDiag == COUNT_TO_WIN) return true;
                countUpperDiag = 0;
                countLowerDiag = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        initField();
        printField();
        while (true) {
            playerMove();
            printField();
            if (isFull()) {
                System.out.println("DRAW");
                break;
            }
            if (isWon(DOT_PL)) {
                System.out.println("Player WON!");
                break;
            }
            aiMove();
            printField();
            if (isFull()) {
                System.out.println("DRAW");
                break;
            }
            if (isWon(DOT_AI)) {
                System.out.println("AI WON!");
                break;
            }
        }
    }
}

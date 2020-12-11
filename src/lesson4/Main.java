package lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static int sizeX = 3;
    public static int sizeY = 3;

    public static final char DOT_AI = 'O';
    public static final char DOT_PL = 'X';

    public static char[][] field = new char[sizeY][sizeX];

    public static void initField() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                field[i][j] = '.';
            }
        }
    }

    public static void printField() {
        for (int i = 0; i < sizeX-1; i++) {
            System.out.print("--");
        }
        System.out.println("---");
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                System.out.print("|"+field[i][j]);
            }
            System.out.println("|");
            for (int k = 0; k < sizeX-1; k++) {
                System.out.print("--");
            }
            System.out.println("---");
        }
    }

    public static boolean isFull() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                if (field[i][j] == '.') return false;
            }
        }
        return true;
    }

    public static boolean isMoveValid(int x, int y) {
        if (x < 0 || x > sizeX || y < 0 || y > sizeY) {
            return false;
        }
        if (field[y][x] != '.') return false;

        return true;
    }

    public static void playerMove() {
        int moveX;
        int moveY;
        do {
            System.out.println("Enter X and Y values for move: ");
            moveX = scanner.nextInt() - 1;
            moveY = scanner.nextInt() - 1;
        } while (!isMoveValid(moveX,moveY));
        field[moveY][moveX] = 'X';
    }

    public static void aiMove() {
        Random random = new Random();
        int moveX;
        int moveY;
        do {
            moveX = random.nextInt(sizeX);
            moveY = random.nextInt(sizeY);
        } while (!isMoveValid(moveX,moveY));
        field[moveY][moveX] = 'O';
    }


    public static void main(String[] args) {
        initField();
        printField();
        while (!isFull()) {
            playerMove();
            printField();
            aiMove();
            printField();
        }
    }
}

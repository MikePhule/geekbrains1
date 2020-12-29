package lesson3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int menu;
    private static boolean isEnd;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (!isEnd) {
            System.out.println("Choose a game to play:");
            System.out.println("1. Guess a number");
            System.out.println("2. Guess a word");
            System.out.println("3. Format string");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    guessNumber(scanner);
                    break;
                case 2:
                    guessWord(scanner);
                    break;
                case 3:
                    formatString();
                    break;
                case 4:
                    scanner.close();
                    isEnd = true;
                    break;
            }
        }


    }
    public static void guessNumber(Scanner scanner) {
        Random random = new Random();
        menu = 1;
        while (menu == 1) {
            int tryCounter = 3;
            System.out.printf("Try to guess a number between 0 and 9. You have %d tries left. ",tryCounter);
            int guessedNumber = random.nextInt(10);
            int triedNumber;
            boolean isSolved = false;
            while (tryCounter > 0 && !isSolved) {
                System.out.print("Enter a number: ");
                triedNumber = scanner.nextByte();
                tryCounter--;
                if (triedNumber == guessedNumber || tryCounter == 0) {
                    isSolved = triedNumber == guessedNumber;
                } else if (triedNumber < guessedNumber) {
                    System.out.printf("The guessed number is bigger, try again, you have %d tries left. ", tryCounter);
                } else {
                    System.out.printf("The guessed number is smaller, try again, you have %d tries left. ", tryCounter);
                }
            }
            if (isSolved) {
                System.out.printf("Good job! You got it! The guessed number was %d ", guessedNumber);
            } else {
                System.out.printf("Bad luck! The guessed number was %d ", guessedNumber);
            }
            System.out.println("Do you want to play again?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print("Your choice: ");
            menu = scanner.nextInt();
        }
    }
    public static void guessWord(Scanner scanner) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
                "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        String guessedWord = words[random.nextInt(words.length)];
        boolean isWon = false;
        while (!isWon) {
            System.out.print("Guess a word: ");
            String triedWord = scanner.next();
            if (triedWord.equals(guessedWord)) {
                System.out.println("You're right! I was thinking about " + guessedWord + "!");
                isWon = true;
            } else {
                for (int i = 0; i < 15; i++) {
                    if (i < triedWord.length() &&
                            i < guessedWord.length() &&
                            triedWord.charAt(i) == guessedWord.charAt(i)) {
                        System.out.print(triedWord.charAt(i));
                    } else {
                        System.out.print('#');
                    }
                }
                System.out.println("");
            }
        }
    }
    public static void formatString() {
        String s = "Предложение     один  Теперь     предложение    два   Тут  предложение          три";
        StringBuilder removedSpaces = new StringBuilder(s.replaceAll(" +", " "));
        for (int i = 1; i < removedSpaces.length(); i++) {
            if (removedSpaces.charAt(i) > 'А' && removedSpaces.charAt(i) < 'Я') {
                removedSpaces.insert(i - 1,'.');
                i++;
            }
        }
        removedSpaces.append('.');
        System.out.println(removedSpaces);
    }
}

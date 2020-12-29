package lesson7;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Cat[] cats = new Cat[20];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Cat" + i, random.nextInt(20) + 1);
        }
        Plate plate = new Plate(100);
        // инфо о тарелке
        plate.info();

        for (Cat cat : cats) {
            cat.eat(plate);
            plate.addFood(random.nextInt(3));
            plate.info();
        }

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " is fed? - " + cat.isFed());
        }

    }
}

package lesson6;

import java.util.Random;

public class Cat extends Animal {

    private static int counter = 1;
    private static Random random;

    static {
        random = new Random();
    }

    public Cat() {
        super(150 + random.nextDouble()*100, 2 + random.nextDouble()*0.5, 0, "Cat" + counter);
        counter++;
    }

}

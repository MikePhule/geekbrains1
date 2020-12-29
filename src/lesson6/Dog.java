package lesson6;

import java.util.Random;

public class Dog extends Animal implements Swimable {

    private static int counter = 1;
    private static Random random;

    static {
        random = new Random();
    }
    public Dog() {
        super(400 + random.nextDouble() * 200, 0.5  + random.nextDouble() * 0.2, 10  + random.nextDouble() * 2, "Dog" + counter);
        counter++;
    }

    @Override
    public String swim(double distance) {
        return distance <= SWIM_LIMIT ? NAME + " swam " + distance + "m" : NAME + " can swim only up to " + SWIM_LIMIT + "m";
    }
}

package lesson6;

public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        Dog dog1 = new Dog();


        System.out.println(cat1.run(153));
        System.out.println(cat1.jump(2.3));
        System.out.println(dog1.run(550));
        System.out.println(dog1.jump(0.6));
        System.out.println(cat2.jump(2.2));
        System.out.println(dog1.swim(12));



    }
}

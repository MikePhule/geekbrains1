package lesson7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public boolean eatFromPlate(int n) {
        if (food - n >= 0)  {
            food -= n ;
            return true;
        } else {
            System.out.println("Not enough food");
            return false;
        }
    }
    public void addFood(int n) {
        food += n;
    }
    public void info() {
        System.out.println("plate: " + food);
    }
}
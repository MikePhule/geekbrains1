package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean isFed;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        isFed = p.eatFromPlate(appetite);
    }
    String getName(){
        return name;
    }

    public boolean isFed() {
        return isFed;
    }
}
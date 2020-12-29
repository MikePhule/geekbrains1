package lesson6;

public abstract class Animal implements Runable, Jumpable {
    protected final double RUN_LIMIT;
    protected final double JUMP_LIMIT;
    protected final double SWIM_LIMIT;

    protected final String NAME;

    public Animal(double RUN_LIMIT, double JUMP_LIMIT, double SWIM_LIMIT, String NAME) {
        this.RUN_LIMIT = RUN_LIMIT;
        this.JUMP_LIMIT = JUMP_LIMIT;
        this.SWIM_LIMIT = SWIM_LIMIT;
        this.NAME = NAME;
    }

    @Override
    public String jump(double distance) {
        return distance <= JUMP_LIMIT ? NAME + " jumped " + distance + "m" : NAME + " can jump only up to " + JUMP_LIMIT + "m";
    }

    @Override
    public String run(double distance) {
        return distance <= RUN_LIMIT ? NAME + " ran " + distance + "m" : NAME + " can run only up to " + RUN_LIMIT + "m";
    }

}

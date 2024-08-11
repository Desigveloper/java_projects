package animal_simulation;

public abstract class Feline extends Animal {
   // Constructor calls
   protected Feline() {
    super();
    }
    protected Feline(String animalnName, String loc, int bound, String food) {
        super(animalnName, loc, bound, food);
    }

    protected Feline(String animalnName, String pic, String loc, int bound, String food) {
        super(animalnName, pic, loc, bound, food);
    }

    protected Feline(String animalnName, String pic, String loc, String food, int hungerLevel) {
        super(animalnName, pic, loc, food, hungerLevel);
    }

    protected Feline(String animalnName, String pic, String loc, int bound, String food, int hungerLevel) {
        super(animalnName, pic, loc, bound, food, hungerLevel);
    }

    protected static final String PRINT_MESSAGE = "%s is %s";

    protected void printState(String action) {
        System.out.printf(PRINT_MESSAGE, getName(), action);
    }
}

class Lion extends Feline {
    @Override
    public void makeNoise() {
        printState(" actively roaring");
    }

    @Override
    public void eat() {
        printState(" eating meat");
    }

    @Override
    public void roam() {
        printState(" unable to roaming");
    }

    @Override
    public void sleep() {
        printState(" sleeping in the cage");
    }

    // Constructor calls
    protected Lion() {
        super();
    }
    protected Lion(String animalnName, String loc, int bound, String food) {
        super(animalnName, loc, bound, food);
    }
    
    protected Lion(String animalnName, String pic, String loc, int bound, String food) {
        super(animalnName, pic, loc, bound, food);
    }
    
    protected Lion(String animalnName, String pic, String loc, String food, int hungerLevel) {
        super(animalnName, pic, loc, food, hungerLevel);
    }
    
    protected Lion(String animalnName, String pic, String loc, int bound, String food, int hungerLevel) {
        super(animalnName, pic, loc, bound, food, hungerLevel);
    }
}

class Tiger extends Feline {
    @Override
    public void makeNoise() {
        printState(" making noise");
    }

    @Override
    public void eat() {
        printState(" eating flesh");
    }
    
    @Override
    public void roam() {
        printState(" roaming");
    }
    
    @Override
    public void sleep() {
        printState(" sleeping");
    }

    // Constructor calls
    protected Tiger() {
        super();
    }
    protected Tiger(String animalnName, String loc, int bound, String food) {
        super(animalnName, loc, bound, food);
    }
    
    protected Tiger(String animalnName, String pic, String loc, int bound, String food) {
        super(animalnName, pic, loc, bound, food);
    }
    
    protected Tiger(String animalnName, String pic, String loc, String food, int hungerLevel) {
        super(animalnName, pic, loc, food, hungerLevel);
    }
    
    protected Tiger(String animalnName, String pic, String loc, int bound, String food, int hungerLevel) {
        super(animalnName, pic, loc, bound, food, hungerLevel);
    }
}

class Cat extends Feline implements Pet {
    public void beFriendly() {
            printState(" being friendly");
    }

    public void play() {
            printState(" playing");
    }
    
    @Override
    public void makeNoise() {
        printState(" meawing");
    }

    @Override
    public void eat() {
        printState(" eating");
    }

    @Override
    public void roam() {
        printState(" roaming");
    }

    @Override
    public void sleep() {
        printState(" sleeping");
    }

    // Constructor calls
    protected Cat() {
        super();
    }
    protected Cat(String animalnName, String loc, int bound, String food) {
        super(animalnName, loc, bound, food);
    }
    
    protected Cat(String animalnName, String pic, String loc, int bound, String food) {
        super(animalnName, pic, loc, bound, food);
    }
    
    protected Cat(String animalnName, String pic, String loc, String food, int hungerLevel) {
        super(animalnName, pic, loc, food, hungerLevel);
    }
    
    protected Cat(String animalnName, String pic, String loc, int bound, String food, int hungerLevel) {
        super(animalnName, pic, loc, bound, food, hungerLevel);
    }
}

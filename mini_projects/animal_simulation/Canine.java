package animal_simulation;

public abstract class Canine extends Animal {
    // Constructor calls
    protected Canine() {
        super();
    }
    protected Canine(String animalnName, String loc, int bound, String food) {
        super(animalnName, loc, bound, food);
    }
    
    protected Canine(String animalnName, String pic, String loc, int bound, String food) {
        super(animalnName, pic, loc, bound, food);
    }
    
    protected Canine(String animalnName, String pic, String loc, String food, int hungerLevel) {
        super(animalnName, pic, loc, food, hungerLevel);
    }
    
    protected Canine(String animalnName, String pic, String loc, int bound, String food, int hungerLevel) {
        super(animalnName, pic, loc, bound, food, hungerLevel);
    }
}


class Wolf extends Canine {
    @Override
    public void makeNoise() {
        System.out.println("Making noise");
    }
    
    @Override
    public void eat() {
        System.out.println("Eating");
    }@Override
    public void roam() {
        System.out.println("Roaming");
    }@Override
    public void sleep() {
        System.out.println("Sleeping");
    }

    // Constructor calls
    public Wolf() {
        super();
    }
    public Wolf(String animalnName, String loc, int bound, String food) {
        super(animalnName, loc, bound, food);
    }
    
    public Wolf(String animalnName, String pic, String loc, int bound, String food) {
        super(animalnName, pic, loc, bound, food);
    }
    
    public Wolf(String animalnName, String pic, String loc, String food, int hungerLevel) {
        super(animalnName, pic, loc, food, hungerLevel);
    }
    
    public Wolf(String animalnName, String pic, String loc, int bound, String food, int hungerLevel) {
        super(animalnName, pic, loc, bound, food, hungerLevel);
    }
}

class Dog extends Canine implements Pet {
    @Override
    public void beFriendly() {
      System.out.println("Being friendly");
    }

    @Override
    public void play() {
        System.out.println("Playing");
    }
    @Override
    public void makeNoise() {
        System.out.println("Making noise");
    }
    
    @Override
    public void eat() {
        System.out.println("Eating");
    }
    @Override
    public void roam() {
        System.out.println("Roaming");
    }
    
    @Override
    public void sleep() {
        System.out.println("Sleeping");
    }

    // Constructor calls
    public Dog() {
        super();
    }
    public Dog(String animalnName, String loc, int bound, String food) {
        super(animalnName, loc, bound, food);
    }
    
    public Dog(String animalnName, String pic, String loc, int bound, String food) {
        super(animalnName, pic, loc, bound, food);
    }
    
    public Dog(String animalnName, String pic, String loc, String food, int hungerLevel) {
        super(animalnName, pic, loc, food, hungerLevel);
    }
    
    public Dog(String animalnName, String pic, String loc, int bound, String food, int hungerLevel) {
        super(animalnName, pic, loc, bound, food, hungerLevel);
    }
}
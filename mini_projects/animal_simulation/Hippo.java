package animal_simulation;

public class Hippo extends Animal{

    @Override
    public void makeNoise() {
        System.out.println("Making noise");
    }

    @Override
    public void eat() {
        System.out.println("Is eatig");
    }
    
    @Override
    public void roam() {
        System.out.println("Is roaming");
    }
    
    @Override
    public void sleep() {
        System.out.println("Is sleping");
    }

    // Constructor calls
    public Hippo() {
        super();
    }
    public Hippo(String animalnName, String loc, int bound, String food) {
        super(animalnName, loc, bound, food);
    }
    
    public Hippo(String animalnName, String pic, String loc, int bound, String food) {
        super(animalnName, pic, loc, bound, food);
    }
    
    public Hippo(String animalnName, String pic, String loc, String food, int hungerLevel) {
        super(animalnName, pic, loc, food, hungerLevel);
    }
    
    public Hippo(String animalnName, String pic, String loc, int bound, String food, int hungerLevel) {
        super(animalnName, pic, loc, bound, food, hungerLevel);
    }
}

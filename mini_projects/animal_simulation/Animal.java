package animal_simulation;

public abstract class Animal {
    private String name;
    private String picture;
    private String food;
    private int hunger;
    private int boundary;
    private String location;

    public String getName() {
        return this.name;
    }
    public String getPicture() {
        return this.picture;
    }
        
    public String getFood() {
        return this.food;
    }

    public String getLocation() {
        return this.location;
    } 

   public int getHunger() {
    return this.hunger;
   }

   public int getBoundary() {
        return this.boundary;
   }
   
    public abstract void makeNoise();

    public abstract void eat();

    public abstract void sleep();

    public abstract void roam();

    //Constructrors
    protected Animal() {
        name = "No name";
        picture = "No image";
        location = "No location found";
        food = null;
        hunger = 0;
        boundary = 0;
    }
    
    protected Animal(String animalnName, String loc, int bound, String food) {
        this.name = animalnName;
        picture = "No image";
        this.location = loc;
        this.boundary = bound;
        this.food = food;
        hunger = 0;
    }
    
    protected Animal(String animalnName, String pic, String loc, int bound, String food) {
        this.name = animalnName;
        this.picture = pic;
        this.location = loc;
        this.boundary = bound;
        this.food = food;
        hunger = 0;
    }
    
    protected Animal(String animalnName, String pic, String loc, String food, int hungerLevel) {
        this.name = animalnName;
        this.picture = pic;
        this.location = loc;
        this.food = food;
        this.hunger = hungerLevel;
        boundary = 0;
    }
    
    protected Animal(String animalnName, String pic, String loc, int bound, String food, int hungerLevel) {
        this.name = animalnName;
        this.picture = pic;
        this.location = loc;
        this.boundary = bound;
        this.food = food;
        this.hunger = hungerLevel;
    }

    
}

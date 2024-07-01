package mini_projects.animalSimulation;

public class Animal {
    private String picture;
    private String food;
    private int hunger;
    private int boundary;
    private String location;

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String pic) {
        this.picture = pic;
    }

    public String getFood() {
        return this.food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return this.location;
    } 

    public void setLocation(String loc) {
        this.location = loc;
    }

   public int getHunger() {
    return this.hunger;
   }

   public void setHunger(int hungerLevel) {
        this.hunger = hungerLevel;
   }

   public int getBoundary() {
        return this.boundary;
   }

   public void setBoundary(int boundary) {
        this.boundary = boundary;
   }
   
    public void makeNoise() {

    }

    public void eat() {

    }

    public void sleep() {

    }

    public void roam() {

    }
}

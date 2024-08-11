package animal_simulation;

public class AnimalSimulate {
    public static void main(String[] args) {
        // Animal a = new Animal(); //This is not allowed. An abstract class can't be instantiated
        Hippo h1 = new Hippo();
        Hippo h2 = new Hippo("Buffy", "water", 200, "Meat");
        Cat cat = new Cat("Belly", "Land", 20, "fish");
        Animal[] animals = {new Hippo(), new Wolf(), new Tiger(), new Lion(), new Cat(), new Dog()};

        System.out.println(h1.getName());
        System.out.println(h2.getName());
        System.out.println(cat.getName());
        System.out.println(cat.getHunger());
        

        for (Animal animal : animals) {
            animal.eat();
        }
    }
}

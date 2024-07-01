package mini_projects.animalSimulation;

public class AnimalSimulate {
    public static void main(String[] args) {
        Animal a = new Animal();
        Hippo h = new Hippo();
        Animal[] animals = {new Hippo(), new Wolf(), new Tiger(), new Lion(), new Cat(), new Dog()};

        h.setLocation("Water");
        System.out.println(h.getLocation());
        System.out.println(a.getLocation());
        System.out.println("Animal Reference: " + a);
        System.out.println("Hippo Reference: " + h);
        System.out.println("Animals array Reference: " + animals);

        for (Animal animal : animals) {
            System.out.println(animal.getLocation());
        }
    }
}

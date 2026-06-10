// POLYMORPHISM — One interface, many forms
// Runtime Polymorphism = method overriding + upcasting
// The method that runs is decided at RUNTIME based on actual object type
// NOT at compile time based on reference type

class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void sound() {
        System.out.println(name + " makes a generic sound");
    }

    void describe() {
        System.out.println("I am an Animal named " + name);
    }
}

class Elephant extends Animal {
    Elephant(String name) { super(name); }

    @Override
    void sound() {
        System.out.println(name + " says: PAWOOOO!");
    }

    @Override
    void describe() {
        System.out.println("I am an Elephant named " + name + " I have a trunk and big ears!");
    }
}

class Lion extends Animal {
    Lion(String name) { super(name); }

    @Override
    void sound() {
        System.out.println(name + " says: ROARRR! ");
    }

    @Override
    void describe() {
        System.out.println("I am a Lion named " + name + " I am the king of the jungle!");
    }
}

class Dog extends Animal {
    Dog(String name) { super(name); }

    @Override
    void sound() {
        System.out.println(name + " says: WOOF WOOF! ");
    }

    @Override
    void describe() {
        System.out.println("I am a Dog named " + name + "  man's best friend!");
    }
}

public class PolymorphismDemo {

    static void makeAnimalSpeak(Animal animal) {
        animal.sound();   // calls the CORRECT version at runtime
        animal.describe();
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println(" POLYMORPHISM DEMO \n");
        Animal[] zoo = {
            new Elephant("Dumbo"),
            new Lion("Simba"),
            new Dog("Bruno"),
            new Elephant("Nelly"),
            new Lion("Mufasa")
        };

        System.out.println(" Making all animals speak (Runtime Polymorphism)\n");

        for (Animal a : zoo) {
            makeAnimalSpeak(a); 
        }

        System.out.println("Key Takeaway ");
        System.out.println("Same method call: animal.sound()");
        System.out.println("Different output based on ACTUAL object type at runtime");
        System.out.println("This is Runtime Polymorphism / Dynamic Method Dispatch");
        System.out.println();
        System.out.println("Without polymorphism, we'd need:");
        System.out.println("if (animal is Elephant) -> elephantSound()");
        System.out.println("if (animal is Lion)     -> lionSound()");
        System.out.println("if (animal is Dog)      -> dogSound()");
        System.out.println("... and update this every time a new animal is added. Terrible!");
    }
}

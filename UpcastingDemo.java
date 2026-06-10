
// UPCASTING — Storing Child object in Parent reference
// Upcasting = going UP the inheritance tree
// Child → Parent (safe, automatic, no explicit cast needed)

class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void sound() {
        System.out.println(name + " makes a sound");
    }

    void breathe() {
        System.out.println(name + " is breathing");
    }
}

class Elephant extends Animal {

    Elephant(String name) {
        super(name); // calling Animal's constructor
    }

    @Override
    void sound() {
        System.out.println(name + " trumpets loudly!");
    }

    // Elephant-specific method
    void useTrunk() {
        System.out.println(name + " is using its trunk to drink water");
    }
}

class Lion extends Animal {

    Lion(String name) {
        super(name);
    }

    @Override
    void sound() {
        System.out.println(name + " ROARS!");
    }

    // Lion-specific method
    void hunt() {
        System.out.println(name + " is hunting prey");
    }
}

public class UpcastingDemo {
    public static void main(String[] args) {

        System.out.println("UPCASTING DEMO \n");

        // UPCASTING — Child object assigned to Parent reference
        Animal a1 = new Elephant("Dumbo");  // Upcasting
        Animal a2 = new Lion("Simba");       // Upcasting

        System.out.println("Both stored as Animal reference:\n");

        // sound() calls the CHILD's version due to polymorphism
        a1.sound();  // Elephant's sound
        a2.sound();  // Lion's sound

        System.out.println();
        a1.breathe(); // Inherited from Animal
        a2.breathe(); // Inherited from Animal

        System.out.println();
        System.out.println(" What you CAN'T do after upcasting");
        System.out.println("a1.useTrunk() COMPILE ERROR (Animal ref doesn't know about useTrunk)");
        System.out.println("Even though the actual object IS an Elephant, the reference type is Animal");
        System.out.println("Reference type controls what methods you can CALL");
        System.out.println("Object type controls which version of the method actually RUNS");

        System.out.println();
        System.out.println("WHY UPCAST? ");
        System.out.println("So one variable/method can hold ANY animal type.");
        System.out.println("This is the power of polymorphism . write once, work for all subclasses.");
    }
}

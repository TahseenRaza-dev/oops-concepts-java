// ============================================================
// DOWNCASTING — Converting Parent reference back to Child type
// ============================================================
// Downcasting = going DOWN the inheritance tree
// Parent reference → Child type (NOT automatic, needs explicit cast)
// DANGER: If done incorrectly → ClassCastException at RUNTIME
// SAFE WAY: Always use instanceof check before downcasting
// ============================================================

class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    void sound() {
        System.out.println(name + " makes a sound");
    }
}

class Elephant extends Animal {
    Elephant(String name) { super(name); }

    @Override
    void sound() {
        System.out.println(name + " trumpets! 🐘");
    }

    void useTrunk() {
        System.out.println(name + " is picking up water with its trunk 💧");
    }

    void flap() {
        System.out.println(name + " is flapping its big ears to cool down");
    }
}

class Lion extends Animal {
    Lion(String name) { super(name); }

    @Override
    void sound() {
        System.out.println(name + " roars! 🦁");
    }

    void hunt() {
        System.out.println(name + " is chasing prey at full speed");
    }
}

public class DowncastingDemo {
    public static void main(String[] args) {

        System.out.println("===== DOWNCASTING DEMO =====\n");

        // Step 1: Upcast — Elephant stored as Animal
        Animal a = new Elephant("Dumbo");
        a.sound(); // works — polymorphism

        // a.useTrunk() → COMPILE ERROR — Animal ref doesn't know useTrunk()
        // Even though the actual object IS an Elephant!

        System.out.println();
        System.out.println("--- DOWNCASTING to access Elephant-specific methods ---");

        // Step 2: Downcast — explicitly cast back to Elephant
        // Only works because the actual object IS an Elephant
        Elephant e = (Elephant) a;
        e.useTrunk(); // now we can call Elephant-specific methods
        e.flap();

        System.out.println();
        System.out.println("--- UNSAFE Downcasting (ClassCastException) ---");

        Animal lion = new Lion("Simba");

        // ❌ WRONG: lion is actually a Lion, NOT an Elephant
        // This compiles fine but CRASHES at runtime
        try {
            Elephant wrongCast = (Elephant) lion; // ClassCastException!
            wrongCast.useTrunk();
        } catch (ClassCastException ex) {
            System.out.println("💥 ClassCastException caught! Cannot cast Lion to Elephant");
            System.out.println("Error: " + ex.getMessage());
        }

        System.out.println();
        System.out.println("--- SAFE Downcasting using instanceof ---");

        // ✅ CORRECT WAY: Always check with instanceof before downcasting
        Animal[] animals = { new Elephant("Nelly"), new Lion("Mufasa"), new Elephant("Jumbo") };

        for (Animal animal : animals) {
            if (animal instanceof Elephant) {
                Elephant elephant = (Elephant) animal; // safe now
                elephant.useTrunk();
            } else if (animal instanceof Lion) {
                Lion l = (Lion) animal; // safe now
                l.hunt();
            }
        }

        System.out.println();
        System.out.println("--- Key Takeaway ---");
        System.out.println("Upcasting   → automatic, always safe");
        System.out.println("Downcasting → manual, use instanceof first, otherwise ClassCastException");
    }
}

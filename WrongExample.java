// WHY THIS IS WRONG: Elephant E = new Animal();
// Rule: You CANNOT assign a Parent object to a Child reference.
// Reason: Every Elephant IS an Animal, but NOT every Animal IS an Elephant.
// An Animal could be a Lion, Dog, Cat — not necessarily an Elephant.
// The compiler throws: "incompatible types: Animal cannot be converted to Elephant"

class Animal {
    String name = "Animal";

    void sound() {
        System.out.println("Some generic animal sound");
    }

    void eat() {
        System.out.println("Animal is eating");
    }
}

class Elephant extends Animal {
    String type = "Elephant";

    // Elephant-specific method — Animal doesn't have this
    void trunkAction() {
        System.out.println("Elephant is using its trunk");
    }

    @Override
    void sound() {
        System.out.println("Elephant trumpets!");
    }
}

public class WrongExample {
    public static void main(String[] args) {
        Animal a = new Elephant();
        System.out.println("CORRECT: Animal a = new Elephant();  works fine");
        a.sound(); 

        System.out.println();

        // WRONG - This line below won't even compile
        // Uncomment it to see the compile error yourself:
        // Elephant E = new Animal();
        // Error: incompatible types: Animal cannot be converted to Elephant

        System.out.println("WRONG: Elephant E = new Animal(); COMPILE ERROR");
        System.out.println("Reason: Animal is the parent. Not every Animal is an Elephant.");
        System.out.println("The compiler cannot guarantee the Animal object has Elephant-specific features like trunkAction()");
    }
}

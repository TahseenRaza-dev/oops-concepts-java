# OOP Concepts in Java — Type System, Inheritance & Polymorphism

> Internship Learning Task – Accenture (2026)

This repository explores some of the most important Object-Oriented Programming (OOP) concepts in Java, starting from a commonly misunderstood statement:

```java
Elephant e = new Animal();
```

Understanding why this statement fails helps build a strong foundation in inheritance, type compatibility, upcasting, and runtime polymorphism.

---

# Learning Objectives

By working through these examples, you will understand:

- Classes and Objects
- Inheritance
- The IS-A Relationship
- Upcasting
- Runtime Polymorphism
- Method Overriding
- Real-world usage of interfaces and abstractions

---

# Classes and Objects

## What is a Class?

A class is a blueprint or template used to create objects.

Example:

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}
```

Here, `Animal` defines the behavior that all animal objects can have.

## What is an Object?

An object is an instance of a class.

```java
Animal animal = new Animal();
```

- `Animal` → Class
- `animal` → Reference Variable
- `new Animal()` → Object Creation

Objects contain state (data) and behavior (methods).

---

# Problem Statement

```java
Elephant e = new Animal();
```

Why does this not work?

## Answer

Because:

> Every Elephant is an Animal, but not every Animal is an Elephant.

An `Animal` object could represent:

- Elephant
- Lion
- Dog
- Tiger

Since Java cannot guarantee that every Animal is specifically an Elephant, the assignment is rejected during compilation.

Compiler Error:

```text
incompatible types: Animal cannot be converted to Elephant
```

---

# Understanding the IS-A Rule

Before assigning one object type to another, ask:

> "Is the object on the right side a type of the reference on the left side?"

### Valid

```java
Animal a = new Elephant();
```

Question:

```text
Is an Elephant an Animal?
```

Answer:

```text
YES
```

Therefore, the assignment is valid.

### Invalid

```java
Elephant e = new Animal();
```

Question:

```text
Is an Animal an Elephant?
```

Answer:

```text
NO
```

Therefore, Java throws a compilation error.

---

# Project Structure

| # | Concept | File |
|---|----------|------|
| 1 | Invalid Assignment Example | `1_wrong_code/WrongExample.java` |
| 2 | Upcasting | `2_upcasting/UpcastingDemo.java` |
| 3 | Runtime Polymorphism | `3_polymorphism/PolymorphismDemo.java` |
| 4 | Real-World Usage | `5_real_world/RealWorldExample.java` |

---

# Implementation Walkthrough

## 1. Why the Original Line is Wrong

Example:

```java
Elephant e = new Animal();
```

Java prevents this because the object being created is an `Animal`, not necessarily an `Elephant`.

This violates type safety and therefore fails at compile time.

### Output

![Wrong Example Output](images/wrong_example_output.png)

---

## 2. Upcasting

Upcasting means storing a child object inside a parent reference.

```java
Animal a = new Elephant("Dumbo");
```

This is safe because every Elephant is also an Animal.

### Benefits

- Flexibility
- Code Reusability
- Support for Polymorphism

Example:

```java
a.sound();
```

Even though the reference type is `Animal`, Java executes the method belonging to the actual object (`Elephant`).

### Important Rule

| Type | Responsibility |
|--------|---------------|
| Reference Type | Determines what methods are accessible at compile time |
| Object Type | Determines which overridden method executes at runtime |

### Output

![Upcasting Output](images/upcasting_output.png)

---

## 3. Runtime Polymorphism

Polymorphism means:

> One interface, multiple implementations.

Example:

```java
Animal[] zoo = {
    new Elephant("Dumbo"),
    new Lion("Simba"),
    new Dog("Bruno")
};

for (Animal a : zoo) {
    a.sound();
}
```

Although every element is referenced as an `Animal`, each object executes its own implementation of `sound()`.

### Runtime Behavior

```text
Dumbo -> Elephant sound
Simba -> Lion sound
Bruno -> Dog sound
```

This is known as **Dynamic Method Dispatch** or **Runtime Polymorphism**.

### Why It Matters

Without polymorphism:

```java
if(animal instanceof Elephant) { ... }
else if(animal instanceof Lion) { ... }
else if(animal instanceof Dog) { ... }
```

With polymorphism:

```java
animal.sound();
```

Cleaner, scalable, and easier to maintain.

### Output

![Polymorphism Output](images/polymorphism_output.png)

---

## 4. Real-World Usage

The same concept is heavily used throughout Java's Collections Framework.

Example:

```java
List<String> list = new ArrayList<>();
Map<String, Integer> map = new HashMap<>();
```

Here:

| Abstraction | Implementation |
|------------|---------------|
| List | ArrayList |
| Map | HashMap |

Developers program against interfaces rather than concrete implementations.

### Benefits

- Loose Coupling
- Better Maintainability
- Easier Testing
- Flexible Implementations

For example:

```java
List<String> list = new LinkedList<>();
```

The implementation changes while the rest of the code remains unchanged.

### Output

![Real World Output](images/realworld_output.png)

---

# How to Run

Ensure JDK is installed and configured.

Compile and execute any example:

```bash
cd 1_wrong_code

javac WrongExample.java

java WrongExample
```

Repeat the same process for the remaining folders.

---

# Key Takeaways

- A class is a blueprint; an object is its instance.
- Inheritance establishes an IS-A relationship.
- Every Elephant is an Animal, but not every Animal is an Elephant.
- Upcasting (Child → Parent) is automatic and safe.
- Runtime polymorphism allows the same method call to produce different behaviors.
- Reference type determines accessible methods; object type determines executed methods.
- Programming against abstractions (interfaces/parent classes) creates flexible and maintainable applications.
- These principles form the foundation of scalable enterprise Java applications.

---

# What I Learned

Through this exercise, I gained a deeper understanding of how Java's type system works and why inheritance enables flexible application design. I learned how upcasting supports abstraction, how polymorphism allows behavior to be determined at runtime, and why enterprise applications rely heavily on programming to interfaces rather than concrete implementations.

These concepts form the foundation of writing maintainable, extensible, and scalable object-oriented software.

---

# Conclusion

The statement:

```java
Elephant e = new Animal();
```

fails because Java enforces type safety. Understanding why it fails naturally leads to understanding inheritance, upcasting, and polymorphism—the core concepts that make Object-Oriented Programming powerful and widely used in real-world software development.

---

**Author:** Tahseen Raza  
**Internship:** Accenture Internship 2026  
**Topic:** Java OOP Concepts – Inheritance, Upcasting & Polymorphism

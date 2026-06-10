# OOP Concepts in Java — Type System & Polymorphism

> Explored as part of an internship task at Accenture.  
> Starting point: **`Elephant E = new Animal();`** — Why is this wrong?

---

## The Question

```java
Elephant E = new Animal();  // ❌ Why doesn't this work?
```

This one line covers a set of core OOP concepts — inheritance, type rules, upcasting, downcasting, and polymorphism. This repo breaks down everything with working code and examples.

---

## The Short Answer

**Every Elephant IS an Animal. But NOT every Animal IS an Elephant.**

An `Animal` object could be a Lion, a Dog, anything. It doesn't have Elephant-specific features. So the compiler rejects it with:

```
incompatible types: Animal cannot be converted to Elephant
```

The correct version:
```java
Animal E = new Elephant();  // ✅ Upcasting — always safe
```

---

## Concepts Covered

| # | Concept | File |
|---|---------|------|
| 1 | Why the original line is wrong | `1_wrong_code/WrongExample.java` |
| 2 | Upcasting | `2_upcasting/UpcastingDemo.java` |
| 3 | Polymorphism (Runtime) | `3_polymorphism/PolymorphismDemo.java` |
| 4 | Downcasting + instanceof | `4_downcasting/DowncastingDemo.java` |
| 5 | Real-world usage | `5_real_world/RealWorldExample.java` |

---

## Concept Breakdown

### 1. The IS-A Rule
Before assigning objects, always ask:  
*"IS a [right side] a [left side]?"*

```java
Animal a = new Elephant();   // Is an Elephant an Animal? ✅ YES → works
Elephant e = new Animal();   // Is an Animal an Elephant? ❌ NO  → compile error
```

---

### 2. Upcasting
Storing a child object in a parent reference. Automatic and always safe.

```java
Animal a = new Elephant("Dumbo");
a.sound();  // calls Elephant's sound() — not Animal's
```

**Reference type** → controls what methods you can CALL  
**Object type** → controls which version actually RUNS

---

### 3. Polymorphism
Same method call, different behavior depending on actual object type. Decided at **runtime**.

```java
Animal[] zoo = { new Elephant("Dumbo"), new Lion("Simba"), new Dog("Bruno") };

for (Animal a : zoo) {
    a.sound();  // each animal makes ITS OWN sound
}
```

Without polymorphism you'd need endless if-else chains. With it — one line handles everything.

---

### 4. Downcasting
Going from parent reference back to child type. Needs explicit cast. Use `instanceof` first or risk `ClassCastException`.

```java
Animal a = new Elephant("Dumbo");

// ❌ Unsafe
Elephant e = (Elephant) a;  // works here, but risky in general

// ✅ Safe way
if (a instanceof Elephant) {
    Elephant e = (Elephant) a;
    e.useTrunk();  // now you can access Elephant-specific methods
}
```

---

### 5. Real-World Usage
This pattern appears everywhere in Java:

```java
List<String> list = new ArrayList<>();   // not ArrayList<String>
Map<String, Integer> map = new HashMap<>();
```

`List` and `Map` are interfaces (like `Animal`). `ArrayList` and `HashMap` are implementations (like `Elephant`). You program to the general type so you can swap implementations without changing any other code.

---

## How to Run

Make sure you have JDK installed. Then:

```bash
# Example: Run the polymorphism demo
cd 3_polymorphism
javac PolymorphismDemo.java
java PolymorphismDemo
```

Same pattern for all files — `cd` into the folder, compile, run.

---

## Key Takeaways

- **Upcasting** → child to parent, automatic, safe, used for flexibility
- **Downcasting** → parent to child, manual, use `instanceof`, risky if wrong
- **Polymorphism** → same reference, different behavior at runtime
- **Real rule** → program to parent types/interfaces, not specific implementations
- **Why it matters** → flexible, extensible code — add new subclasses without touching existing logic (Open/Closed Principle)

---

*Explored by Ayan | Accenture Internship 2026*

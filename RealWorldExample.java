// ============================================================
// REAL WORLD EXAMPLE — How these concepts appear in actual code
// ============================================================
// In real Java codebases you ALWAYS see:
//   List<String> list = new ArrayList<>();     (not ArrayList<String>)
//   Map<String, Integer> map = new HashMap<>(); (not HashMap<String, String>)
// This is the same upcasting + polymorphism concept — just with interfaces
// ============================================================

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

// ---- Custom example: Payment System ----
// Imagine you're building a payment feature
// You don't want your code to depend on ONE specific payment method
// Tomorrow the client may add UPI, Crypto, etc.

abstract class PaymentMethod {
    String userName;

    PaymentMethod(String userName) {
        this.userName = userName;
    }

    // Every payment method must implement this
    abstract void processPayment(double amount);

    void printReceipt(double amount) {
        System.out.println("Receipt: " + userName + " paid " + amount);
    }
}

class CreditCard extends PaymentMethod {
    String cardNumber;

    CreditCard(String userName, String cardNumber) {
        super(userName);
        this.cardNumber = cardNumber;
    }

    @Override
    void processPayment(double amount) {
        System.out.println("Processing " + amount + " via Credit Card ending in " + cardNumber.substring(cardNumber.length() - 4));
        printReceipt(amount);
    }
}

class UPI extends PaymentMethod {
    String upiId;

    UPI(String userName, String upiId) {
        super(userName);
        this.upiId = upiId;
    }

    @Override
    void processPayment(double amount) {
        System.out.println("Processing " + amount + " via UPI ID: " + upiId);
        printReceipt(amount);
    }
}

class NetBanking extends PaymentMethod {
    String bankName;

    NetBanking(String userName, String bankName) {
        super(userName);
        this.bankName = bankName;
    }

    @Override
    void processPayment(double amount) {
        System.out.println(" Processing " + amount + " via Net Banking: " + bankName);
        printReceipt(amount);
    }
}
class Checkout {
    // Accepts PaymentMethod reference — not CreditCard, not UPI specifically
    static void completeOrder(PaymentMethod payment, double amount) {
        System.out.println("\nInitiating checkout for: " + payment.userName);
        payment.processPayment(amount); // polymorphism — correct method runs
        System.out.println(" Order complete!\n");
    }
}

public class RealWorldExample {
    public static void main(String[] args) {

        System.out.println(" REAL WORLD EXAMPLE\n");

        //  Part 1: Java Collections (you'll see this EVERYWHERE)
        System.out.println("Part 1: Java Collections \n");

        // List is interface (like Animal), ArrayList is implementation (like Elephant)
        List<String> names = new ArrayList<>();  // Upcasting with interface
        names.add("Ayan");
        names.add("Rahul");
        names.add("Priya");

        // If tomorrow we switch to LinkedList — only ONE line changes
        // List<String> names = new LinkedList<>();
        // Rest of the code stays EXACTLY the same — that's the power

        for (String name : names) {
            System.out.println("Hello, " + name + "!");
        }

        System.out.println();

        Map<String, Integer> scores = new HashMap<>(); // same concept with Map
        scores.put("Ayan", 95);
        scores.put("Rahul", 88);
        scores.put("Priya", 92);

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " scored: " + entry.getValue());
        }

        System.out.println();

        //  Part 2: Payment System 
        System.out.println("Part 2: Payment System (Custom Example) ");

        // Different payment methods — all stored as PaymentMethod (upcasting)
        PaymentMethod p1 = new CreditCard("Ayan", "1234567890123456");
        PaymentMethod p2 = new UPI("Rahul", "rahul@okaxis");
        PaymentMethod p3 = new NetBanking("Priya", "HDFC Bank");

        // Same checkout method handles ALL of them — polymorphism
        Checkout.completeOrder(p1, 1499.00);
        Checkout.completeOrder(p2, 799.00);
        Checkout.completeOrder(p3, 2999.00);

        System.out.println("Key Takeaway ");
        System.out.println("In real projects, you ALWAYS program to a parent type or interface");
        System.out.println("Your code becomes flexible add new types without changing existing code");
        System.out.println("This is called the Open/Closed Principle  one of the SOLID principles");
        System.out.println("Open for extension (add new payment), Closed for modification (don't touch Checkout)");
    }
}

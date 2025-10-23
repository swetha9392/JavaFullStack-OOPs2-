

/*💡 Real-World Example 1:

Interface: Payment
Implementations: CreditCardPayment, UPIPayment, PayPalPayment

👉 In real life, every payment method has to perform a pay() action, but how it works differs.*/
// Interface
interface Payment {
    void pay(double amount);
}

// Implementation 1
class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}

// Implementation 2
class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

// Implementation 3
class PayPalPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal");
    }
}

// Main class
public class PaymentExample {
    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment();
        Payment p2 = new UPIPayment();
        Payment p3 = new PayPalPayment();

        p1.pay(1000);
        p2.pay(500);
        p3.pay(2000);
    }
}

/*✅ Why use an interface here?
Because you can add new payment types (like NetBankingPayment) later without changing existing code — only implement the Payment interface. */


Q.is normal methods allowed in interdface??
In Java, yes, interfaces can have certain types of methods — but with specific rules.

💡 Before Java 8

➡️ Interfaces could have only abstract methods (methods without body).
Example 👇

interface Animal {
    void sound(); // abstract method
}


No method body was allowed.


💡 From Java 8 onwards

Java made interfaces more powerful by allowing two new types of methods:

1️⃣ Default Methods

Introduced in Java 8.

Can have a method body.

Used when you want to provide a default implementation that can be overridden by implementing classes.

Example:
interface Animal {
    void sound(); // abstract method

    default void eat() {      // ✅ normal method (default)
        System.out.println("Animals can eat");
    }
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
        d.eat(); // calling default method
    }
}


🧠 Output:

Dog barks
Animals can eat


✅ Here, eat() is a normal (default) method inside an interface — allowed from Java 8.

2️⃣ Static Methods

Also introduced in Java 8.

Belong to the interface itself (not to implementing classes).

Called using the interface name, not the object.

Example:
interface MathUtils {
    static int add(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(MathUtils.add(10, 5)); // ✅ static method call
    }
}


🧠 Output:

15

3️⃣ Private Methods (from Java 9 onwards)

Used only inside the interface to reuse code between default or static methods.

Not accessible outside the interface.

Example:
interface Helper {
    private void log(String message) {  // private method
        System.out.println("Log: " + message);
    }

    default void process() {
        log("Processing started...");
        System.out.println("Work done!");
    }
}

class Task implements Helper {}

public class Main {
    public static void main(String[] args) {
        new Task().process();
    }
}


🧠 Output:

Log: Processing started...
Work done!

✅ Summary Table
Method Type	Allowed In Interface?	Since Java Version	Can Have Body?	Accessed By
Abstract	✅ Yes	Always	❌ No	Implementing class
Default	✅ Yes	Java 8	✅ Yes	Object of implementing class
Static	✅ Yes	Java 8	✅ Yes	Interface name
Private	✅ Yes	Java 9	✅ Yes	Inside interface only

So, to answer simply:

🔹 Yes, interfaces can have normal methods,
but they must be default, static, or private methods — not regular instance methods like in classes.


Real world example 

interface ATM {
    // abstract method
    void withdraw(double amount);

    // default method
    default void checkBalance(double balance) {
        System.out.println("Your current balance is: ₹" + balance);
    }

    // static method
    static void bankInfo() {
        System.out.println("Welcome to ABC Bank ATM");
    }
}

class UserAccount implements ATM {
    double balance = 5000;

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
            checkBalance(balance); // calling default method
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // calling static method
        ATM.bankInfo();

        UserAccount user = new UserAccount();
        user.withdraw(1500);  // abstract method
        user.withdraw(4000);  // insufficient balance example
    }
}



What is a Functional Interface?

A Functional Interface is an interface that has exactly one abstract method.

➡️ It can have any number of default or static methods, but only one abstract method.
➡️ It is mainly used with Lambda Expressions and Streams API.




If your class is non-abstract, it must implement all abstract methods from the interface.
You can’t divide method implementation among multiple non-abstract classes.
Only abstract classes can partially implement.

interface Shape {
    void draw();
    void area();
    void color();
}

// Abstract class implements only one method
abstract class PartialShape implements Shape {
    public void draw() {
        System.out.println("Drawing shape");
    }
    // area() and color() not implemented → okay because abstract
}

// Concrete class must implement remaining methods
class Circle extends PartialShape {
    public void area() {
        System.out.println("Area = πr²");
    }
    public void color() {
        System.out.println("Color = Red");
    }
}

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.draw();   // implemented in abstract class
        c.area();   // implemented in concrete class
        c.color();  // implemented in concrete class
    }
}

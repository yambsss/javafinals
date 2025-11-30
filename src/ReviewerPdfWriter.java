import java.util.Scanner;

public class ReviewerPdfWriter {
    private Scanner scanner;
    
    public ReviewerPdfWriter() {
        this.scanner = new Scanner(System.in);
    }
    
    public void displayReview(String topic) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("           REVIEW MODE: " + topic.toUpperCase());
        System.out.println("═".repeat(60) + "\n");
        
        switch (topic.toLowerCase()) {
            case "introduction":
                displayIntroductionReview();
                break;
            case "conditionals":
                displayConditionalsReview();
                break;
            case "loops":
                displayLoopsReview();
                break;
            case "arrays":
                displayArraysReview();
                break;
            case "encapsulation":
                displayEncapsulationReview();
                break;
            case "inheritance":
                displayInheritanceReview();
                break;
            case "polymorphism":
                displayPolymorphismReview();
                break;
            default:
                System.out.println("❌ Review content not available for this topic.");
        }
        
        System.out.print("\nPress Enter to return to main menu...");
        scanner.nextLine();
    }
    
    private void displayIntroductionReview() {
        System.out.println("📚 INTRODUCTION TO OBJECT-ORIENTED PROGRAMMING\n");
        
        System.out.println("🔹 What is OOP?");
        System.out.println("Object-Oriented Programming is a programming paradigm based on");
        System.out.println("objects and classes. It helps organize code in a more manageable");
        System.out.println("and reusable way.\n");
        
        System.out.println("🔹 Key Concepts:");
        System.out.println("• CLASS - A blueprint or template for creating objects");
        System.out.println("• OBJECT - An instance of a class with specific data");
        System.out.println("• METHOD - Functions that define object behavior");
        System.out.println("• ATTRIBUTE - Variables that store object state\n");
        
        System.out.println("🔹 The Four Pillars of OOP:");
        System.out.println("1. ENCAPSULATION - Hiding internal details");
        System.out.println("2. INHERITANCE - Acquiring properties from parent class");
        System.out.println("3. POLYMORPHISM - One entity, many forms");
        System.out.println("4. ABSTRACTION - Hiding complex implementation\n");
        
        System.out.println("🔹 Access Modifiers:");
        System.out.println("• public - Accessible everywhere");
        System.out.println("• private - Accessible only within the class");
        System.out.println("• protected - Accessible within package and subclasses");
        System.out.println("• default - Accessible within package only\n");
        
        System.out.println("🔹 Constructors:");
        System.out.println("Special methods that initialize objects when created.");
        System.out.println("Constructors have the same name as the class.\n");
        
        System.out.println("🔹 Example:");
        System.out.println("class Student {");
        System.out.println("    private String name;");
        System.out.println("    private int age;");
        System.out.println("    ");
        System.out.println("    public Student(String name, int age) {");
        System.out.println("        this.name = name;");
        System.out.println("        this.age = age;");
        System.out.println("    }");
        System.out.println("}\n");
        
        System.out.println("💡 Key Takeaways:");
        System.out.println("✓ OOP makes code more organized and reusable");
        System.out.println("✓ Classes are blueprints, objects are instances");
        System.out.println("✓ The four pillars are fundamental to OOP");
        System.out.println("✓ Access modifiers control data visibility");
    }
    
    private void displayConditionalsReview() {
        System.out.println("📚 JAVA CONDITIONALS\n");
        
        System.out.println("🔹 What are Conditionals?");
        System.out.println("Conditional statements allow programs to make decisions");
        System.out.println("and execute different code based on conditions.\n");
        
        System.out.println("🔹 Types of Conditional Statements:");
        System.out.println("1. if statement");
        System.out.println("2. if-else statement");
        System.out.println("3. if-else-if ladder");
        System.out.println("4. switch statement");
        System.out.println("5. ternary operator (?:)\n");
        
        System.out.println("🔹 Comparison Operators:");
        System.out.println("• == (equal to)");
        System.out.println("• != (not equal to)");
        System.out.println("• > (greater than)");
        System.out.println("• < (less than)");
        System.out.println("• >= (greater than or equal to)");
        System.out.println("• <= (less than or equal to)\n");
        
        System.out.println("🔹 Logical Operators:");
        System.out.println("• && (AND) - Both conditions must be true");
        System.out.println("• || (OR) - At least one condition must be true");
        System.out.println("• ! (NOT) - Inverts the condition\n");
        
        System.out.println("🔹 Examples:");
        System.out.println("// Simple if");
        System.out.println("if (age >= 18) {");
        System.out.println("    System.out.println(\"Adult\");");
        System.out.println("}\n");
        
        System.out.println("// if-else");
        System.out.println("if (score >= 60) {");
        System.out.println("    System.out.println(\"Passed\");");
        System.out.println("} else {");
        System.out.println("    System.out.println(\"Failed\");");
        System.out.println("}\n");
        
        System.out.println("// Ternary operator");
        System.out.println("String result = (score >= 60) ? \"Pass\" : \"Fail\";\n");
        
        System.out.println("💡 Key Takeaways:");
        System.out.println("✓ Use conditionals to control program flow");
        System.out.println("✓ Combine conditions with logical operators");
        System.out.println("✓ Switch is efficient for multiple specific values");
        System.out.println("✓ Ternary operator is shorthand for simple if-else");
    }
    
    private void displayLoopsReview() {
        System.out.println("📚 JAVA LOOPS\n");
        
        System.out.println("🔹 What are Loops?");
        System.out.println("Loops allow you to execute a block of code repeatedly");
        System.out.println("until a certain condition is met.\n");
        
        System.out.println("🔹 Types of Loops:");
        System.out.println("1. FOR LOOP - When you know iteration count");
        System.out.println("2. WHILE LOOP - When condition is checked first");
        System.out.println("3. DO-WHILE LOOP - Executes at least once");
        System.out.println("4. FOR-EACH LOOP - For iterating collections/arrays\n");
        
        System.out.println("🔹 Loop Control Statements:");
        System.out.println("• break - Exits the loop immediately");
        System.out.println("• continue - Skips current iteration");
        System.out.println("• return - Exits the method\n");
        
        System.out.println("🔹 Examples:");
        System.out.println("// For loop");
        System.out.println("for (int i = 0; i < 5; i++) {");
        System.out.println("    System.out.println(i);");
        System.out.println("}\n");
        
        System.out.println("// While loop");
        System.out.println("int i = 0;");
        System.out.println("while (i < 5) {");
        System.out.println("    System.out.println(i);");
        System.out.println("    i++;");
        System.out.println("}\n");
        
        System.out.println("// Do-while loop");
        System.out.println("int i = 0;");
        System.out.println("do {");
        System.out.println("    System.out.println(i);");
        System.out.println("    i++;");
        System.out.println("} while (i < 5);\n");
        
        System.out.println("// For-each loop");
        System.out.println("int[] numbers = {1, 2, 3, 4, 5};");
        System.out.println("for (int num : numbers) {");
        System.out.println("    System.out.println(num);");
        System.out.println("}\n");
        
        System.out.println("💡 Key Takeaways:");
        System.out.println("✓ Choose the right loop for your needs");
        System.out.println("✓ Do-while always executes at least once");
        System.out.println("✓ For-each is best for arrays and collections");
        System.out.println("✓ Use break and continue for flow control");
        System.out.println("✓ Avoid infinite loops by ensuring condition changes");
    }
    
    private void displayArraysReview() {
        System.out.println("📚 JAVA ARRAYS\n");
        
        System.out.println("🔹 What are Arrays?");
        System.out.println("Arrays are containers that hold fixed number of values");
        System.out.println("of the same data type.\n");
        
        System.out.println("🔹 Key Characteristics:");
        System.out.println("• Fixed size (cannot be changed after creation)");
        System.out.println("• Zero-indexed (first element at index 0)");
        System.out.println("• Stores elements of same type");
        System.out.println("• Stored in contiguous memory locations\n");
        
        System.out.println("🔹 Declaration and Initialization:");
        System.out.println("// Declaration");
        System.out.println("int[] numbers;");
        System.out.println("String[] names;\n");
        
        System.out.println("// Creating array");
        System.out.println("numbers = new int[5];\n");
        
        System.out.println("// Declaration with initialization");
        System.out.println("int[] scores = {90, 85, 78, 92, 88};");
        System.out.println("String[] fruits = {\"Apple\", \"Banana\", \"Orange\"};\n");
        
        System.out.println("🔹 Accessing Elements:");
        System.out.println("int firstScore = scores[0]; // Gets first element");
        System.out.println("scores[1] = 95; // Sets second element\n");
        
        System.out.println("🔹 Array Length:");
        System.out.println("int size = scores.length; // Gets array length\n");
        
        System.out.println("🔹 Multi-dimensional Arrays:");
        System.out.println("// 2D array");
        System.out.println("int[][] matrix = new int[3][4];");
        System.out.println("int[][] grid = {");
        System.out.println("    {1, 2, 3},");
        System.out.println("    {4, 5, 6},");
        System.out.println("    {7, 8, 9}");
        System.out.println("};\n");
        
        System.out.println("🔹 Common Operations:");
        System.out.println("// Traversing array");
        System.out.println("for (int i = 0; i < array.length; i++) {");
        System.out.println("    System.out.println(array[i]);");
        System.out.println("}\n");
        
        System.out.println("// Using for-each");
        System.out.println("for (int element : array) {");
        System.out.println("    System.out.println(element);");
        System.out.println("}\n");
        
        System.out.println("💡 Key Takeaways:");
        System.out.println("✓ Arrays have fixed size");
        System.out.println("✓ Index starts at 0");
        System.out.println("✓ Use array.length to get size");
        System.out.println("✓ ArrayIndexOutOfBoundsException for invalid index");
        System.out.println("✓ Multi-dimensional arrays create matrices");
    }
    
    private void displayEncapsulationReview() {
        System.out.println("📚 ENCAPSULATION\n");
        
        System.out.println("🔹 What is Encapsulation?");
        System.out.println("Encapsulation is wrapping data (variables) and code (methods)");
        System.out.println("together as a single unit, and restricting direct access to");
        System.out.println("some components.\n");
        
        System.out.println("🔹 Key Principles:");
        System.out.println("• Data Hiding - Making fields private");
        System.out.println("• Controlled Access - Using getters and setters");
        System.out.println("• Better Security - Protecting data integrity");
        System.out.println("• Flexibility - Easy to change implementation\n");
        
        System.out.println("🔹 Benefits:");
        System.out.println("1. Improved security");
        System.out.println("2. Better data integrity");
        System.out.println("3. Easier maintenance");
        System.out.println("4. Flexibility in implementation");
        System.out.println("5. Reduced complexity\n");
        
        System.out.println("🔹 Example:");
        System.out.println("public class BankAccount {");
        System.out.println("    // Private fields");
        System.out.println("    private String accountNumber;");
        System.out.println("    private double balance;");
        System.out.println("    ");
        System.out.println("    // Constructor");
        System.out.println("    public BankAccount(String accountNumber) {");
        System.out.println("        this.accountNumber = accountNumber;");
        System.out.println("        this.balance = 0.0;");
        System.out.println("    }");
        System.out.println("    ");
        System.out.println("    // Getter");
        System.out.println("    public double getBalance() {");
        System.out.println("        return balance;");
        System.out.println("    }");
        System.out.println("    ");
        System.out.println("    // Setter with validation");
        System.out.println("    public void deposit(double amount) {");
        System.out.println("        if (amount > 0) {");
        System.out.println("            balance += amount;");
        System.out.println("        }");
        System.out.println("    }");
        System.out.println("}\n");
        
        System.out.println("🔹 Naming Conventions:");
        System.out.println("• Getters: getName(), getAge(), isActive()");
        System.out.println("• Setters: setName(), setAge(), setActive()");
        System.out.println("• Boolean getters often start with 'is'\n");
        
        System.out.println("💡 Key Takeaways:");
        System.out.println("✓ Always make fields private");
        System.out.println("✓ Provide public getters/setters for controlled access");
        System.out.println("✓ Add validation in setters");
        System.out.println("✓ Encapsulation improves code maintainability");
        System.out.println("✓ Follow JavaBean conventions");
    }
   
    private void displayInheritanceReview() {
        System.out.println("📚 INHERITANCE\n");
        
        System.out.println("🔹 What is Inheritance?");
        System.out.println("Inheritance is a mechanism where a new class (subclass) acquires");
        System.out.println("properties and behaviors from an existing class (superclass).\n");
        
        System.out.println("🔹 Key Terms:");
        System.out.println("• SUPERCLASS (Parent) - Class being inherited from");
        System.out.println("• SUBCLASS (Child) - Class that inherits");
        System.out.println("• extends - Keyword for inheritance");
        System.out.println("• super - Refers to parent class\n");
        
        System.out.println("🔹 Types of Inheritance:");
        System.out.println("1. Single Inheritance - One parent, one child");
        System.out.println("2. Multilevel Inheritance - Chain of inheritance");
        System.out.println("3. Hierarchical Inheritance - One parent, multiple children");
        System.out.println("Note: Java doesn't support multiple inheritance with classes\n");
        
        System.out.println("🔹 Example:");
        System.out.println("// Superclass");
        System.out.println("public class Animal {");
        System.out.println("    protected String name;");
        System.out.println("    ");
        System.out.println("    public void eat() {");
        System.out.println("        System.out.println(\"Eating...\");");
        System.out.println("    }");
        System.out.println("}\n");
        
        System.out.println("// Subclass");
        System.out.println("public class Dog extends Animal {");
        System.out.println("    public void bark() {");
        System.out.println("        System.out.println(\"Woof!\");");
        System.out.println("    }");
        System.out.println("}\n");
        
        System.out.println("🔹 Using super Keyword:");
        System.out.println("public class Student extends Person {");
        System.out.println("    public Student(String name) {");
        System.out.println("        super(name); // Call parent constructor");
        System.out.println("    }");
        System.out.println("    ");
        System.out.println("    @Override");
        System.out.println("    public void display() {");
        System.out.println("        super.display(); // Call parent method");
        System.out.println("    }");
        System.out.println("}\n");
        
        System.out.println("🔹 Method Overriding:");
        System.out.println("Subclass provides specific implementation of parent method.");
        System.out.println("Use @Override annotation for clarity.\n");
        
        System.out.println("🔹 Access in Inheritance:");
        System.out.println("• private - NOT inherited");
        System.out.println("• protected - Inherited and accessible");
        System.out.println("• public - Inherited and accessible\n");
        
        System.out.println("💡 Key Takeaways:");
        System.out.println("✓ Inheritance promotes code reuse");
        System.out.println("✓ Use 'extends' keyword");
        System.out.println("✓ super() calls parent constructor");
        System.out.println("✓ Subclass inherits non-private members");
        System.out.println("✓ Java has single inheritance for classes");
    }
    
    private void displayPolymorphismReview() {
        System.out.println("📚 POLYMORPHISM\n");
        
        System.out.println("🔹 What is Polymorphism?");
        System.out.println("Polymorphism means 'many forms' - ability of objects to take");
        System.out.println("many forms. One interface, multiple implementations.\n");
        
        System.out.println("🔹 Types of Polymorphism:");
        System.out.println("1. COMPILE-TIME (Static) - Method Overloading");
        System.out.println("2. RUN-TIME (Dynamic) - Method Overriding\n");
        
        System.out.println("🔹 Method Overloading (Compile-time):");
        System.out.println("Same method name, different parameters.");
        System.out.println();
        System.out.println("public class Calculator {");
        System.out.println("    public int add(int a, int b) {");
        System.out.println("        return a + b;");
        System.out.println("    }");
        System.out.println("    ");
        System.out.println("    public double add(double a, double b) {");
        System.out.println("        return a + b;");
        System.out.println("    }");
        System.out.println("    ");
        System.out.println("    public int add(int a, int b, int c) {");
        System.out.println("        return a + b + c;");
        System.out.println("    }");
        System.out.println("}\n");
        
        System.out.println("🔹 Method Overriding (Run-time):");
        System.out.println("Subclass provides specific implementation of parent method.");
        System.out.println();
        System.out.println("class Animal {");
        System.out.println("    public void makeSound() {");
        System.out.println("        System.out.println(\"Animal sound\");");
        System.out.println("    }");
        System.out.println("}");
        System.out.println();
        System.out.println("class Dog extends Animal {");
        System.out.println("    @Override");
        System.out.println("    public void makeSound() {");
        System.out.println("        System.out.println(\"Woof!\");");
        System.out.println("    }");
        System.out.println("}\n");
        
        System.out.println("🔹 Dynamic Method Dispatch:");
        System.out.println("Animal animal = new Dog();");
        System.out.println("animal.makeSound(); // Outputs: Woof!");
        System.out.println("// Method resolved at runtime\n");
        
        System.out.println("🔹 Rules for Overloading:");
        System.out.println("• Different parameter list (number or type)");
        System.out.println("• Can have different return types");
        System.out.println("• Can have different access modifiers\n");
        
        System.out.println("🔹 Rules for Overriding:");
        System.out.println("• Same method signature");
        System.out.println("• Same or covariant return type");
        System.out.println("• Cannot reduce access level");
        System.out.println("• Use @Override annotation\n");
        
        System.out.println("🔹 Benefits:");
        System.out.println("• Code flexibility and reusability");
        System.out.println("• Clean and maintainable code");
        System.out.println("• Easy to extend functionality");
        System.out.println("• Loose coupling\n");
        
        System.out.println("💡 Key Takeaways:");
        System.out.println("✓ Overloading = same name, different parameters");
        System.out.println("✓ Overriding = redefining parent method in child");
        System.out.println("✓ Overloading is compile-time polymorphism");
        System.out.println("✓ Overriding is run-time polymorphism");
        System.out.println("✓ Polymorphism enables flexible code design");
    }
}
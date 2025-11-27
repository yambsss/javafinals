import java.util.ArrayList;
import java.util.List;
import model.Question;

public class QuestionGenerator {
    

    public List<Question> generateQuestions(String topic) {
        List<Question> questions = new ArrayList<>();
        
        switch (topic.toLowerCase()) {
            case "introduction":
                questions = generateIntroductionQuestions();
                break;
            case "conditionals":
                questions = generateConditionalsQuestions();
                break;
            case "loops":
                questions = generateLoopsQuestions();
                break;
            case "arrays":
                questions = generateArraysQuestions();
                break;
            case "encapsulation":
                questions = generateEncapsulationQuestions();
                break;
            case "inheritance":
                questions = generateInheritanceQuestions();
                break;
            case "polymorphism":
                questions = generatePolymorphismQuestions();
                break;
            default:
                System.out.println("Topic not found!");
        }
        
        return questions;
    }

    //generates ng questions sa introduction to OOP
    private List<Question> generateIntroductionQuestions() {
        List<Question> questions = new ArrayList<>();
        
        questions.add(new Question(
            "What does OOP stand for?",
            new String[]{"Object-Oriented Programming", "Only One Program", 
                        "Optimal Object Processing", "Open Operating Platform"},
            0,
            "Introduction",
            "OOP stands for Object-Oriented Programming, a programming paradigm based on objects."
        ));
        
        questions.add(new Question(
            "Which of the following is NOT a pillar of OOP?",
            new String[]{"Encapsulation", "Inheritance", "Compilation", "Polymorphism"},
            2,
            "Introduction",
            "The four pillars of OOP are Encapsulation, Inheritance, Polymorphism, and Abstraction."
        ));
        
        questions.add(new Question(
            "What is a class in Java?",
            new String[]{"A function", "A blueprint for objects", "A variable", "A loop"},
            1,
            "Introduction",
            "A class is a blueprint or template for creating objects."
        ));
        
        questions.add(new Question(
            "What is an object in OOP?",
            new String[]{"A data type", "An instance of a class", "A method", "A variable"},
            1,
            "Introduction",
            "An object is an instance of a class that contains data and methods."
        ));
        
        questions.add(new Question(
            "Which keyword is used to create a new object in Java?",
            new String[]{"create", "new", "object", "make"},
            1,
            "Introduction",
            "The 'new' keyword is used to create an instance of a class."
        ));
        
        questions.add(new Question(
            "What is a constructor?",
            new String[]{"A method that destroys objects", "A special method to initialize objects",
                        "A type of variable", "A loop structure"},
            1,
            "Introduction",
            "A constructor is a special method that initializes objects when they are created."
        ));
        
        questions.add(new Question(
            "What is the default access modifier in Java?",
            new String[]{"public", "private", "protected", "package-private (default)"},
            3,
            "Introduction",
            "If no access modifier is specified, it defaults to package-private."
        ));
        
        questions.add(new Question(
            "Which of these is a valid way to declare a class in Java?",
            new String[]{"class MyClass {}", "MyClass class {}", "define MyClass {}", "object MyClass {}"},
            0,
            "Introduction",
            "The correct syntax is 'class ClassName { }'."
        ));
        
        questions.add(new Question(
            "What is the main purpose of OOP?",
            new String[]{"To make code faster", "To organize code using objects and classes",
                        "To reduce file size", "To eliminate all bugs"},
            1,
            "Introduction",
            "OOP helps organize code into reusable, maintainable objects and classes."
        ));
        
        questions.add(new Question(
            "Can a Java file contain multiple classes?",
            new String[]{"Yes, but only one can be public", "No, never", 
                        "Yes, all must be public", "Only if they're abstract"},
            0,
            "Introduction",
            "A Java file can contain multiple classes, but only one can be public and match the filename."
        ));
        
        return questions;
    }
    
    /**
     * Generates Java Conditionals questions
     */
    private List<Question> generateConditionalsQuestions() {
        List<Question> questions = new ArrayList<>();
        
        questions.add(new Question(
            "Which is the correct syntax for an if statement?",
            new String[]{"if x == 5 then", "if (x == 5)", "if x = 5", "if [x == 5]"},
            1,
            "Conditionals",
            "The correct syntax is 'if (condition)' with parentheses."
        ));
        
        questions.add(new Question(
            "What does the '==' operator do?",
            new String[]{"Assigns a value", "Compares two values", "Adds two numbers", "Declares a variable"},
            1,
            "Conditionals",
            "The '==' operator compares two values for equality."
        ));
        
        questions.add(new Question(
            "Which statement is used for multiple conditions?",
            new String[]{"if-else", "switch", "for", "while"},
            1,
            "Conditionals",
            "The switch statement is ideal for handling multiple specific conditions."
        ));
        
        questions.add(new Question(
            "What is the output of: if(5 > 3) System.out.print('Yes');",
            new String[]{"Yes", "No", "Error", "Nothing"},
            0,
            "Conditionals",
            "Since 5 > 3 is true, 'Yes' will be printed."
        ));
        
        questions.add(new Question(
            "Which operator means 'NOT equal to'?",
            new String[]{"!==", "!=", "<>", "=/="},
            1,
            "Conditionals",
            "The != operator checks if two values are not equal."
        ));
        
        questions.add(new Question(
            "What does the '&&' operator mean?",
            new String[]{"OR", "AND", "NOT", "XOR"},
            1,
            "Conditionals",
            "The && operator is the logical AND operator."
        ));
        
        questions.add(new Question(
            "What is the purpose of the 'else' clause?",
            new String[]{"To end the program", "To handle false condition", 
                        "To loop", "To declare variables"},
            1,
            "Conditionals",
            "The 'else' clause executes when the if condition is false."
        ));
        
        questions.add(new Question(
            "Can you have an 'else' without an 'if'?",
            new String[]{"Yes", "No", "Sometimes", "Only in loops"},
            1,
            "Conditionals",
            "An 'else' must always be paired with an 'if' statement."
        ));
        
        questions.add(new Question(
            "What is a ternary operator?",
            new String[]{"A loop", "A short form of if-else", "A variable", "A class"},
            1,
            "Conditionals",
            "The ternary operator (condition ? true : false) is a shorthand for if-else."
        ));
        
        questions.add(new Question(
            "Which is correct for checking if x is between 1 and 10?",
            new String[]{"if (x > 1 && x < 10)", "if (1 < x < 10)", 
                        "if (x in 1..10)", "if (x between 1 and 10)"},
            0,
            "Conditionals",
            "You need to use logical AND (&&) to check both conditions."
        ));
        
        return questions;
    }
    
    /**
     * Generates Java Loops questions
     */
    private List<Question> generateLoopsQuestions() {
        List<Question> questions = new ArrayList<>();
        
        questions.add(new Question(
            "Which loop executes at least once?",
            new String[]{"for loop", "while loop", "do-while loop", "foreach loop"},
            2,
            "Loops",
            "A do-while loop executes the body at least once before checking the condition."
        ));
        
        questions.add(new Question(
            "What is the correct syntax for a for loop?",
            new String[]{"for (int i = 0; i < 10; i++)", "for int i = 0 to 10", 
                        "for (i < 10)", "for [i = 0; i < 10]"},
            0,
            "Loops",
            "The syntax is: for (initialization; condition; update)"
        ));
        
        questions.add(new Question(
            "What does 'break' do in a loop?",
            new String[]{"Pauses the loop", "Exits the loop", "Skips one iteration", "Restarts the loop"},
            1,
            "Loops",
            "The 'break' statement immediately exits the loop."
        ));
        
        questions.add(new Question(
            "What does 'continue' do in a loop?",
            new String[]{"Exits the loop", "Skips to next iteration", 
                        "Restarts from beginning", "Pauses execution"},
            1,
            "Loops",
            "The 'continue' statement skips the rest of the current iteration."
        ));
        
        questions.add(new Question(
            "Which loop is best for iterating through arrays?",
            new String[]{"while", "do-while", "for-each", "nested"},
            2,
            "Loops",
            "The for-each loop (enhanced for loop) is ideal for iterating arrays."
        ));
        
        questions.add(new Question(
            "What is an infinite loop?",
            new String[]{"A loop that never starts", "A loop that never ends", 
                        "A loop with no body", "A loop that runs once"},
            1,
            "Loops",
            "An infinite loop has no terminating condition and runs forever."
        ));
        
        questions.add(new Question(
            "How many times does this run? for(int i=0; i<5; i++)",
            new String[]{"4 times", "5 times", "6 times", "Infinite"},
            1,
            "Loops",
            "It runs 5 times: i=0,1,2,3,4 (stops when i=5)."
        ));
        
        questions.add(new Question(
            "What is a nested loop?",
            new String[]{"A loop inside another loop", "A broken loop", 
                        "A loop with two conditions", "A loop without a body"},
            0,
            "Loops",
            "A nested loop is a loop placed inside another loop."
        ));
        
        questions.add(new Question(
            "Which is NOT a type of loop in Java?",
            new String[]{"for", "while", "repeat-until", "do-while"},
            2,
            "Loops",
            "Java has for, while, and do-while loops, but not repeat-until."
        ));
        
        questions.add(new Question(
            "What happens if a while loop condition is false initially?",
            new String[]{"Error occurs", "Loop runs once", "Loop doesn't run", "Infinite loop"},
            2,
            "Loops",
            "If the condition is false from the start, the while loop body never executes."
        ));
        
        return questions;
    }
    
    /**
     * Generates Java Arrays questions
     */
    private List<Question> generateArraysQuestions() {
        List<Question> questions = new ArrayList<>();
        
        questions.add(new Question(
            "How do you declare an integer array in Java?",
            new String[]{"int array[]", "int[] array", "Both are correct", "array int[]"},
            2,
            "Arrays",
            "Both 'int[] array' and 'int array[]' are valid declarations."
        ));
        
        questions.add(new Question(
            "What is the index of the first element in an array?",
            new String[]{"1", "0", "-1", "Depends on declaration"},
            1,
            "Arrays",
            "Array indices start at 0 in Java."
        ));
        
        questions.add(new Question(
            "How do you find the length of an array?",
            new String[]{"array.length()", "array.size()", "array.length", "array.count"},
            2,
            "Arrays",
            "Use array.length (property, not a method)."
        ));
        
        questions.add(new Question(
            "What happens if you access an invalid array index?",
            new String[]{"Returns 0", "Returns null", "ArrayIndexOutOfBoundsException", "Compilation error"},
            2,
            "Arrays",
            "Accessing an invalid index throws ArrayIndexOutOfBoundsException."
        ));
        
        questions.add(new Question(
            "How do you initialize an array with values?",
            new String[]{"int[] arr = {1,2,3}", "int[] arr = new int{1,2,3}", 
                        "int[] arr = [1,2,3]", "int[] arr = (1,2,3)"},
            0,
            "Arrays",
            "Use curly braces: int[] arr = {1,2,3};"
        ));
        
        questions.add(new Question(
            "Can arrays hold different data types?",
            new String[]{"Yes, always", "No, must be same type", "Only with Object type", "Only primitives"},
            1,
            "Arrays",
            "Arrays must contain elements of the same data type."
        ));
        
        questions.add(new Question(
            "What is a 2D array?",
            new String[]{"An array with two elements", "An array of arrays", 
                        "A circular array", "An array with two data types"},
            1,
            "Arrays",
            "A 2D array is an array of arrays, creating a matrix structure."
        ));
        
        questions.add(new Question(
            "How do you create an array of size 10?",
            new String[]{"int[] arr = new int[10]", "int[] arr = int[10]", 
                        "int[10] arr", "arr = new[10]"},
            0,
            "Arrays",
            "Use: int[] arr = new int[size];"
        ));
        
        questions.add(new Question(
            "Can you change the size of an array after creation?",
            new String[]{"Yes, using resize()", "Yes, using add()", "No, size is fixed", "Only if empty"},
            2,
            "Arrays",
            "Array size is fixed after creation; use ArrayList for dynamic sizing."
        ));
        
        questions.add(new Question(
            "What is the default value of int array elements?",
            new String[]{"null", "0", "1", "undefined"},
            1,
            "Arrays",
            "Numeric arrays are initialized with 0 by default."
        ));
        
        return questions;
    }
    
    /**
     * Generates Encapsulation questions
     */
    private List<Question> generateEncapsulationQuestions() {
        List<Question> questions = new ArrayList<>();
        
        questions.add(new Question(
            "What is encapsulation?",
            new String[]{"Hiding implementation details", "Creating objects", 
                        "Inheriting properties", "Overriding methods"},
            0,
            "Encapsulation",
            "Encapsulation is hiding internal details and providing controlled access."
        ));
        
        questions.add(new Question(
            "Which access modifier provides the most restricted access?",
            new String[]{"public", "protected", "private", "default"},
            2,
            "Encapsulation",
            "Private members are accessible only within the same class."
        ));
        
        questions.add(new Question(
            "What are getter and setter methods?",
            new String[]{"Methods to get and set private variables", "Constructors", 
                        "Static methods", "Abstract methods"},
            0,
            "Encapsulation",
            "Getters and setters provide controlled access to private fields."
        ));
        
        questions.add(new Question(
            "Why should fields be private?",
            new String[]{"For faster execution", "To hide implementation details", 
                        "To save memory", "To allow inheritance"},
            1,
            "Encapsulation",
            "Private fields protect data and maintain encapsulation."
        ));
        
        questions.add(new Question(
            "What is data hiding?",
            new String[]{"Deleting data", "Making data private", "Encrypting data", "Compressing data"},
            1,
            "Encapsulation",
            "Data hiding means restricting direct access to data members."
        ));
        
        questions.add(new Question(
            "Which keyword is used for encapsulation?",
            new String[]{"public", "private", "static", "final"},
            1,
            "Encapsulation",
            "The 'private' keyword is primarily used for encapsulation."
        ));
        
        questions.add(new Question(
            "Can private members be accessed outside the class?",
            new String[]{"Yes, always", "No, never", "Only through public methods", "Only in subclasses"},
            2,
            "Encapsulation",
            "Private members can only be accessed through public methods (getters/setters)."
        ));
        
        questions.add(new Question(
            "What is the benefit of encapsulation?",
            new String[]{"Faster code", "Better data security and flexibility", 
                        "Less memory usage", "Automatic error handling"},
            1,
            "Encapsulation",
            "Encapsulation provides data security, flexibility, and maintainability."
        ));
        
        questions.add(new Question(
            "What is a JavaBean?",
            new String[]{"A coffee library", "A class with private fields and public getters/setters",
                        "An abstract class", "A database connector"},
            1,
            "Encapsulation",
            "A JavaBean follows encapsulation principles with private fields and public accessors."
        ));
        
        questions.add(new Question(
            "Which represents proper encapsulation?",
            new String[]{"public int age;", "private int age; with public getAge()", 
                        "protected int age;", "int age;"},
            1,
            "Encapsulation",
            "Private field with public getter/setter methods demonstrates proper encapsulation."
        ));
        
        return questions;
    }
    
    /**
     * Generates Inheritance questions
     */
    private List<Question> generateInheritanceQuestions() {
        List<Question> questions = new ArrayList<>();
        
        questions.add(new Question(
            "What is inheritance?",
            new String[]{"Creating new objects", "A class acquiring properties from another class",
                        "Hiding data", "Overloading methods"},
            1,
            "Inheritance",
            "Inheritance allows a class to inherit properties and methods from another class."
        ));
        
        questions.add(new Question(
            "Which keyword is used for inheritance?",
            new String[]{"implements", "extends", "inherits", "inherit"},
            1,
            "Inheritance",
            "The 'extends' keyword is used to inherit from a class."
        ));
        
        questions.add(new Question(
            "What is a superclass?",
            new String[]{"A very powerful class", "The parent class", 
                        "The child class", "An abstract class"},
            1,
            "Inheritance",
            "A superclass is the parent class from which other classes inherit."
        ));
        
        questions.add(new Question(
            "What is a subclass?",
            new String[]{"The parent class", "The child class that inherits", 
                        "An interface", "A package"},
            1,
            "Inheritance",
            "A subclass is the child class that inherits from a superclass."
        ));
        
        questions.add(new Question(
            "Does Java support multiple inheritance with classes?",
            new String[]{"Yes", "No", "Only with interfaces", "Sometimes"},
            1,
            "Inheritance",
            "Java doesn't support multiple class inheritance to avoid complexity."
        ));
        
        questions.add(new Question(
            "What keyword is used to call parent class constructor?",
            new String[]{"this", "super", "parent", "base"},
            1,
            "Inheritance",
            "The 'super' keyword calls the parent class constructor."
        ));
        
        questions.add(new Question(
            "Can a subclass access private members of superclass?",
            new String[]{"Yes, always", "No, never", "Only with super keyword", "Only if protected"},
            1,
            "Inheritance",
            "Private members are not accessible in subclasses."
        ));
        
        questions.add(new Question(
            "What is method overriding?",
            new String[]{"Creating multiple methods", "Redefining superclass method in subclass",
                        "Deleting a method", "Hiding a method"},
            1,
            "Inheritance",
            "Method overriding is redefining a parent class method in the child class."
        ));
        
        questions.add(new Question(
            "Which access modifier allows inheritance access?",
            new String[]{"private", "protected", "public", "Both protected and public"},
            3,
            "Inheritance",
            "Both protected and public members are accessible in subclasses."
        ));
        
        questions.add(new Question(
            "What is the Object class in Java?",
            new String[]{"A regular class", "The root of class hierarchy", 
                        "An interface", "A package"},
            1,
            "Inheritance",
            "Object is the root superclass from which all classes inherit."
        ));
        
        return questions;
    }
    
    /**
     * Generates Polymorphism questions
     */
    private List<Question> generatePolymorphismQuestions() {
        List<Question> questions = new ArrayList<>();
        
        questions.add(new Question(
            "What is polymorphism?",
            new String[]{"Many forms of a single entity", "Creating objects", 
                        "Hiding data", "Breaking code"},
            0,
            "Polymorphism",
            "Polymorphism means one entity can take many forms."
        ));
        
        questions.add(new Question(
            "What are the types of polymorphism?",
            new String[]{"Compile-time and run-time", "Static and final", 
                        "Public and private", "Abstract and concrete"},
            0,
            "Polymorphism",
            "Polymorphism has two types: compile-time (overloading) and run-time (overriding)."
        ));
        
        questions.add(new Question(
            "What is method overloading?",
            new String[]{"Same method name, different parameters", "Same method name and parameters",
                        "Different method names", "Deleting methods"},
            0,
            "Polymorphism",
            "Method overloading uses same name with different parameters."
        ));
        
        questions.add(new Question(
            "What is method overriding?",
            new String[]{"Creating new method", "Subclass redefines superclass method",
                        "Deleting method", "Making method private"},
            1,
            "Polymorphism",
            "Method overriding is when a subclass provides its own implementation."
        ));
        
        questions.add(new Question(
            "Which is an example of compile-time polymorphism?",
            new String[]{"Method overriding", "Method overloading", "Inheritance", "Encapsulation"},
            1,
            "Polymorphism",
            "Method overloading is resolved at compile-time."
        ));
        
        questions.add(new Question(
            "Which is an example of run-time polymorphism?",
            new String[]{"Method overloading", "Method overriding", "Constructor", "Static method"},
            1,
            "Polymorphism",
            "Method overriding is resolved at run-time (dynamic binding)."
        ));
        
        questions.add(new Question(
            "Can you overload the main method?",
            new String[]{"Yes", "No", "Only in subclass", "Only if static"},
            0,
            "Polymorphism",
            "Yes, you can overload main(), but JVM calls the standard signature."
        ));
        
        questions.add(new Question(
            "What is dynamic method dispatch?",
            new String[]{"Static binding", "Run-time method resolution", 
                        "Compile-time checking", "Method deletion"},
            1,
            "Polymorphism",
            "Dynamic method dispatch is run-time determination of which method to call."
        ));
        
        questions.add(new Question(
            "Can static methods be overridden?",
            new String[]{"Yes", "No, only hidden", "Sometimes", "Only in interfaces"},
            1,
            "Polymorphism",
            "Static methods can be hidden but not overridden."
        ));
        
        questions.add(new Question(
            "What is the benefit of polymorphism?",
            new String[]{"Faster code", "Code flexibility and reusability", 
                        "Less memory", "Automatic debugging"},
            1,
            "Polymorphism",
            "Polymorphism provides flexibility, allowing objects to be used interchangeably."
        ));
        
        return questions;
    }
}
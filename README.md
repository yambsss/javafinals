# RecensorSystem - OOP Quiz and Review Application

## 1. Project Title

**RecensorSystem: Interactive Object-Oriented Programming Learning Platform**

---

## 2. Description/Overview

Learning Object-Oriented Programming can be challenging, especially when trying to understand concepts like encapsulation, inheritance, and polymorphism. We created RecensorSystem to help students practice, learn, and track their progress in mastering OOP fundamentals.

RecensorSystem works like a personal OOP tutor. When you open the program, you create your own account using a 5-digit PIN code. Once logged in, you can access Quiz Mode to test your knowledge with 10 questions per topic, or Review Mode to study detailed explanations and examples. You need to score at least 8 out of 10 to pass each topic.

**Main Features:**
- Personal user accounts with PIN authentication
- 70 quiz questions covering 7 OOP topics
- Instant feedback with explanations
- Progress tracking showing your quiz history and best scores
- Comprehensive review materials
- Your progress is saved so you can continue anytime

This program solves three main problems we experienced as students: lack of immediate feedback when learning, scattered study resources, and no way to track which topics we've mastered and which need more work.

---

## 3. OOP Concepts Applied

### Encapsulation

We made class fields private and provided controlled access through public methods. In `UserAccount`, sensitive data like PIN codes are private and can only be accessed through methods like `verifyPin()` and `getUsername()`. This protects our data from being changed incorrectly.

**Example in UserAccount.java:**
```java
private String pinCode;
private String username;

public boolean verifyPin(String enteredPin) {
    return this.pinCode.equals(enteredPin);
}
```

### Inheritance

Our exception handling uses inheritance. Custom exception classes extend Java's Exception class, inheriting its basic functionality while adding specific error messages for our program.

**Example:**
```java
public class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}
```

### Polymorphism

The `Question` class has multiple constructors with different parameters (method overloading). We also override the `toString()` method in `SessionRecord` to display quiz results in our own format.

**Example in Question.java:**
```java
public Question(String questionText, String[] options, 
               int correctAnswer, String topic, String explanation) {
    // ...
}

public Question(String questionText, String[] options, 
               int correctAnswer, String topic) {
    this(questionText, options, correctAnswer, topic, "");
}
```

### Abstraction

Complex operations are hidden behind simple methods. The `UserManager` class handles complicated file operations, PIN validation, and data saving, but `Main.java` only needs to call `authenticate()` without knowing how it works internally.

### Exception Handling

We use try-catch blocks throughout the program to handle errors gracefully. When users enter invalid quiz answers or PINs, the program catches the error and asks them to try again instead of crashing.

**Example in Main.java:**
```java
try {
    int answer = getUserAnswer();
    // process answer
} catch (Exception e) {
    System.out.println(" " + e.getMessage());
}
```

---

## 4. Program Structure

Our program has 7 Java classes organized in two packages:

### Model Package (src/model/)
- **Question.java** - Stores question text, options, correct answer, and explanation
- **SessionRecord.java** - Records quiz results with score, date, and pass/fail status
- **UserAccount.java** - Stores user data, PIN, quiz history, and calculates statistics

### Main Package (src/)
- **Main.java** - Program entry point with main menu
- **UserManager.java** - Handles login, account creation, and saving data to files
- **QuestionGenerator.java** - Contains all 70 quiz questions organized by topic
- **ReviewerPdfWriter.java** - Displays study materials for each topic

### Class Relationships

```
Main.java
  ├─ Uses UserManager (authentication)
  ├─ Uses QuestionGenerator (creates quizzes)
  └─ Uses ReviewerPdfWriter (study materials)

UserAccount.java
  └─ Contains List<SessionRecord> (quiz history)

UserManager.java
  └─ Manages Map<String, UserAccount> (all users)
```

---

## 5. How to Run the Program

### Prerequisites
- Java JDK 8 or higher
- Command line terminal or VS Code with Java extension

### Windows Command Prompt

```bash
# Navigate to project folder
cd C:\path\to\JAVAFINALS

# Create bin folder
mkdir bin

# Compile all files
javac -d bin src\model\*.java src\*.java

# Run the program
java -cp bin Main
```

### Mac/Linux Terminal

```bash
# Navigate to project folder
cd /path/to/JAVAFINALS

# Create bin folder
mkdir -p bin

# Compile all files
javac -d bin src/model/*.java src/*.java

# Run the program
java -cp bin Main
```

### VS Code (Easiest Method)

1. Open JAVAFINALS folder in VS Code
2. Right-click on `Main.java`
3. Select "Run Java"

---

## 6. Sample Output

### Welcome Screen
```
╔════════════════════════════════════════════════════════╗
║     WELCOME TO RECENSOR SYSTEM - OOP REVIEWER         ║
║        Master Object-Oriented Programming!            ║
╚════════════════════════════════════════════════════════╝

┌────────────────────────────────────────────────────────┐
│                   USER AUTHENTICATION                  │
├────────────────────────────────────────────────────────┤
│  [1] Login with existing PIN                          │
│  [2] Create new account                               │
│  [3] Exit                                             │
└────────────────────────────────────────────────────────┘

Enter your choice: 2
```

### Creating Account
```
════════════════════════════════════════════════════════
                  CREATE NEW ACCOUNT
════════════════════════════════════════════════════════

Enter your name: Maria Santos

Create a 5-digit PIN code: 12345
Confirm your PIN code: 12345

 Account created successfully! 
Your username: Maria Santos
Your PIN: 12345

  IMPORTANT: Please remember your PIN for future logins!
```

### Main Menu
```
╔════════════════════════════════════════════════════════╗
║              Welcome, Maria Santos!                   ║
╚════════════════════════════════════════════════════════╝

┌────────────────────────────────────────────────────────┐
│                    MAIN MENU                           │
├────────────────────────────────────────────────────────┤
│  [1] Quiz Mode - Test your knowledge                  │
│  [2] Review Mode - Study OOP concepts                 │
│  [3] View Progress - Check your scores                │
│  [4] Logout                                           │
└────────────────────────────────────────────────────────┘

 Quick Stats:
   Total Quizzes Taken: 2
   Average Score: 85.0%
   Topics Mastered: 2/7

Enter your choice: 1
```

### Quiz Mode
```
 Question 1/10

What does OOP stand for?
──────────────────────────────────────────────────
  [1] Object-Oriented Programming
  [2] Only One Program
  [3] Optimal Object Processing
  [4] Open Operating Platform

Your answer (1-4): 1
 YEHEYYYYY TAMA 
```

### Quiz Results
```
════════════════════════════════════════════════════════
                    QUIZ RESULTS
════════════════════════════════════════════════════════
Topic: Introduction to OOP
Score: 9/10
Percentage: 90.0%
Status:  PASSED! 

Congratulations! You can proceed to the next topic!
════════════════════════════════════════════════════════

✓ Progress saved to your account!
```

---

## 7. Author and Acknowledgement

**To our groupmates** - Thank you for all the late-night coding sessions and group meetings. When we got stuck on bugs, you were there to help figure it out. We couldn't have finished this without everyone's effort and teamwork.

**To our professor** - Thank you for teaching us OOP concepts and being patient when we asked questions. The examples you showed in class helped us understand how to build this project. Your guidance made this possible. To all the OOP professors out there, thank you very much — especially to Sir Jayson Abratique.

**To our parents** - Thank you for understanding when we had to work late on this project and miss family time. Thank you for supporting us, keeping the wifi on, and not complaining about our group meetings at home. Your encouragement kept us going.

**To God** - Most of all, we thank God for giving us the ability to learn, for bringing our group together, and for helping us finish this project. Everything we accomplished is because of His blessings.

---

## 8. Other Sections

### a. Future Enhancements

- Add more OOP topics like Abstraction and Interfaces
- Include a timer for timed quizzes
- Add difficulty levels (Easy, Medium, Hard)
- Create a GUI version using JavaFX
- Add password recovery for forgotten PINs
- Generate printable PDF reports of progress
- Make a web version that can run in browsers
- Add achievements and badges for completed topics

### b. References

**Books:**
- Bloch, Joshua. "Effective Java" (3rd Edition). Addison-Wesley, 2018
- Sierra, Kathy and Bates, Bert. "Head First Java". O'Reilly Media, 2005

**Online Resources:**
- W3Schools Java Tutorial: https://www.w3schools.com/java/
- GeeksforGeeks Java Programming: https://www.geeksforgeeks.org/java/
- Stack Overflow Community: https://stackoverflow.com/

**Course Materials:**
- CS 211 Lecture Notes
- Laboratory Exercises and Activities

---


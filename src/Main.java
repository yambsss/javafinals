import java.util.Scanner;
import model.SessionRecord;
import model.UserAccount;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static UserManager userManager = new UserManager();
    private static UserAccount currentUser = null;
    
    public static void main(String[] args) {
        displayWelcome();
        
        // ito yung authenticate user
        currentUser = userManager.authenticate();
        
        if (currentUser == null) {
            displayGoodbye();
            scanner.close();
            return;
        }
        
        // start 'to ng main program loop
        boolean running = true;
        while (running) {
            try {
                displayMainMenu();
                int choice = getUserChoice();
                
                switch (choice) {
                    case 1:
                        startQuizMode();
                        break;
                    case 2:
                        startReviewMode();
                        break;
                    case 3:
                        viewProgress();
                        break;
                    case 4:
                        running = confirmLogout();
                        break;
                    default:
                        System.out.println("\n Invalid choice! Please enter 1-4.");
                }
            } catch (Exception e) {
                System.out.println("\n Error: " + e.getMessage());
                scanner.nextLine(); //clear buffer
            }
        }
        
        displayGoodbye();
        scanner.close();
    }

    private static void displayWelcome() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║     WELCOME TO RECENSOR SYSTEM - OOP REVIEWER         ║");
        System.out.println("║        Master Object-Oriented Programming!            ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
    }
    
    //  Displays ng main menu options kasama yung user info
    private static void displayMainMenu() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              Welcome, " + 
                         String.format("%-32s", currentUser.getUsername()) + "║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        
        System.out.println("\n┌────────────────────────────────────────────────────────┐");
        System.out.println("│                    MAIN MENU                           │");
        System.out.println("├────────────────────────────────────────────────────────┤");
        System.out.println("│  [1] Quiz Mode - Test your knowledge                  │");
        System.out.println("│  [2] Review Mode - Study OOP concepts                 │");
        System.out.println("│  [3] View Progress - Check your scores                │");
        System.out.println("│  [4] Logout                                           │");
        System.out.println("└────────────────────────────────────────────────────────┘");
        
        // pag display ng quick stats
        System.out.println("\n Quick Stats:");
        System.out.println("   Total Quizzes Taken: " + currentUser.getTotalQuizzesTaken());
        System.out.printf("   Average Score: %.1f%%%n", currentUser.getOverallAverage());
        System.out.println("   Topics Mastered: " + currentUser.getTopicsMastered() + "/7");
        
        System.out.print("\nEnter your choice: ");
    }

    // kukunin nito yung choice ng user kasama yung input validation
    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    //start ng quiz
    private static void startQuizMode() {
        scanner.nextLine(); // Clear buffer
        System.out.println("\n" + "═".repeat(60));
        System.out.println("                      QUIZ MODE");
        System.out.println("═".repeat(60));
        
        displayTopicMenu();
        System.out.print("\nSelect topic (1-7): ");
        int topicChoice = getUserChoice();
        scanner.nextLine();
        
        if (topicChoice >= 1 && topicChoice <= 7) {
            String topic = getTopicName(topicChoice);
            System.out.println("\n Starting quiz on: " + topic);
            System.out.println("  You need 8/10 to proceed to the next topic!\n");
            
            // run na yung quiz tapos kukunin yung session record
            SessionRecord session = runQuiz(topic);
            
            // idadagdag yung session sa user account
            if (session != null) {
                currentUser.addSession(session);
                userManager.saveUserProgress(currentUser);
                System.out.println("\n✓ Progress saved to your account!");
            }
        } else {
            System.out.println("\n Invalid topic selection!");
        }
    }

    private static SessionRecord runQuiz(String topic) {
        QuestionGenerator questionGenerator = new QuestionGenerator();
        java.util.List<model.Question> questions = questionGenerator.generateQuestions(topic);
        
        if (questions.isEmpty()) {
            System.out.println(" No questions available for this topic!");
            return null;
        }
        
        int score = 0;
        int questionNumber = 1;
        
        System.out.println("─".repeat(60));
        System.out.println("Quiz has " + questions.size() + " questions.");
        System.out.println("You need 8/10 to pass!");
        System.out.println("─".repeat(60));
        
        // Execute quiz
        for (model.Question question : questions) {
            System.out.println("\n Question " + questionNumber + "/" + questions.size());
            question.display();
            
            try {
                int answer = getUserAnswer();
                
                if (question.isCorrect(answer - 1)) {
                    score++;
                    System.out.println("✓ YEHEYYYYY TAMA! ");
                } else {
                    System.out.println("✗ Incorrect!");
                    question.showCorrectAnswer();
                }
            } catch (Exception e) {
                System.out.println(" " + e.getMessage());
                question.showCorrectAnswer();
            }
            
            questionNumber++;
            
            // mag pause sya between sa mga questions
            if (questionNumber <= questions.size()) {
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        // display nya yung results
        displayQuizResults(topic, score, questions.size());
        
        // create and return session record
        return new SessionRecord(topic, score, questions.size());
    }
    
    private static int getUserAnswer() throws Exception {
        System.out.print("\nYour answer (1-4): ");
        
        if (!scanner.hasNextInt()) {
            scanner.next(); // Clear invalid input
            throw new Exception("Please enter a number between 1 and 4!");
        }
        
        int answer = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        if (answer < 1 || answer > 4) {
            throw new Exception("Answer must be between 1 and 4!");
        }
        
        return answer;
    }

    private static void displayQuizResults(String topic, int score, int total) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("                    QUIZ RESULTS");
        System.out.println("═".repeat(60));
        System.out.println("Topic: " + topic);
        System.out.println("Score: " + score + "/" + total);
        System.out.printf("Percentage: %.1f%%%n", (score * 100.0) / total);
        
        if (score >= 8) {
            System.out.println("Status: ✓ PASSED! 🎉");
            System.out.println("\nCongratulations! You can proceed to the next topic!");
        } else {
            System.out.println("Status: ✗ FAILED");
            System.out.println("\nYou need at least 8/10 to pass. Keep studying!");
        }
        System.out.println("═".repeat(60));
    }
    
    // start ng review mode
    private static void startReviewMode() {
        scanner.nextLine(); 
        System.out.println("\n" + "═".repeat(60));
        System.out.println("                    REVIEW MODE");
        System.out.println("═".repeat(60));
        
        displayTopicMenu();
        System.out.print("\nSelect topic to review (1-7): ");
        int topicChoice = getUserChoice();
        scanner.nextLine(); 
        
        if (topicChoice >= 1 && topicChoice <= 7) {
            String topic = getTopicName(topicChoice);
            ReviewerPdfWriter reviewer = new ReviewerPdfWriter();
            reviewer.displayReview(topic);
        } else {
            System.out.println("\n Invalid topic selection!");
        }
    }

    //display nya yung mga available na topics which is yung mga module natin
    private static void displayTopicMenu() {
        System.out.println("\n┌────────────────────────────────────────────────────────┐");
        System.out.println("│                   AVAILABLE TOPICS                     │");
        System.out.println("├────────────────────────────────────────────────────────┤");
        System.out.println("│  [1] Introduction to OOP                              │");
        System.out.println("│  [2] Java Conditionals                                │");
        System.out.println("│  [3] Java Loops                                       │");
        System.out.println("│  [4] Java Arrays                                      │");
        System.out.println("│  [5] Encapsulation                                    │");
        System.out.println("│  [6] Inheritance                                      │");
        System.out.println("│  [7] Polymorphism                                     │");
        System.out.println("└────────────────────────────────────────────────────────┘");
    }

    private static String getTopicName(int choice) {
        switch (choice) {
            case 1: return "Introduction";
            case 2: return "Conditionals";
            case 3: return "Loops";
            case 4: return "Arrays";
            case 5: return "Encapsulation";
            case 6: return "Inheritance";
            case 7: return "Polymorphism";
            default: return "";
        }
    }

    // displays ng user progress and session history
    private static void viewProgress() {
        scanner.nextLine(); // Clear buffer
        
        // display ng comprehensive progress
        currentUser.displayProgress();
        
        // show topic mastery
        currentUser.displayTopicMastery();
        
        System.out.print("\nPress Enter to return to main menu...");
        scanner.nextLine();
    }
    
    private static boolean confirmLogout() {
        scanner.nextLine(); // Clear buffer
        System.out.print("\nAre you sure you want to logout? (Y/N): ");
        String confirmation = scanner.nextLine().trim().toUpperCase();
        
        if (confirmation.equals("Y") || confirmation.equals("YES")) {
            userManager.saveUserProgress(currentUser);
            System.out.println("\n✓ Progress saved successfully!");
            return false; 
        }
        
        return true;
    }
    

    private static void displayGoodbye() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║          Thank you for using RecensorSystem!          ║");
        System.out.println("║              Keep learning and improving!             ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
    }
}
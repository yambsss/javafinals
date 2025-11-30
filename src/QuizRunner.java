import java.util.List;
import java.util.Scanner;
import model.Question;
import model.SessionRecord;

/**
 * QuizRunner class - Manages quiz execution and scoring
 * Demonstrates exception handling and user interaction
 */
public class QuizRunner {
    private Scanner scanner;
    private SessionManager sessionManager;
    private QuestionGenerator questionGenerator;
    
    public QuizRunner(SessionManager sessionManager) {
        this.scanner = new Scanner(System.in);
        this.sessionManager = sessionManager;
        this.questionGenerator = new QuestionGenerator();
    }

    public void startQuiz(String topic) {
        List<Question> questions = questionGenerator.generateQuestions(topic);
        
        if (questions.isEmpty()) {
            System.out.println("❌ No questions available for this topic!");
            return;
        }
        
        int score = 0;
        int questionNumber = 1;
        
        System.out.println("─".repeat(60));
        System.out.println("Quiz has " + questions.size() + " questions.");
        System.out.println("You need 8/10 to pass!");
        System.out.println("─".repeat(60));
        
        // Execute ng quiz
        for (Question question : questions) {
            System.out.println("\n📝 Question " + questionNumber + "/" + questions.size());
            question.display();
            
            try {
                int answer = getUserAnswer();
                
                if (question.isCorrect(answer - 1)) {
                    score++;
                    System.out.println("✓ Correct! 🎉");
                } else {
                    System.out.println("✗ Incorrect!");
                    question.showCorrectAnswer();
                }
            } catch (InvalidAnswerException e) {
                System.out.println("❌ " + e.getMessage());
                question.showCorrectAnswer();
            } catch (Exception e) {
                System.out.println("❌ Error processing answer: " + e.getMessage());
                scanner.nextLine(); // Clear buffer
            }
            
            questionNumber++;
            
            if (questionNumber <= questions.size()) {
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        displayResults(topic, score, questions.size());
        
        SessionRecord record = new SessionRecord(topic, score, questions.size());
        sessionManager.addSession(record);
    }

    private int getUserAnswer() throws InvalidAnswerException {
        System.out.print("\nYour answer (1-4): ");
        
        if (!scanner.hasNextInt()) {
            scanner.next(); // Clear invalid input
            throw new InvalidAnswerException("Please enter a number between 1 and 4!");
        }
        
        int answer = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        if (answer < 1 || answer > 4) {
            throw new InvalidAnswerException("Answer must be between 1 and 4!");
        }
        
        return answer;
    }

    private void displayResults(String topic, int score, int total) {
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
    
    private class InvalidAnswerException extends Exception {
        public InvalidAnswerException(String message) {
            super(message);
        }
    }
}
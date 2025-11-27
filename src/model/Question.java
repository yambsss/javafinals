package model;

/**
 * Question class - Represents a quiz question with encapsulation
 * Demonstrates proper use of access modifiers, getters, and setters
 */
public class Question {
    // Private fields demonstrating encapsulation
    private String questionText;
    private String[] options;
    private int correctAnswer;
    private String topic;
    private String explanation;
    
    /**
     * Constructor with all parameters
     * @param questionText the question text
     * @param options array of answer options
     * @param correctAnswer index of correct answer (0-3)
     * @param topic the topic this question belongs to
     * @param explanation explanation of the answer
     */
    public Question(String questionText, String[] options, int correctAnswer, 
                   String topic, String explanation) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.topic = topic;
        this.explanation = explanation;
    }
    
    /**
     * Overloaded constructor without explanation
     * @param questionText the question text
     * @param options array of answer options
     * @param correctAnswer index of correct answer (0-3)
     * @param topic the topic this question belongs to
     */
    public Question(String questionText, String[] options, int correctAnswer, String topic) {
        this(questionText, options, correctAnswer, topic, "");
    }
    
    // Getters demonstrating encapsulation
    public String getQuestionText() {
        return questionText;
    }
    
    public String[] getOptions() {
        return options;
    }
    
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    
    public String getTopic() {
        return topic;
    }
    
    public String getExplanation() {
        return explanation;
    }
    
    // Setters demonstrating encapsulation
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    
    public void setOptions(String[] options) {
        this.options = options;
    }
    
    public void setCorrectAnswer(int correctAnswer) {
        if (correctAnswer >= 0 && correctAnswer < 4) {
            this.correctAnswer = correctAnswer;
        }
    }
    
    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
    
    /**
     * Checks if the given answer is correct
     * @param answer the answer index to check
     * @return true if correct, false otherwise
     */
    public boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }
    
    /**
     * Displays the question and options
     */
    public void display() {
        System.out.println("\n" + questionText);
        System.out.println("─".repeat(50));
        for (int i = 0; i < options.length; i++) {
            System.out.println("  [" + (i + 1) + "] " + options[i]);
        }
    }
    
    /**
     * Displays the correct answer with explanation
     */
    public void showCorrectAnswer() {
        System.out.println("\n✓ Correct Answer: [" + (correctAnswer + 1) + "] " 
                         + options[correctAnswer]);
        if (!explanation.isEmpty()) {
            System.out.println("💡 Explanation: " + explanation);
        }
    }
    
    @Override
    public String toString() {
        return "Question [Topic: " + topic + ", Text: " + questionText + "]";
    }
}
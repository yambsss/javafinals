package model;

public class Question {

    private String questionText;
    private String[] options;
    private int correctAnswer;
    private String topic;
    private String explanation;
    
    public Question(String questionText, String[] options, int correctAnswer, 
                   String topic, String explanation) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.topic = topic;
        this.explanation = explanation;
    }

    public Question(String questionText, String[] options, int correctAnswer, String topic) {
        this(questionText, options, correctAnswer, topic, "");
    }
    
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
    
    public boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }
    
    public void display() {
        System.out.println("\n" + questionText);
        System.out.println("─".repeat(50));
        for (int i = 0; i < options.length; i++) {
            System.out.println("  [" + (i + 1) + "] " + options[i]);
        }
    }
    
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
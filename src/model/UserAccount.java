package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String pinCode;
    private String username;
    private List<SessionRecord> sessionHistory;
    private Map<String, Integer> topicScores; 
    private int totalQuizzesTaken;
    private long accountCreationDate;
    
    public UserAccount(String pinCode, String username) {
        this.pinCode = pinCode;
        this.username = username;
        this.sessionHistory = new ArrayList<>();
        this.topicScores = new HashMap<>();
        this.totalQuizzesTaken = 0;
        this.accountCreationDate = System.currentTimeMillis();
        
        initializeTopicScores();
    }
    
    private void initializeTopicScores() {
        String[] topics = {"Introduction", "Conditionals", "Loops", 
                          "Arrays", "Encapsulation", "Inheritance", "Polymorphism"};
        for (String topic : topics) {
            topicScores.put(topic, 0);
        }
    }
    
    public boolean verifyPin(String enteredPin) {
        return this.pinCode.equals(enteredPin);
    }
    
    public void addSession(SessionRecord session) {
        if (session != null) {
            sessionHistory.add(session);
            totalQuizzesTaken++;
            
            String topic = session.getTopic();
            int currentBest = topicScores.getOrDefault(topic, 0);
            if (session.getScore() > currentBest) {
                topicScores.put(topic, session.getScore());
            }
        }
    }
    
    public int getBestScore(String topic) {
        return topicScores.getOrDefault(topic, 0);
    }
    
    public double getOverallAverage() {
        if (sessionHistory.isEmpty()) {
            return 0.0;
        }
        
        double totalPercentage = 0;
        for (SessionRecord session : sessionHistory) {
            totalPercentage += session.getPercentage();
        }
        
        return totalPercentage / sessionHistory.size();
    }
    
    public int getTopicsMastered() {
        int count = 0;
        for (int score : topicScores.values()) {
            if (score >= 8) {
                count++;
            }
        }
        return count;
    }
    
    public int getPassedCount() {
        int count = 0;
        for (SessionRecord session : sessionHistory) {
            if (session.isPassed()) {
                count++;
            }
        }
        return count;
    }
    
    public int getFailedCount() {
        return totalQuizzesTaken - getPassedCount();
    }
    
    public void displayProgress() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("                  YOUR PROGRESS");
        System.out.println("═".repeat(60));
        System.out.println("\n User: " + username);
        System.out.println(" Total Sessions: " + totalQuizzesTaken);
        System.out.println(" Passed: " + getPassedCount());
        System.out.println(" Failed: " + getFailedCount());
        System.out.printf(" Overall Average: %.1f%%%n", getOverallAverage());
        System.out.println("\n" + "─".repeat(60) + "\n");
        
        if (sessionHistory.isEmpty()) {
            System.out.println("No quiz sessions recorded yet.");
            System.out.println("Take a quiz to see your progress here!\n");
            return;
        }
        
        for (int i = 0; i < sessionHistory.size(); i++) {
            System.out.println("Session #" + (i + 1));
            sessionHistory.get(i).display();
            System.out.println();
        }
        
        System.out.println(" Tip: Review the failed topics and try again!");
    }
    
    public void displayTopicMastery() {
        System.out.println("\n TOPIC MASTERY STATUS\n");
        System.out.println("┌────────────────────────────────┬──────────┬──────────┐");
        System.out.println("│ Topic                          │ Best     │ Status   │");
        System.out.println("├────────────────────────────────┼──────────┼──────────┤");
        
        String[] topics = {"Introduction", "Conditionals", "Loops", 
                          "Arrays", "Encapsulation", "Inheritance", "Polymorphism"};
        
        for (String topic : topics) {
            int bestScore = getBestScore(topic);
            String status = bestScore >= 8 ? "✓ Mastered" : "Practice";
            System.out.printf("│ %-30s │ %2d/10    │ %-8s │%n", 
                            topic, bestScore, status);
        }
        
        System.out.println("└────────────────────────────────┴──────────┴──────────┘");
        System.out.printf("\nTopics Mastered: %d/7%n", getTopicsMastered());
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPinCode() {
        return pinCode;
    }
    
    public List<SessionRecord> getSessionHistory() {
        return new ArrayList<>(sessionHistory);
    }
    
    public int getTotalQuizzesTaken() {
        return totalQuizzesTaken;
    }
    
    public long getAccountCreationDate() {
        return accountCreationDate;
    }
    
    // Setters with validation
    public void setUsername(String username) {
        if (username != null && !username.trim().isEmpty()) {
            this.username = username;
        }
    }
    
    public void setPinCode(String pinCode) {
        if (pinCode != null && pinCode.matches("\\d{5}")) {
            this.pinCode = pinCode;
        }
    }
    
    @Override
    public String toString() {
        return String.format("User: %s | PIN: %s | Quizzes: %d | Average: %.1f%%", 
                           username, pinCode, totalQuizzesTaken, getOverallAverage());
    }
}
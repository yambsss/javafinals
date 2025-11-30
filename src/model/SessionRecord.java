package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SessionRecord {
    private String topic;
    private int score;
    private int totalQuestions;
    private LocalDateTime dateTime;
    private boolean passed;
    
    public SessionRecord(String topic, int score, int totalQuestions) {
        this.topic = topic;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.dateTime = LocalDateTime.now();
        this.passed = score >= 8; // Pass threshold is 8/10
    }
    
    public String getTopic() {
        return topic;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getTotalQuestions() {
        return totalQuestions;
    }
    
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    
    public boolean isPassed() {
        return passed;
    }
    
    public String getFormattedDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm");
        return dateTime.format(formatter);
    }
    
    public double getPercentage() {
        return (score * 100.0) / totalQuestions;
    }
    
    public String getStatus() {
        return passed ? "PASSED ✓" : "FAILED ✗";
    }
    
    public void display() {
        System.out.println("┌────────────────────────────────────────────────────────┐");
        System.out.printf("│ Topic: %-47s │%n", topic);
        System.out.printf("│ Score: %d/%d (%.1f%%)%37s │%n", 
                         score, totalQuestions, getPercentage(), "");
        System.out.printf("│ Status: %-46s │%n", getStatus());
        System.out.printf("│ Date: %-48s │%n", getFormattedDateTime());
        System.out.println("└────────────────────────────────────────────────────────┘");
    }
    
    @Override
    public String toString() {
        return String.format("%s - %d/%d (%s) - %s", 
                           topic, score, totalQuestions, getStatus(), getFormattedDateTime());
    }
}
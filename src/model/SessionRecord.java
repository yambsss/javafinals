package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * SessionRecord class - Records quiz session data
 * Demonstrates encapsulation and data management
 */
public class SessionRecord {
    private String topic;
    private int score;
    private int totalQuestions;
    private LocalDateTime dateTime;
    private boolean passed;
    
    /**
     * Constructor for SessionRecord
     * @param topic the quiz topic
     * @param score the score achieved
     * @param totalQuestions total number of questions
     */
    public SessionRecord(String topic, int score, int totalQuestions) {
        this.topic = topic;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.dateTime = LocalDateTime.now();
        this.passed = score >= 8; // Pass threshold is 8/10
    }
    
    // Getters
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
    
    /**
     * Gets formatted date and time
     * @return formatted date-time string
     */
    public String getFormattedDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm");
        return dateTime.format(formatter);
    }
    
    /**
     * Calculates percentage score
     * @return percentage as double
     */
    public double getPercentage() {
        return (score * 100.0) / totalQuestions;
    }
    
    /**
     * Gets status string (PASSED/FAILED)
     * @return status string
     */
    public String getStatus() {
        return passed ? "PASSED ✓" : "FAILED ✗";
    }
    
    /**
     * Displays session record details
     */
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
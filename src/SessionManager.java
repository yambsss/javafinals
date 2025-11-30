import java.util.ArrayList;
import java.util.List;
import model.SessionRecord;

public class SessionManager {
    private List<SessionRecord> sessions;
  
    public SessionManager() {
        this.sessions = new ArrayList<>();
    }
   
    public void addSession(SessionRecord session) {
        if (session != null) {
            sessions.add(session);
        }
    }
    
    public List<SessionRecord> getAllSessions() {
        return new ArrayList<>(sessions); // Return copy for encapsulation
    }
    
    public List<SessionRecord> getSessionsByTopic(String topic) {
        List<SessionRecord> topicSessions = new ArrayList<>();
        
        for (SessionRecord session : sessions) {
            if (session.getTopic().equalsIgnoreCase(topic)) {
                topicSessions.add(session);
            }
        }
        
        return topicSessions;
    }
    
    public SessionRecord getLatestSession() {
        if (sessions.isEmpty()) {
            return null;
        }
        return sessions.get(sessions.size() - 1);
    }
    
    public double getAverageScore(String topic) {
        List<SessionRecord> topicSessions = getSessionsByTopic(topic);
        
        if (topicSessions.isEmpty()) {
            return 0.0;
        }
        
        double totalPercentage = 0;
        for (SessionRecord session : topicSessions) {
            totalPercentage += session.getPercentage();
        }
        
        return totalPercentage / topicSessions.size();
    }
    
    public int getPassedCount() {
        int count = 0;
        for (SessionRecord session : sessions) {
            if (session.isPassed()) {
                count++;
            }
        }
        return count;
    }
    
    public int getFailedCount() {
        return sessions.size() - getPassedCount();
    }
    
    public void displayAllSessions() {
        if (sessions.isEmpty()) {
            System.out.println("\n📊 No quiz sessions recorded yet.");
            System.out.println("Take a quiz to see your progress here!\n");
            return;
        }
        
        System.out.println("\n📊 Total Sessions: " + sessions.size());
        System.out.println("✓ Passed: " + getPassedCount());
        System.out.println("✗ Failed: " + getFailedCount());
        System.out.println();
        
        for (int i = 0; i < sessions.size(); i++) {
            System.out.println("Session #" + (i + 1));
            sessions.get(i).display();
            System.out.println();
        }
    }
    
    public void displayStatistics() {
        if (sessions.isEmpty()) {
            System.out.println("No statistics available yet.");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║                  OVERALL STATISTICS                    ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("Total Attempts: " + sessions.size());
        System.out.println("Passed: " + getPassedCount());
        System.out.println("Failed: " + getFailedCount());
        System.out.printf("Pass Rate: %.1f%%%n", 
                         (getPassedCount() * 100.0) / sessions.size());
        System.out.println();
    }
    
    public void clearAllSessions() {
        sessions.clear();
        System.out.println("✓ All session records cleared.");
    }
    
    public int getSessionCount() {
        return sessions.size();
    }
}
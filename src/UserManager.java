import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.UserAccount;

/**
 * UserManager class - Manages user accounts and authentication
 * Demonstrates file I/O, exception handling, and data persistence
 */
public class UserManager {
    private static final String DATA_FILE = "data/users.dat";
    private Map<String, UserAccount> users; // PIN -> UserAccount mapping
    private Scanner scanner;
    
    /**
     * Constructor initializes user manager and loads existing users
     */
    public UserManager() {
        this.users = new HashMap<>();
        this.scanner = new Scanner(System.in);
        createDataDirectory();
        loadUsers();
    }
    
    /**
     * Creates data directory if it doesn't exist
     */
    private void createDataDirectory() {
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
    }
    
    /**
     * Loads users from file
     */
    @SuppressWarnings("unchecked")
    private void loadUsers() {
        File file = new File(DATA_FILE);
        
        if (!file.exists()) {
            return; // No users file yet
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file))) {
            users = (Map<String, UserAccount>) ois.readObject();
            System.out.println("✓ User data loaded successfully.");
        } catch (FileNotFoundException e) {
            // File doesn't exist yet, will be created on first save
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠️  Warning: Could not load user data.");
            System.out.println("   Starting with fresh database.");
        }
    }
    
    /**
     * Saves users to file
     */
    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(DATA_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.out.println("❌ Error: Could not save user data.");
            System.out.println("   Your progress may not be saved.");
        }
    }
    
    /**
     * Main authentication menu
     * @return logged in UserAccount or null if exit
     */
    public UserAccount authenticate() {
        while (true) {
            displayAuthMenu();
            
            try {
                int choice = getUserChoice();
                
                switch (choice) {
                    case 1:
                        UserAccount loginUser = login();
                        if (loginUser != null) {
                            return loginUser;
                        }
                        break;
                    case 2:
                        UserAccount newUser = createAccount();
                        if (newUser != null) {
                            return newUser;
                        }
                        break;
                    case 3:
                        return null; // Exit
                    default:
                        System.out.println("\n❌ Invalid choice! Please enter 1-3.");
                }
            } catch (Exception e) {
                System.out.println("\n❌ Error: " + e.getMessage());
                scanner.nextLine(); // Clear buffer
            }
        }
    }
    
    /**
     * Displays authentication menu
     */
    private void displayAuthMenu() {
        System.out.println("\n┌────────────────────────────────────────────────────────┐");
        System.out.println("│                   USER AUTHENTICATION                  │");
        System.out.println("├────────────────────────────────────────────────────────┤");
        System.out.println("│  [1] Login with existing PIN                          │");
        System.out.println("│  [2] Create new account                               │");
        System.out.println("│  [3] Exit                                             │");
        System.out.println("└────────────────────────────────────────────────────────┘");
        System.out.print("\nEnter your choice: ");
    }
    
    /**
     * Gets user choice with validation
     * @return user's choice
     */
    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    /**
     * Handles user login
     * @return UserAccount if login successful, null otherwise
     */
    private UserAccount login() {
        scanner.nextLine(); // Clear buffer
        
        System.out.println("\n" + "═".repeat(60));
        System.out.println("                       LOGIN");
        System.out.println("═".repeat(60));
        
        System.out.print("\nEnter your 5-digit PIN: ");
        String pin = scanner.nextLine().trim();
        
        // Validate PIN format
        if (!isValidPin(pin)) {
            System.out.println("❌ Invalid PIN format! PIN must be exactly 5 digits.");
            return null;
        }
        
        // Check if user exists
        UserAccount user = users.get(pin);
        if (user == null) {
            System.out.println("❌ PIN not found! Please check your PIN or create a new account.");
            return null;
        }
        
        System.out.println("\n✓ Login successful!");
        System.out.println("Welcome back, " + user.getUsername() + "! 🎉");
        
        // Display quick stats
        System.out.println("\n📊 Your Stats:");
        System.out.println("   Quizzes Taken: " + user.getTotalQuizzesTaken());
        System.out.printf("   Average Score: %.1f%%%n", user.getOverallAverage());
        System.out.println("   Topics Mastered: " + user.getTopicsMastered() + "/7");
        
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
        
        return user;
    }
    
    /**
     * Handles account creation
     * @return newly created UserAccount or null if cancelled
     */
    private UserAccount createAccount() {
        scanner.nextLine(); // Clear buffer
        
        System.out.println("\n" + "═".repeat(60));
        System.out.println("                  CREATE NEW ACCOUNT");
        System.out.println("═".repeat(60));
        
        // Get username
        System.out.print("\nEnter your name: ");
        String username = scanner.nextLine().trim();
        
        if (username.isEmpty()) {
            System.out.println("❌ Name cannot be empty!");
            return null;
        }
        
        // Get PIN
        String pin = null;
        while (pin == null) {
            System.out.print("\nCreate a 5-digit PIN code: ");
            String inputPin = scanner.nextLine().trim();
            
            if (!isValidPin(inputPin)) {
                System.out.println("❌ Invalid PIN! Must be exactly 5 digits.");
                continue;
            }
            
            if (users.containsKey(inputPin)) {
                System.out.println("❌ This PIN is already taken! Please choose another.");
                continue;
            }
            
            // Confirm PIN
            System.out.print("Confirm your PIN code: ");
            String confirmPin = scanner.nextLine().trim();
            
            if (!inputPin.equals(confirmPin)) {
                System.out.println("❌ PINs don't match! Please try again.");
                continue;
            }
            
            pin = inputPin;
        }
        
        // Create account
        UserAccount newUser = new UserAccount(pin, username);
        users.put(pin, newUser);
        saveUsers();
        
        System.out.println("\n✓ Account created successfully! 🎉");
        System.out.println("Your username: " + username);
        System.out.println("Your PIN: " + pin);
        System.out.println("\n⚠️  IMPORTANT: Please remember your PIN for future logins!");
        
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
        
        return newUser;
    }
    
    /**
     * Validates PIN format
     * @param pin PIN to validate
     * @return true if valid, false otherwise
     */
    private boolean isValidPin(String pin) {
        if (pin == null) {
            return false;
        }
        return pin.matches("\\d{5}"); // Exactly 5 digits
    }
    
    /**
     * Saves user progress
     * @param user UserAccount to save
     */
    public void saveUserProgress(UserAccount user) {
        if (user != null) {
            users.put(user.getPinCode(), user);
            saveUsers();
        }
    }
    
    /**
     * Gets total number of registered users
     * @return user count
     */
    public int getUserCount() {
        return users.size();
    }
    
    /**
     * Checks if a PIN exists
     * @param pin PIN to check
     * @return true if exists, false otherwise
     */
    public boolean pinExists(String pin) {
        return users.containsKey(pin);
    }
}
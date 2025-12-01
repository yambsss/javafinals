import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.UserAccount;

public class UserManager {
    private static final String DATA_FILE = "data/users.dat";
    private Map<String, UserAccount> users; // PIN -> UserAccount mapping
    private Scanner scanner;
    
    public UserManager() {
        this.users = new HashMap<>();
        this.scanner = new Scanner(System.in);
        createDataDirectory();
        loadUsers();
    }
    
    private void createDataDirectory() {
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }
    }
    
    @SuppressWarnings("unchecked")
    private void loadUsers() {
        File file = new File(DATA_FILE);
        
        if (!file.exists()) {
            return; 
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file))) {
            users = (Map<String, UserAccount>) ois.readObject();
            System.out.println(" User data loaded successfully.");
        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("  Warning: Could not load user data.");
            System.out.println("   Starting with fresh database.");
        }
    }
    
    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(DATA_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.out.println(" Error: Could not save user data.");
            System.out.println("   Your progress may not be saved.");
        }
    }

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
                        return null; 
                    default:
                        System.out.println("\n Invalid choice! Please enter 1-3.");
                }
            } catch (Exception e) {
                System.out.println("\n Error: " + e.getMessage());
                scanner.nextLine(); 
            }
        }
    }
 
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
    
    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
    
    private UserAccount login() {
        scanner.nextLine(); 
        
        System.out.println("\n" + "═".repeat(60));
        System.out.println("                       LOGIN");
        System.out.println("═".repeat(60));
        
        System.out.print("\nEnter your 5-digit PIN: ");
        String pin = scanner.nextLine().trim();
        
        if (!isValidPin(pin)) {
            System.out.println(" Invalid PIN format! PIN must be exactly 5 digits.");
            return null;
        }
        
        UserAccount user = users.get(pin);
        if (user == null) {
            System.out.println(" PIN not found! Please check your PIN or create a new account.");
            return null;
        }
        
        System.out.println("\n Login successful!");
        System.out.println("Welcome back, " + user.getUsername() + "! ");
        
        // Display quick stats
        System.out.println("\n Your Stats:");
        System.out.println("   Quizzes Taken: " + user.getTotalQuizzesTaken());
        System.out.printf("   Average Score: %.1f%%%n", user.getOverallAverage());
        System.out.println("   Topics Mastered: " + user.getTopicsMastered() + "/7");
        
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
        
        return user;
    }
    
    private UserAccount createAccount() {
        scanner.nextLine(); 
        
        System.out.println("\n" + "═".repeat(60));
        System.out.println("                  CREATE NEW ACCOUNT");
        System.out.println("═".repeat(60));
        
        System.out.print("\nEnter your name: ");
        String username = scanner.nextLine().trim();
        
        if (username.isEmpty()) {
            System.out.println(" Name cannot be empty!");
            return null;
        }
        
        String pin = null;
        while (pin == null) {
            System.out.print("\nCreate a 5-digit PIN code: ");
            String inputPin = scanner.nextLine().trim();
            
            if (!isValidPin(inputPin)) {
                System.out.println(" Invalid PIN! Must be exactly 5 digits.");
                continue;
            }
            
            if (users.containsKey(inputPin)) {
                System.out.println(" This PIN is already taken! Please choose another.");
                continue;
            }
            
            System.out.print("Confirm your PIN code: ");
            String confirmPin = scanner.nextLine().trim();
            
            if (!inputPin.equals(confirmPin)) {
                System.out.println(" PINs don't match! Please try again.");
                continue;
            }
            
            pin = inputPin;
        }
        
        UserAccount newUser = new UserAccount(pin, username);
        users.put(pin, newUser);
        saveUsers();
        
        System.out.println("\n✓ Account created successfully! ");
        System.out.println("Your username: " + username);
        System.out.println("Your PIN: " + pin);
        System.out.println("\n  IMPORTANT: Please remember your PIN for future logins!");
        
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
        
        return newUser;
    }
    
    private boolean isValidPin(String pin) {
        if (pin == null) {
            return false;
        }
        return pin.matches("\\d{5}"); // Exactly 5 digits
    }
    
    public void saveUserProgress(UserAccount user) {
        if (user != null) {
            users.put(user.getPinCode(), user);
            saveUsers();
        }
    }
    
    public int getUserCount() {
        return users.size();
    }
    
    public boolean pinExists(String pin) {
        return users.containsKey(pin);
    }
}



import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

class ReservationSystem {
    public void makeReservation() {
        // Implementation of reservation form
        // Collect necessary details and insert into database
        System.out.println("Reservation made successfully!");
    }

    public void cancelReservation(String PNR) {
        // Implementation of cancellation form
        // Retrieve reservation details from database using PNR and cancel
        System.out.println("Reservation with PNR " + PNR + " cancelled successfully!");
    }
}

public class Demo1{
    private static User[] users = {
            new User("admin", "password"),
            // Add more users as needed
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User currentUser = authenticateUser(username, password);
        if (currentUser != null) {
            System.out.println("Login successful!");

            // Main menu
            ReservationSystem reservationSystem = new ReservationSystem();
            while (true) {
                System.out.println("\nMain Menu:");
                System.out.println("1. Make Reservation");
                System.out.println("2. Cancel Reservation");
                System.out.println("3. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        reservationSystem.makeReservation();
                        break;
                    case 2:
                        System.out.print("Enter PNR number to cancel reservation: ");
                        String PNR = scanner.nextLine();
                        reservationSystem.cancelReservation(PNR);
                        break;
                    case 3:
                        System.out.println("Logged out.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.authenticate(username, password)) {
                return user;
            }
        }
        return null;
    }
}




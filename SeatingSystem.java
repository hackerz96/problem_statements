import java.util.Scanner;

public class SeatingSystem {
    public int[][] seats = new int[10][7]; // 10 rows and 7 columns

    // Initialize all seats to available (0)
    public void initializeSeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 0;
            }
        }
    }

    // Display seat map
    public void displaySeats() {
        System.out.println("Seat Map (0 = Available, 1 = Booked):");
        System.out.print("   ");
        for (int c = 0; c < seats[0].length; c++) {
            System.out.print("C" + c + " ");
        }
        System.out.println();
        for (int i = 0; i < seats.length; i++) {
            System.out.print("R" + i + " ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(" " + seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Book a seat
    public void bookSeat(int row, int col) {
        if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
            System.out.println("Invalid seat position.");
        } else if (seats[row][col] == 0) {
            seats[row][col] = 1;
            System.out.println("Seat R" + row + "C" + col + " booked successfully!");
        } else {
            System.out.println(" Seat R" + row + "C" + col + " is already booked.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SeatingSystem cinema = new SeatingSystem();
        cinema.initializeSeats();

        int choice;
        while(true){
            System.out.println("\n--- Cinema Hall Booking System ---");
            System.out.println("1. Display Seat Map");
            System.out.println("2. Book a Seat");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    cinema.displaySeats();
                    break;

                case 2:
                    System.out.print("Enter Row (0-9): ");
                    int row = scanner.nextInt();
                    System.out.print("Enter Column (0-6): ");
                    int col = scanner.nextInt();
                    cinema.bookSeat(row, col);
                    break;

                case 3:
                    System.out.println("Exiting system. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

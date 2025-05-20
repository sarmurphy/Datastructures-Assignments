package MovieTheatre;

/*
Simulate a movie theater that helps users to book and reserve seats.
1. reserve seats (if seat is taken, let them know it is taken and suggest an available seat)
2. cancel seats
3. retrieve initial seating charting
*/

public class MovieTheatre {
    private static String[][] seats;

    public static void main(String[] args) {
        int rows = 10;
        int columns = 10;

        seats = new String[rows][columns];

        System.out.println("All seating: ");
        viewSeats();

        System.out.println("Reserved Seats: ");
        reserveSeat(1, 1);
        reserveSeat(2, 2);
        reserveSeat(3, 3);

        System.out.println("All Open Seating After Reservations: ");
        viewSeats();

        System.out.println("Seat Cancellations: ");
        cancelSeat(2, 2);

        System.out.println("Updated Seating After Cancellation: ");
        viewSeats();
    }

    // To reserve a seat:
    public static void reserveSeat(int row, int column) {
        if (seats[row][column] == null) {
            seats[row][column] = "Reserved";
            System.out.println("Seat reserved at row " + (row + 1) + ", column " + (column + 1));
            } else {
            System.out.println("This seat is taken at row " + (row + 1) + ", column " + (column + 1));
            suggestNewSeat(seats.length, seats[0].length);
            }
        }

    // To cancel a seat:
    public static void cancelSeat(int row, int column) {
        if (seats[row][column] != null) {
            seats[row][column] = null;
            System.out.println("Seat at row " + (row + 1) + ", column " + (column + 1) + " has been cancelled.");
            } else {
            System.out.println("The seat at row " + (row + 1) + ", column " + (column + 1) + " is not currently reserved.");
        }
    }

    // To view the seating chart:
    public static void viewSeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int c = 0; c < seats[i].length; c++) {
                System.out.println((seats[i][c] == null ? "Available" : "Reserved") + "\t");
            }
            System.out.println();
        }
    }

    // Suggesting an available seat: 
    public static void suggestNewSeat(int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int c = 0; c < column; c++) {
                if (seats[i][c] == null) {
                    System.out.println("Suggested new seat is row " + (i + 1) + ", column " + (c + 1));
                    return;
                }
            }
        }
            System.out.println("No available seats.");
    }

}


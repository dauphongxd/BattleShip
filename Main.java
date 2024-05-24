package battleship;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Ship[] ships = {
            new Ship("Aircraft Carrier", 5),
            new Ship("Battleship", 4),
            new Ship("Submarine", 3),
            new Ship("Cruiser", 3),
            new Ship("Destroyer", 2)
    };

    private static void placeShip(Board board) {
        Scanner sc = new Scanner(System.in);
        for (Ship ship : ships) {
            boolean isValid = false;
            System.out.println("Enter the coordinates of the " + ship.getName() + " (" + ship.getLength() + " cells): ");
            while (!isValid) {

                System.out.println();
                String input = sc.nextLine();
                String[] parts = input.split("\\s+");
                String start = parts[0];
                String end = parts[1];

                if (board.isValidPlacement(start, end, ship.getLength(), ship)) {
                    System.out.println();
                    board.placeShip(start, end, ship.getSymbol());
                    board.printPlayerBoard();
                    isValid = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board player1Board = new Board();
        Board player2Board = new Board();

        // Player 1 place ships
        System.out.println("Player 1, place your ships on the game field\n");
        player1Board.printPlayerBoard();
        placeShip(player1Board);
        System.out.println("Press Enter and pass the move to another player");
        scanner.nextLine();

        // Player 2 place ships
        System.out.println("Player 2, place your ships to the game field\n");
        player2Board.printPlayerBoard();
        placeShip(player2Board);
        System.out.println("Press Enter and pass the move to another player");
        scanner.nextLine();

        boolean player1Turn = true;

        while (true) {
            Board currentBoard = player1Turn ? player2Board : player1Board;
            Board ownBoard = player1Turn ? player1Board : player2Board;
            String currentPlayer = player1Turn ? "Player 1" : "Player 2";

            ownBoard.printBothBoard(currentBoard);
            System.out.println(currentPlayer + ", it's your turn: ");

            boolean validInput = false;
            while (!validInput) {
                System.out.println();
                String input = scanner.nextLine().trim().toUpperCase();

                if (input.length() < 2) {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                    continue;
                }

                int row = input.charAt(0) - 'A';
                int col;
                try {
                    col = Integer.parseInt(input.substring((1)).trim()) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                    continue;
                }

                if (row < 0 || row >= 10 || col < 0 || col >= 10) {
                    System.out.println();
                    System.out.println("Error! You entered the wrong coordinates! Try again:");
                    System.out.println();
                    continue;
                } else {
                    currentBoard.hitOrMiss(row, col);
                    validInput = true;
                }
            }

            System.out.println("Press Enter and pass the move to another player");
            scanner.nextLine();

            player1Turn = !player1Turn;
        }


//        while (true) {
//            String input = scanner.nextLine();
//            int row = input.charAt(0) - 'A';
//            int col = Integer.parseInt(input.substring((1)).trim()) - 1;
//            if(row >= 10 || col >= 10) {
//                System.out.println();
//                System.out.println("Error! You entered the wrong coordinates! Try again:");
//                System.out.println();
//                continue;
//            } else {
//                board.hitOrMiss(row, col);
//
//            }
//
//
//
//        }




    }
}

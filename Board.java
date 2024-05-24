package battleship;

import java.util.Arrays;

public class Board {
    private final char[][] board = new char[10][10];
    private final Ship[] ships;
    private final char[][] originalBoard = new char[10][10];
    private int shipIndex = 0;
    private final boolean[] shipSunkStatus;

    public Board() {
        for (char[] row : board) {
            Arrays.fill(row, '~');
        }
        for (char[] row : originalBoard) {
            Arrays.fill(row, '~');
        }
        ships = new Ship[] {
                new Ship("Aircraft Carrier", 5),
                new Ship("Battleship", 4),
                new Ship("Submarine", 3),
                new Ship("Cruiser", 3),
                new Ship("Destroyer", 2)
        };

        shipSunkStatus = new boolean[ships.length];

    }

    public char[][] getBoard() {
        return this.board;
    }

//    public void printOriginalBoard() {
//        System.out.println();
//        for (int i = 0; i < originalBoard.length + 1; i++) {
//            if (i == 0) {
//                System.out.print("  ");
//            } else {
//                System.out.print(i + " ");
//            }
//        }
//        System.out.println();
//        char rowLabel = 'A';
//        for (char[] row : originalBoard) {
//            System.out.print(rowLabel + " ");
//            for (char cell : row) {
//                System.out.print(cell + " ");
//            }
//            rowLabel++;
//            System.out.println();
//        }
//        System.out.println();
//    }

    public void printBothBoard(Board opponentBoard) {
        printOpponentBoard(opponentBoard);
        System.out.println("---------------------");
        printPlayerBoard();
    }


    public void printOpponentBoard(Board opponentBoard) {
        for(int i = 0; i < opponentBoard.originalBoard.length + 1; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        char rowLabel = 'A';
        for(char[] row : opponentBoard.originalBoard) {
            System.out.print(rowLabel + " ");
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            rowLabel++;
            System.out.println();
        }
    }
    public void printPlayerBoard() {
        for(int i = 0; i < board.length + 1; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        char rowLabel = 'A';
        for(char[] row : board) {
            System.out.print(rowLabel + " ");
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            rowLabel++;
            System.out.println();
        }
        System.out.println();
    }


    public boolean isValidPlacement(String start, String end, int length, Ship ship) {
        int startRow = start.charAt(0) - 'A';
        int startCol = Integer.parseInt(start.substring(1).trim()) - 1; // adjust column index
        int endRow = end.charAt(0) - 'A';
        int endCol = Integer.parseInt(end.substring(1).trim()) - 1; // adjust column index

        if (startRow != endRow && startCol != endCol) {
            System.out.println();
            System.out.println("Error! Wrong ship location! Try again:");
            return false;
        }

        if(startRow == endRow) {
            int minCol = Math.min(startCol, endCol);
            int maxCol = Math.max(startCol, endCol);
            for (int col = minCol; col <= maxCol; col++) {
                if (isAdjacentToShip(startRow, col)) {
                    System.out.println();
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    return false;
                }
            }
        } else if (startCol == endCol) {
            int minRow = Math.min(startRow, endRow);
            int maxRow = Math.max(startRow, endRow);
            for (int row = minRow; row <= maxRow; row++) {
                if (isAdjacentToShip(row, startCol)) {
                    System.out.println();
                    System.out.println("Error! You placed it too close to another one. Try again:");
                    return false;
                }
            }
        }

        int shipLength = Math.max(Math.abs(endRow - startRow), Math.abs(endCol - startCol)) + 1;
        if (shipLength != length) {
            System.out.println();
            System.out.println("Error! Wrong length of the " + ship.getName() + "! Try again:");
            return false;
        }
        return true;
    }

    private boolean isAdjacentToShip(int row, int col) {
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r >= 0 && r < 10 && c >= 0 && c < 10 && !(r == row && c == col)) {
                    if (board[r][c] != '~') {
                        return true;
                    }
                }
            }
        }
        return false;
    }



    public void placeShip(String start, String end, char symbol) {
        int startRow = start.charAt(0) - 'A';
        int startCol = Integer.parseInt(start.substring(1).trim()) - 1; // adjust column index
        int endRow = end.charAt(0) - 'A';
        int endCol = Integer.parseInt(end.substring(1).trim()) - 1; // adjust column index

        if (startRow == endRow) {
            int minCol = Math.min(startCol, endCol);
            int maxCol = Math.max(startCol, endCol);
            for (int col = minCol; col <= maxCol; col++) {
                board[startRow][col] = symbol;
                ships[shipIndex].setLocation(col - minCol, startRow, col);
            }
        } else if (startCol == endCol) {
            int minRow = Math.min(startRow, endRow);
            int maxRow = Math.max(startRow, endRow);
            for (int row = minRow; row <= maxRow; row++) {
                board[row][startCol] = symbol;
                ships[shipIndex].setLocation(row - minRow, row, startCol);
            }
        }

        shipIndex++;

    }

    public void hitOrMiss(int row, int col) {
//        int row = place.charAt(0) - 'A';
//        int col = Integer.parseInt(place.substring((1)).trim()) - 1;



        if (board[row][col] == 'O' || board[row][col] == 'X') {
            originalBoard[row][col] = 'X';
            board[row][col] = 'X';
            if (areAllShipsSunk()) {
                System.out.println("You sank the last ship. You won. Congratulations!");
                System.exit(0);
            } else if (checkSunkShip()) {
                System.out.println("You sank a ship! Specify a new target:");
                System.out.println();
            }
             else {
                System.out.println();
                System.out.println("You hit a ship!");
            }

//            printBoard();

        } else {
            originalBoard[row][col] = 'M';
            board[row][col] = 'M';
            System.out.println();
            System.out.println("You missed!");
//            printBoard();

        }

    }

    private boolean checkSunkShip() {
        boolean shipSunk = false;
        for (int i = 0; i < ships.length; i++) {
            if (!shipSunkStatus[i] && ships[i].isSunk(board)) {
                shipSunkStatus[i] = true;
                shipSunk = true;
            }
        }
        return shipSunk;
    }

    private boolean areAllShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk(board)) {
                return false;
            }
        }
        return true;
    }
}

package battleship;

public class Ship {
    private String name;
    private int length;
    private char symbol;
    private int[] x;
    private int[] y;

    public Ship(String name, int length) {
        this.name = name;
        this.length = length;
        this.symbol = 'O';
        this.x = new int[length];
        this.y = new int[length];
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return length;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setLocation(int index, int x, int y) {
        this.x[index] = x;
        this.y[index] = y;
    }


    public boolean isSunk(char[][] board) {
        for (int i = 0; i < this.x.length; i++) {
            if (board[this.x[i]][this.y[i]] != 'X') {
                return false;
            }
        }
        return true;
    }
}

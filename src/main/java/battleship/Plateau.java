package battleship;

public class Plateau {

    private int width;
    private int height;
    private int[][] board;

    public Plateau(int width, int height, int[][] board) {
        this.width = width;
        this.height = height;
        this.board = board;
    }

    public Plateau(int[][] board) {
        this.board = board;
    }

    public Plateau(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[width][height];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void displayBoard(){
        for (int i = 0; i < height; i++){
            System.out.println();
            for (int j = 0; j < width; j++){
                System.out.print(0);
                System.out.print(" ");
                board[j][i] = 0;
            }
        }
    }
}
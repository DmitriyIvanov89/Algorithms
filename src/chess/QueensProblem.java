package chess;

public class QueensProblem {

    public static void main(String[] args) {

        QueensProblem Q = new QueensProblem(8);
        Q.callplaceNQueen();

    }

    int[] board;

    public QueensProblem(int N) {
        board = new int[N];
    }

    public boolean canPlaceQueens (int row, int column) {
        for (int i = 0; i < column; i++) {
            if (board[i] == row || (board[i] - i) == (row - column) || (board[i] + i) == (row + column)) {
                return false;
            }
        }
        return true;
    }

    public void placeQueen (int column, int n) {
        for (int row = 0; row < n; row++) {
            if (canPlaceQueens(row,column)) {
                board[column] = row;
                if (column == n - 1) {
                    print(board);
                } else {
                    placeQueen(column + 1, n);
                }
            }
        }
    }

    public void print (int[] board) {
        int N = board.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void callplaceNQueen () {
        placeQueen(0, board.length);
    }
}

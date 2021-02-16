package chess;

public class QueensProblem {

    public static void main(String[] args) {

        QueensProblem Q = new QueensProblem(4);
        Q.callplaceQueen();

    }
    /*
    * Создаем одномерный массив из элементов, каждый из которых будет соответствовать одному из столбцов.
    * А значение каждого элемента будет соответствовать той горизонтали, в которой установлен ферзь.
    */
    int[] board;

    public QueensProblem(int N) {
        board = new int[N];
    }

    // Метод, проверяющий возможность установки ферзя в текущую клетку
    public boolean canPlaceQueens (int row, int column) {
        for (int i = 0; i < column; i++) {
            if (board[i] == row || (board[i] - i) == (row - column) || (board[i] + i) == (row + column)) {
                return false;
            }
        }
        return true;
    }
    /* Метод поиска с возвратом.
    * Если на столбце column не удалось поставить ферзя метод возвращается на предыдущий столбец
    * и устанавливает ферзя в другую позицию
    */
    public void placeQueen (int column, int N) {
        for (int row = 0; row < N; row++) {
            if (canPlaceQueens(row,column)) {
                board[column] = row;// ставим ферзя
                if (column == N - 1) {
                    print(board); // Выводит в консоль всю доску с решением
                } else {
                    placeQueen(column + 1, N);
                }
            }
        }
    }
    /* Метод, выводящий в консоль верные решения,
     * честно взято с просторов сети :D, но суть ясна:
     * если элемент массива i равен строке - печатаем "Q",
     * если нет - "* " - пустая клетка
     */
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
    // Вызов метода на весь массив (доску)
    public void callplaceQueen () {
        placeQueen(0, board.length);
    }
}

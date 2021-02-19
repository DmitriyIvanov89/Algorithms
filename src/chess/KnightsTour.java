package chess;

public class KnightsTour {

    static int N = 8;

    /* Метод, проверяющий принадлежность клетки [i][j] доске N * N
     * клетка [i][j] соотвествует ходу коня
     */
    public static boolean canMovieKnight (int i, int j, int sol[][]) {
        if (i >= 1 && i <= N && j >= 1 && j <= N && sol[i][j] == -1) {
            return true;
        }
        return false;
    }
    /* Метод, поиска решения, принимающий доску, клетку с текущем положением коня [i][j],
     * кол-во шагов коня, два массива, с координатами возможных ходов.
     */
    public static boolean knightTour (int sol[][], int i, int j, int step, int iMove[], int jMove[]) {
        if (step == N * N) return true; // если вся доска пройдена
        // Проходим по всем возможным ходам
        for (int k = 0; k < 8; k++) {
            int nextI = i + iMove[k];
            int nextJ = j + jMove[k];

            if (canMovieKnight(nextI,nextJ,sol)) {
                sol[nextI][nextJ] = step;
                if (knightTour(sol,nextI,nextJ,step + 1,iMove,jMove)) return true;
                sol[nextI][nextJ] = -1;
            }
        }
        return false;
    }

    public static boolean start() {
        // Инициализация доски
        int[][] sol = new int[N + 1][N + 1];
        // Заполнение доски значениями -1
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j<= N; j++) {
                sol[i][j] = -1;
            }
        }
        // Координаты 8ми возможных ходов коня из клетки [i][j]
        int[] iMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] jMove = {1, 2, 2, 1, -1, -2, -2, -1};
        // Ставим коня на начальную клетку
        sol[1][1] = 0;
        //
        if (knightTour(sol, 1, 1, 1, iMove, jMove)) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(sol[i][j] + "\t");
                }
                System.out.println();
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        start();

    }
}

package chess;

public class KnightsTour {

    public static void main(String[] args) {

        start();

    }

    static int N = 8;

    /* Метод, проверяющий принадлежность клетки [i][j] доске N * N
     * клетка [i][j] соотвествует ходу коня
     */
    public static boolean canPlaceKnight (int i, int j, int sol[][]) {
        if (i >= 0 && i < N && j >= 0 && j < N && sol[i][j] == -1) {
            return true;
        }
        return false;
    }
    /* Метод, поиска решения, принимающий доску, клетку с текущем положением коня [i][j],
     * кол-во шагов коня, два массива, с координатами возможных ходов.
     */
    public static boolean knightMove (int sol[][], int i, int j, int step, int iMove[], int jMove[]) {
        if (step == N * N)
            return true; // если вся доска пройдена
        // Проходим по всем возможным ходам
        for (int k = 0; k < 8; k++) {
            int nextI = i + iMove[k];
            int nextJ = j + jMove[k];

            if (canPlaceKnight(nextI,nextJ,sol)) {
                sol[nextI][nextJ] = step; // запоминаем ход
                if (knightMove(sol,nextI,nextJ,step + 1,iMove,jMove)) // проверяем следующий ход step + 1
                    return true;
                sol[nextI][nextJ] = -1; // указываем, что данный ход не приводит к решению
            }
        }
        return false;
    }

    public static boolean start() {
        // Инициализация доски
        int[][] sol = new int[N][N];
        // Заполнение доски значениями -1
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }
        // Координаты 8ми возможных ходов коня из клетки [i][j]
        int[] iMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] jMove = {1, 2, 2, 1, -1, -2, -2, -1};
        // Ставим коня на начальную клетку
        sol[0][0] = 0;
        // вызов метода с начальной клетки sol[][]
        if (knightMove(sol, 0, 0, 1, iMove, jMove)) {
            // при успешном решении, выводим # хода в консоль
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(sol[i][j] + "\t");
                }
                System.out.println();
            }
            return true;
        }
        return false;
    }
}

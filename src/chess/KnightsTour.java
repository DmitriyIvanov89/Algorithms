package chess;

public class KnightsTour {
    public static void main(String[] args) {

        start();

    }
    static int N = 8;

    public static boolean canMovieKnight (int i, int j, int sol[][]) {
        if (i >= 1 && i <= N && j >= 1 && j <= N && sol[i][j] == -1) {
            return true;
        }
        return false;
    }

    public static boolean knightTour (int sol[][], int i, int j, int step, int iMove[], int jMove[]) {
        if (step == N * N) return true;

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
        int[][] sol = new int[N + 1][N + 2];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j<= N; j++) {
                sol[i][j] = -1;
            }
        }

        int[] iMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] jMove = {1, 2, 2, 1, -1, -2, -2, -1};

        sol[1][1] = 0;

        if (knightTour(sol, 1, 1, 1, iMove, jMove)) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(sol[i][j] + "\t");
                }
                System.out.println("\n");
            }
            return true;
        }
        return false;
    }
}

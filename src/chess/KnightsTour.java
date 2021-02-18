package chess;

public class KnightsTour {
    public static void main(String[] args) {


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

    
}

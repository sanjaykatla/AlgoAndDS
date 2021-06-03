package array;

public class MaxCoins {

    public static void main(String[] args) {
        final MaxCoins maxCoins = new MaxCoins();
        int[][] arr = {
                {0, 3, 1, 1},
                {2, 0, 0, 4},
                {1, 5, 3, 1},
        };

        System.out.println(maxCoins.collect(arr));
    }

    private int collect(int[][] arr) {

        int M = arr.length;
        int N = arr[0].length;
        for (int i = 1; i < N; i++) {
            arr[0][i] = arr[0][i] + arr[0][i - 1];
        }
        for (int j = 1; j < M; j++) {
            arr[j][0] = arr[j - 1][0] + arr[j][0];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                arr[i][j] = arr[i][j] + Math.max(arr[i - 1][j], arr[i][j - 1]);
                printArray(arr);
            }
        }

        return arr[M - 1][N - 1];
    }

    private void printArray(int[][] arr) {
        int N = arr[0].length;

        for (int[] ints : arr) {
            for (int j = 0; j < N; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

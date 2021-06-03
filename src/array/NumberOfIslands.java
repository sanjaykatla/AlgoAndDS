package array;

public class NumberOfIslands {

    public static void main(String[] args){
        final NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numberOfIslands.numIslands(grid));
    }

    public int numIslands(char[][] grid) {

        int result = 0;
        int M = grid.length;
        int N = grid[0].length;
        boolean[][] visited = new boolean[M][N];
        for(int i=0; i< M; i++){
            for(int j=0; j<N; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    System.out.println("visiting: "+ i+" - "+ j);
                    DFS(M,N,i,j,grid, visited);
                    result++;
                }
            }
        }
        return result;
    }

    private void DFS(int M, int N, int row, int col, char[][] grid, boolean[][] visited){
        visited[row][col] = true;

        int[] rowI = { -1,  0, 0,  1};
        int[] colI = { 0, -1, 1, 0};

        for(int k = 0; k<4; k++){
            final int row1 = row + rowI[k];
            final int col1 = col + colI[k];
            if(validAndUnvisited(M, N, row1, col1, grid, visited)){
                System.out.println("visiting: "+ row1+" : "+ col1);
                DFS(M, N, row1, col1, grid, visited);
            }
        }
    }

    private boolean validAndUnvisited(int M, int N, int row, int col, char[][] grid, boolean[][] visited){

        return row >= 0 && row < M && col >= 0 && col < N && grid[row][col] == '1' && !visited[row][col];
    }
}

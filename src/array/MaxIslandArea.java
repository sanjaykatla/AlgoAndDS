package array;

public class MaxIslandArea {

    private int[][] grid;
    private int M;
    private int N;

    public static void main(String[] args){

        int[][] input = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0}
                ,{0,0,0,0,0,0,0,1,1,1,0,0,0}
                ,{0,1,1,0,1,0,0,0,0,0,0,0,0}
                ,{0,1,0,0,1,1,0,0,1,0,1,0,0}
                ,{0,1,0,0,1,1,0,0,1,1,1,0,0}
                ,{0,0,0,0,0,0,0,0,0,0,1,0,0}
                ,{0,0,0,0,0,0,0,1,1,1,0,0,0}
                ,{0,0,0,0,0,0,0,1,1,0,0,0,0}};


        final MaxIslandArea maxIslandArea = new MaxIslandArea();
        System.out.println(System.currentTimeMillis());
        System.out.println(maxIslandArea.maxAreaOfIsland(input));
        System.out.println(System.currentTimeMillis());
    }

    public int maxAreaOfIsland(int[][] grid) {

        this.grid = grid;

        int result = 0;
        M = grid.length;
        N = grid[0].length;

        for( int i = 0; i < M; i++){
            for(int j=0; j<N;j++){
                result = Math.max(result, DFSUtil(i, j));
            }
        }
        return result;
    }

    private int DFSUtil(int i, int j){

        if(!isValid(i,j) || grid[i][j] != 1){
            return 0;
        }

        grid[i][j] = 0;
        return 1 + DFSUtil(i-1, j) + DFSUtil(i, j-1) + DFSUtil(i, j+1) + DFSUtil(i+1, j);
    }

    private boolean isValid(int i, int j){
        if( i>=0 && i< M && j >=0 && j < N){
            return true;
        }
        return false;
    }
}

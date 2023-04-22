package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueen {

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.solveNQueens(4);
    }

    private List<List<String>> solveNQueens(int n){

        List<List<String>> result = new ArrayList<>();

        char[][] b = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                b[i][j] = '.';
            }
        }
        solveNQueens(b, 0, result);

        for(List<String> ans: result){
            for(String line: ans){
                System.out.println(line);
            }
            System.out.println();
        }

        return result;
    }

    private void solveNQueens(char[][] b, int row, List<List<String>> result){

        if(row == b.length){
            result.add(construct(b));
            return;
        }

        for(int col=0; col<b.length;col++){
            boolean canPlace = canPlace(b, row, col);
            System.out.println("row: "+row+" col: "+ col+" Can place :"+canPlace);
            if(canPlace){
                b[row][col] = 'Q';
                solveNQueens(b, row+1, result);
                b[row][col] = '.';
            }
        }

    }

    private List < String > construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    private boolean canPlace(char[][] b, int row, int col){

        int n= b.length;
        for(int j=0; j<n; j++){
            if(b[row][j] == 'Q') return false;
        }

        for(int i=0; i<n; i++){
            if(b[i][col] == 'Q') return false;
        }

        int r = row;
        int c = col;

        while(r >=0 && c >=0 ){
            if(b[r][c] == 'Q') return false;
            r--;
            c--;
        }

        r = row;
        c = col;
        while(r >=0 && c < n ){
            if(b[r][c] == 'Q') return false;
            r--;
            c++;
        }

        return true;
    }
}

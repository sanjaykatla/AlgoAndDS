package array;

import java.util.Arrays;

public class MaxNumberOfCoins {
    public int maxCoins(int[] piles) {

        int result = 0;

        Arrays.sort(piles);

        int start = 0;
        int end = piles.length -1;

        while (end - start > 1){
            result += piles[--end];
            start++;
            end--;
        }

        return result;
    }
}

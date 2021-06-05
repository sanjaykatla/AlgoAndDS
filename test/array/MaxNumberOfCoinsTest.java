package array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxNumberOfCoinsTest {

    @Test
    public void testCase1(){
        final MaxNumberOfCoins numberOfCoins = new MaxNumberOfCoins();
        int[] input = {2, 4, 1, 2, 7, 8};
        final int result = numberOfCoins.maxCoins(input);

        assertEquals(9, result);
    }

    @Test
    public void testCase2(){
        final MaxNumberOfCoins numberOfCoins = new MaxNumberOfCoins();
        int[] input = {9,8,7,6,5,1,2,3,4};
        final int result = numberOfCoins.maxCoins(input);

        assertEquals(18, result);
    }

    @Test
    public void testCase3(){
        final MaxNumberOfCoins numberOfCoins = new MaxNumberOfCoins();
        int[] input = {7,5,7,7,8,8,5,10,7};
        final int result = numberOfCoins.maxCoins(input);

        assertEquals(22, result);
    }
}

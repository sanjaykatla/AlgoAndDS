package array;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ArithmaticSubArrayTest {

    @Test
    public void testCase1() {
        final ArithmaticSubArray asA = new ArithmaticSubArray();
        final int[] nums = {4, 6, 5, 9, 3, 7};
        final int[] l = {0, 0, 2};
        final int[] r = {2, 3, 5};
        final long start = System.currentTimeMillis();
        final List<Boolean> result = asA.checkArithmeticSubarrays(nums, l, r);
        final long end = System.currentTimeMillis();
        System.out.println("Time Complexity: "+ (end-start));

        Assert.assertTrue(result.get(0));
        Assert.assertFalse(result.get(1));
        Assert.assertTrue(result.get(2));
    }

    @Test
    public void testCase2() {
        final ArithmaticSubArray asA = new ArithmaticSubArray();
        final int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        final int[] l = {0,1,6,4,8,7};
        final int[] r = {4,4,9,7,9,10};
        final long start = System.currentTimeMillis();
        final List<Boolean> result = asA.checkArithmeticSubarrays(nums, l, r);
        final long end = System.currentTimeMillis();
        System.out.println("Time Complexity: "+ (end-start));

        Assert.assertFalse(result.get(0));
        Assert.assertTrue(result.get(1));
        Assert.assertFalse(result.get(2));
        Assert.assertFalse(result.get(3));
        Assert.assertTrue(result.get(4));
        Assert.assertTrue(result.get(5));
    }
}

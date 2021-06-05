package array;

import java.util.Arrays;
import java.util.List;

public class ArithmaticSubArray {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        Boolean[] result = new Boolean[l.length];

        for (int i = 0; i < l.length; i++) {
            result[i] = checkSubArray(nums, l[i], r[i]);
        }

        return Arrays.asList(result);

    }

    private Boolean checkSubArray(int[] nums, int l, int r) {

        int length = r - l + 1;
        int max = nums[l];
        int min = nums[l];

        for (int i = l; i <= r; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        // if all numbers are same
        if (max == min) {
            return Boolean.TRUE;
        }

        // checking if the numder evenly spaced
        if ((max - min) % (length - 1) != 0) {
            return Boolean.FALSE;
        }

        int d = (max - min) / (length - 1);

        boolean[] numbersFound = new boolean[r - l + 1];

        for (int i = l; i <= r; i++) {
            int num = nums[i] - min;
            if (num % d != 0 || numbersFound[num / d]) {
                return Boolean.FALSE;
            }
            numbersFound[num / d] = true;
        }
        return Boolean.TRUE;
    }
}

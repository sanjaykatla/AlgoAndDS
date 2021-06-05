package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArithmaticSubArray {

    private int[] nums;
    private int[] l;
    private int[] r;
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        this.nums = nums;
        this.l = l;
        this.r = r;


        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int start = l[i];
            int end = r[i];

            List<Integer> list = new ArrayList<Integer>();
            for (int j = start; j <= end; j++) {
                list.add(nums[j]);
            }
            Collections.sort(list);

            int diff = list.get(1) - list.get(0);
            boolean diffMatched = true;
            for (int j = 2; j < list.size(); j++) {
                if (list.get(j) - list.get(j - 1) != diff) {
                    diffMatched = false;
                    break;
                }
            }
            result.add(diffMatched);
        }

        return result;
    }
}

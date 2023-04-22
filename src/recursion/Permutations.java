package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static void main(String[] args) {

        int[] nums = {1,2,3};
        // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        List<List<Integer>> result = new ArrayList<>();

        permute(nums, 0, result);

        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static void permute(int[] nums, int i, List<List<Integer>> result) {

        if(i == nums.length){
            List<Integer> permuation = new ArrayList<>();
            Arrays.stream(nums).forEach(permuation::add);
            result.add(permuation);
        }

        for(int j = i; j< nums.length; j++){
            swap(nums, i, j);
            permute(nums, i+1, result);
            swap(nums, i, j);

        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}

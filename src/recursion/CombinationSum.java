package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        int[] arr = {2, 3, 6, 7};
        int target = 7;

//        output = { {2, 2, 3}, {7}}


        List<List<Integer>> result = new ArrayList<>();
        combSum(arr, 0, target, result, new ArrayList<>());

        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static void combSum(int[] arr, int i, int target, List<List<Integer>> result, List<Integer> ds){

        if(i == arr.length){
            if(target == 0){
                result.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[i] <= target){
            ds.add(arr[i]);
            combSum(arr, i, target-arr[i], result, ds);
            ds.remove(ds.size() - 1);
        }
        combSum(arr, i+1, target, result, ds);
    }
}

package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsets {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};

        List<List<Integer>> result = new ArrayList<>();
        subsets(arr, 0, result, new ArrayList<>());

        for(int i=0; i < result.size(); i++){
            for(int j=0; j< result.get(i).size(); j++){
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    private static void subsets(int[] arr, int i, List<List<Integer>> subsets, List<Integer> subset){

        if(i == arr.length){
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subsets(arr, i+1, subsets, subset);

        subset.add(arr[i]);
        subsets(arr, i+1, subsets, subset);
        subset.remove(subset.size()-1);
    }
}

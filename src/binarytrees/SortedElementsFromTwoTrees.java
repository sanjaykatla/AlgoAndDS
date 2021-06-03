package binarytrees;

import java.util.ArrayList;
import java.util.List;

public class SortedElementsFromTwoTrees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        final List<Integer> inOrder1 = new ArrayList<>();
        final List<Integer> inOrder2 = new ArrayList<>();

        inOrderTrav(root1, inOrder1);
        inOrderTrav(root2, inOrder2);

        final List<Integer> result = new ArrayList<>();

        int size1 = inOrder1.size();
        int size2 = inOrder2.size();

        int i = 0;
        int j = 0;

        while( i < size1 && j < size2) {
            int e1 = inOrder1.get(i);
            int e2 = inOrder2.get(j);

            if(e1 < e2 ){
                result.add(e1);
                i++;
            } else {
                result.add(e2);
                j++;
            }
        }

        if( i == size1){
            for(int k = j; k < size2; k++){
                result.add(inOrder2.get(k));
            }
        }

        if( j == size2){
            for(int k = i; k < size1; k++){
                result.add(inOrder1.get(k));
            }
        }

        return result;
    }

    private void inOrderTrav(TreeNode node, List<Integer> result) {

        if( node == null){
            return;
        }
        inOrderTrav(node.left, result);
        result.add(node.val);
        inOrderTrav(node.right, result);
    }
}

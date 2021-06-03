package binarytrees;

import java.util.LinkedList;
import java.util.List;

public class SortedElementsFromTwoTrees {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        final LinkedList<Integer> temp = new LinkedList<>();
        final List<Integer> result = new LinkedList<>();

        inOrderTrav(root1, temp);
        inOrderAndSort(root2, temp, result);

        if( !temp.isEmpty()){
            result.addAll(temp);
        }


        return result;
    }

    private void inOrderTrav(TreeNode node, List<Integer> temp) {

        if( node == null){
            return;
        }
        inOrderTrav(node.left, temp);
        temp.add(node.val);
        inOrderTrav(node.right, temp);
    }

    private void inOrderAndSort(TreeNode node, LinkedList<Integer> temp, List<Integer> result ) {
        if( node == null ){
            return;
        }
        inOrderAndSort(node.left, temp, result);

        while(!temp.isEmpty() && temp.peek() < node.val){
            result.add(temp.pop());
        }
        result.add(node.val);
        inOrderAndSort(node.right, temp, result);
    }
}

package trees;


import java.util.Map;
import java.util.HashMap;

public class VerticalSum{

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }


    public static void main(String[] args){

        //build tree

        Map<Integer, Integer> verticalSum = new HashMap<Integer, Integer>();
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        Node node3 = new Node(3);
        Node node6 = new Node(6);

        root.left = node2;
        node2.left = node4;
        node2.right = node5;
        root.right = node3;
        node3.left = node7;
        node3.right = node6;
        node7.right = new Node(1);

        inorderTraversal(root, verticalSum, 0);

        for(Map.Entry<Integer, Integer> entry : verticalSum.entrySet()){
            System.out.println(entry.getKey() +" -> "+entry.getValue());
        }
    }

    private static void inorderTraversal(Node root, Map<Integer, Integer> verticalSum, int vLine){

        if(root == null){
            return;
        }

        if(root.left != null){
            inorderTraversal(root.left, verticalSum, vLine-1);
        }

        verticalSum.merge(vLine, root.data, Integer::sum);

        if(root.right != null){
            inorderTraversal(root.right, verticalSum, vLine+1);
        }
    }
}

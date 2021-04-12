package trees;

import java.util.Queue;
import java.util.LinkedList;

public class TreeMaxWidth {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static void main(String[] args){

        Node root = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        node4.left = node5;
        node4.right = node6;
        node5.left = node7;


        System.out.println("Max width: "+maxWidth(root));
    }

    private static int maxWidth(Node root){

        if(root == null){
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int maxWidth = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int len = q.size();
            if(maxWidth < len){
                maxWidth = len;
            }

            while (len > 0) {
                Node node = q.remove();

                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                len--;
            }
        }
        return maxWidth;
    }
}

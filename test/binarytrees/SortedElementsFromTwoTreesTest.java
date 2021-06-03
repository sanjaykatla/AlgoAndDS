package binarytrees;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SortedElementsFromTwoTreesTest {

    @Test
    public void testCase1(){
        final SortedElementsFromTwoTrees sortedElementsFromTwoTrees = new SortedElementsFromTwoTrees();
        final TreeNode treeNode2 = new TreeNode(2);
        final TreeNode treeNode1 = new TreeNode(1);
        final TreeNode treeNode4 = new TreeNode(4);

        final TreeNode treeNode21 = new TreeNode(1);
        final TreeNode treeNode0 = new TreeNode(0);
        final TreeNode treeNode3 = new TreeNode(3);

        treeNode2.left = treeNode1;
        treeNode2.right = treeNode4;

        treeNode21.left = treeNode0;
        treeNode21.right = treeNode3;

        final List<Integer> allElements = sortedElementsFromTwoTrees.getAllElements(treeNode2, treeNode21);
        final StringBuffer result = getResultString(allElements);
        Assert.assertEquals("0 1 1 2 3 4 ", result.toString());
    }

    @Test
    public void testCase2(){
        //  [0,-10,10], root2 = [5,1,7,0,2]
        final SortedElementsFromTwoTrees sortedElementsFromTwoTrees = new SortedElementsFromTwoTrees();
        final TreeNode treeNode0 = new TreeNode(0);
        final TreeNode treeNodem10 = new TreeNode(-10);
        final TreeNode treeNode10 = new TreeNode(10);

        final TreeNode treeNode5 = new TreeNode(5);
        final TreeNode treeNode1 = new TreeNode(1);
        final TreeNode treeNode7 = new TreeNode(7);
        final TreeNode treeNode20 = new TreeNode(0);
        final TreeNode treeNode2 = new TreeNode(2);

        treeNode0.left = treeNodem10;
        treeNode0.right = treeNode10;

        treeNode5.left = treeNode1;
        treeNode5.right = treeNode7;
        treeNode1.left = treeNode20;
        treeNode1.right = treeNode2;

        final List<Integer> allElements = sortedElementsFromTwoTrees.getAllElements(treeNode0, treeNode5);
        final StringBuffer result = getResultString(allElements);
        Assert.assertEquals("-10 0 0 1 2 5 7 10 ", result.toString());
    }

    private StringBuffer getResultString(List<Integer> allElements) {
        final StringBuffer result = new StringBuffer();
        allElements.stream()
                .map(String::valueOf)
                .forEach(e -> result.append(e).append(" "));
        return result;
    }
}

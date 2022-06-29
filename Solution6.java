import java.util.*;


/**
 * DO NOT modify the class/method headers.
 **/
public class Solution6 {
    public static class TreeNode {
        int value;
        List<TreeNode> children;

        public TreeNode(int value) {
            this.value = value;
            children = new ArrayList<>();
        }

        public void addChildren(TreeNode... children) {
            this.children.addAll(Arrays.asList(children));
        }
    }


     public int sumOfQualifiedValues(TreeNode root, int min, int max) {
     if(root == null) {
     return 0;
     }

     int sum = 0;
     if(root.value >= min && root.value <= max) {
     sum += root.value;
     }
     int numOfChildren = root.children.size();
     if(numOfChildren > 0) {
     for(int i = 0; i<numOfChildren; i++) {
     sum += sumOfQualifiedValues(root.children.get(i), min, max);
     }
     }
     return sum;
     }


    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);


        TreeNode node2 = new TreeNode(2);
        node2.addChildren(node3, node4);
        TreeNode node5 = new TreeNode(5);
        node5.addChildren(node6, node7);
        TreeNode node8 = new TreeNode(8);

        TreeNode node1 = new TreeNode(1);
        node1.addChildren(node2, node5, node8);
        Solution6 solution = new Solution6();

        System.out.println(solution.sumOfQualifiedValues(node1, 3, 5)); // Should print 12

        System.out.println(solution.sumOfQualifiedValues(node2, 3, 5)); // Should print 7
    }
}
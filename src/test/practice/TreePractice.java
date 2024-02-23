//import org.junit.Test;
//
//public class TreePractice {
//
//    @Test
//    public void t() {
//        TreeNode node = initNode();
//    }
//
//    private TreeNode initNode() {
//        TreeNode node = new TreeNode(4);
//
//        TreeNode l1 = new TreeNode(2);
//        TreeNode ll1 = new TreeNode(1);
//        TreeNode ll2 = new TreeNode(3);
//
//        l1.left = ll1;
//        l1.right = ll2;
//        node.left = ll1;
//
//        TreeNode r1 = new TreeNode(7);
//        TreeNode rr1 = new TreeNode(6);
//        TreeNode rr2 = new TreeNode(9);
//
//        r1.left = rr1;
//        r1.right = rr2;
//        node.right = r1;
//
//        return node;
//    }
//}
//
//
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//
//

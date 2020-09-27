package SuanFa;

public class InvertTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = null;
        root.right = right;
        invertTree(root);
        System.out.println("12312");
    }


    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left != null){
            root.right = invertTree(left);
        }else {
            root.right = null;
        }
        if(right != null){
            root.left = invertTree(right);
        }else {
            root.left = null;
        }
        return root;
    }
}

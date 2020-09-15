package SuanFa;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = right;
        right.left = left;

        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lists = new ArrayList<>();
        if(root == null){
            return lists;
        }
        List<Integer> list = inorderTraversal(root.left);
        List<Integer> list1 = inorderTraversal(root.right);
        lists.addAll(list);
        lists.add(root.val);
        lists.addAll(list1);

        return lists;

    }
}

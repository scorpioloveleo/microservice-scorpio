package SuanFa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        binaryTreePaths(root);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return null;
        }
        Integer val = root.val;
        List<String> leftList = new ArrayList();
        if(null == root.left){
            leftList = binaryTreePaths(root.left);
        }
        List<String> rightList = new ArrayList();
        if(null == root.right){
            rightList = binaryTreePaths(root.right);
        }

        List<String> lists = new ArrayList<>();
        for (String str:leftList) {
            String s = val + str;
            lists.add(s);
        }

        for (String str:rightList) {
            String s = val + str;
            lists.add(s);
        }
        return lists;
    }
}

package SuanFa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IsBalanced {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String strDate2 = dtf2.format(now);
        System.out.println(strDate2);
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        if(root.left == null && root.right == null){
            return true;
        }
        int left = 0;
        int right = 0;

        if(root.left != null){
            left = height(root.left);
        }

        if(root.right != null){
            right = height(root.right);
        }
        int result = 0;
        if(left > right){
            result = left -right;
        }else {
            result = right - left;
        }
        if( result<=1){
           //进行子树判断
            boolean balanced = isBalanced(root.left);
            if(balanced){
                boolean balanced1 = isBalanced(root.right);
                return balanced1;
            }else {
                return false;
            }
        }
        return false;
    }

    public static int height(TreeNode root) {
        int left = 1;
        int right = 1;
        if(root == null){
            return 0;
        }

        if(root.left!=null){
            left = 1 + height(root.left);
        }
        if(root.right!=null){
            right = 1 + height(root.right);
        }
        if(left > right){
            return left;
        }
        return right;
    }
}

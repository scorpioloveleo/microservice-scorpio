package SuanFa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

import static java.util.TimeZone.*;

public class MinCameraCover {
    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(0);
        TreeNode right = new TreeNode(0);
        TreeNode leftleft = new TreeNode(0);
        TreeNode leftright = new TreeNode(0);
        root.left = left;
        root.right = right;
        root.left.left =leftleft;
        root.left.right = leftright;
        int jisuan = minCameraCover(root);
        System.out.println(jisuan);*/
        System.out.println(TimeZone.getTimeZone("GMT+08:00"));
        System.out.println(LocalDateTime.now());
        System.out.println(new Date());
    }

    public static int minCameraCover(TreeNode root) {
        if(root == null){
            return 0;
        }
        anjiankong(root);
        /**
         * 计算个数
         */
        int jisuan = jisuan(root);

        return jisuan;
    }
    
    public static void anjiankong(TreeNode root){

        //dfs 1 代表监控，2代表被监控
        boolean flag = false;
        TreeNode left = root.left;
        TreeNode right = root.right;

        if(left != null){
            anjiankong(left);
            if(left.val == 0){
                //应该安监控
                flag = true;
            }
        }

        if(right != null){
            anjiankong(right);
            if(left.val == 0){
                //应该安监控
                flag = true;
            }
        }

        if(flag){
            root.val = 1;
            if(left!=null && left.val == 0){
                left.val = 2;
            }
            if(right!=null && right.val == 0){
                right.val = 2;
            }
        }
    }

    /**
     * 计算
     */
    public static int jisuan(TreeNode root){
        if(root == null){
            return 0;
        }
        int n = 0;
        if(root.val == 1){
            n++;
        }
        int jisuan1 = jisuan(root.left);
        int jisuan2 = jisuan(root.right);
        return n+jisuan1+jisuan2;
    }
}

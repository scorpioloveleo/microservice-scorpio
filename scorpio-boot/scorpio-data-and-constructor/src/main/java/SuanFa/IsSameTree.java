package SuanFa;

public class IsSameTree {
    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(1);
        p1.left = p2;
        p1.right = p3;

        TreeNode q1 = new TreeNode(1);
        TreeNode q2 = new TreeNode(1);
        TreeNode q3 = new TreeNode(2);
        q1.left = q2;
        q1.right = q3;

        System.out.println(isSameTree(p1,q1));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        boolean sameTree = isSameTree(p.left, q.left);
        if(sameTree){
            return isSameTree(p.right, q.right);
        }else {
            return sameTree;
        }
    }
}

package SuanFa;

public class lowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        root.left = left;

        System.out.println(lowestCommonAncestor(root,root,left).val);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //确定顺序
        if(p.val > q.val){
            TreeNode treeNode = p;
            p = q;
            q = treeNode;
        }
        if(root  == null){
            return null;
        }
        //左子树
        if(p.val<root.val && q.val<root.val && root.left != null){
            return lowestCommonAncestor(root.left, p ,q);
        }

        //右子树
        if(p.val>root.val && q.val>root.val && root.right != null){
            return lowestCommonAncestor(root.right, p ,q);
        }

        //左右子树
        if(p.val <= root.val && q.val >= root.val){
            return root;
        }
        return null;
    }

}

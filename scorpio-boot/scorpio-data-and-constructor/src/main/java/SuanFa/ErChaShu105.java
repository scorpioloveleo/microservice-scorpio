package SuanFa;
public class ErChaShu105 {


    /*public static void main(String[] args) {

    }

    // 前序遍历 preorder = [3,9,20,15,7]
    //中序遍历 inorder = [9,3,15,20,7]
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        //找出所有前序遍历的树

        //找出根
        TreeNode root = new TreeNode();


    }

    public static TreeNode bTree(int[] preorder, int[] inorder){
        if(preorder.length<1){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1 ){
            //root.left = new TreeNode(inorder[0]);
           // root.right = new TreeNode(inorder[0]);
            return root;
        }
        //根据root分左孩子数组，和右孩子数组
        //1.找到可能的root
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[0]){
                //判断该数字是否是根
                if(){

                }
                //区分左右孩子
                int[] left = {};
                int[] right = {};
                System.arraycopy(inorder, 0, left, 0, i);
                System.arraycopy(inorder, i+1, right, 0, inorder.length - i -1);
                TreeNode treeNode = bTree(left, right);
                break;
            }
        }
        return  treeNode;

    }

    public static int[] jiequshuzu(int[], from){

    }*/

}

class TreeNode {
      Integer val;
      TreeNode left;
      TreeNode right;
      TreeNode(Integer x) { val = x; }
}

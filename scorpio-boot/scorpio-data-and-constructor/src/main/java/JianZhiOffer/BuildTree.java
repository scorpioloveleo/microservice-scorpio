package JianZhiOffer;


import BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    public static void main(String[] args) {

    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     *
     *
     * 例如，给出
     *
     * 前序遍历 preorder = [3,9,15,7,20,5,6]
     * 中序遍历 inorder = [15,9,7,3,5,20,6]
     *
     * 返回如下的二叉树：
     *
     *           3
     *        /    \
     *       9     20
     *     /  \   /  \
     *    15  7  5    6
     *
     *
     *
     * 限制：
     *
     * 0 <= 节点个数 <= 5000
     *
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> indexMap  = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {

        }

        //获取root结点
        int root = preorder[0];
        int length = inorder.length;
        int preorderStart = 0;
        int preorderEnd = 0;
        int inorderEnd = 0;
        int inorderStart = 0;
        //已知根节点，分左右子树
        for (int i = 0; i < length; i++) {
            if(root == inorder[i]){
               // build();
            }
        }

        return null;
    }

    public int build(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap){

        return 0;
    }
}

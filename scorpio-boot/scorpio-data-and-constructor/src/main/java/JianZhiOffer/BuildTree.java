package JianZhiOffer;


import java.util.*;

public class BuildTree {

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,15,7,20,5,6};
        int[] inorder = new int[]{15,9,7,3,5,20,6};
        int[] preorder1 = new int[]{1,2};
        int[] inorder2 = new int[]{2,1};
        TreeNode treeNode1 = buildTree(preorder1, inorder2);
        //TreeNode treeNode = buildTree(preorder, inorder);
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
     * 3 9 20
     * 9 3 20
     *
     * 3 9 15
     * 3 9 15
     *
     * 3 9 7
     * 9 7 3
     *
     * 限制：
     *
     * 0 <= 节点个数 <= 5000
     *
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> indexMap  = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            //将前序遍历队列放入其中 key = 值 value = index
            indexMap.put(preorder[i], i);
        }

        //获取root结点
        int preorderLength = preorder.length;
        int inorderLength = inorder.length;
        int preorderStart = 0;
        int preorderEnd = preorderLength-1;
        int inorderStart = 0;
        int inorderEnd = inorderLength-1;

        TreeNode build = build(preorder, preorderStart, preorderEnd, inorder, inorderStart, inorderEnd, indexMap);

        return build;
    }

    public static TreeNode build(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap){
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        if(preorder.length == 1 || inorder.length == 1){
            return new TreeNode(preorder[0]);
        }

        //循环到可以构建子树的时候
        //找到root
        TreeNode root = new TreeNode(preorder[preorderStart]);

        int leftPreorderStart = 0;
        int leftPreorderEnd = 0;
        int leftInorderStart = 0;
        int leftInorderEnd = 0;

        int rightPreorderStart = 0;
        int rightPreorderEnd = 0;
        int rightInorderStart = 0;
        int rightInorderEnd = 0;


        //找到中序遍历的左右子树的范围
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if(inorder[i] == preorder[preorderStart]){

                leftInorderStart =  inorderStart;
                leftInorderEnd = i-1;

                rightInorderStart = i+1;
                rightInorderEnd = inorderEnd;
                break;
            }
        }


        //构建左子树
        TreeNode left = null;
        int i1 = leftInorderEnd - leftInorderStart;
        if( i1 == 0){
            //证明是可以组树
            left = new TreeNode(inorder[leftInorderStart]);

        }else if(i1 > 0){
            //左边的元素谁是root?，在preorder里面第一个出现的就是root
            Integer leftRootIndex = preorderEnd;//最大的index
            for (int i = leftInorderStart; i <= leftInorderEnd; i++) {
                //左子树
                int temp = indexMap.get(inorder[i]);
                if(temp < leftRootIndex){
                    leftRootIndex = temp;
                }
            }
            /**
             * * 前序遍历 preorder = [3,9,15,7,20,5,6]
             *      * 中序遍历 inorder = [15,9,7,3,5,20,6]
             */
            //找到前序遍历的左子树的范围
            //证明是root结点,计算preorder中左子树的位置
            leftPreorderStart =leftRootIndex;
            leftPreorderEnd = leftPreorderStart+i1;

            left =  build(preorder, leftPreorderStart, leftPreorderEnd, inorder, leftInorderStart, leftInorderEnd, indexMap);
        }


        //构建右子树
        TreeNode right = null;
        int i2 = rightInorderEnd - rightInorderStart;
        if( i2 == 0){
            //证明是可以组树
            right = new TreeNode(inorder[rightInorderEnd]);

        }else if(i2 > 0) {
            //右边边的元素谁是root?，在preorder里面第一个出现的就是root
            Integer rightRootIndex = preorderEnd;
            for (int i = rightInorderStart; i <= rightInorderEnd; i++) {
                //左子树
                int temp = indexMap.get(inorder[i]);
                if(temp < rightRootIndex){
                    rightRootIndex = temp;
                }
            }
            //找到前序遍历的右子树的范围
            rightPreorderStart =rightRootIndex;
            rightPreorderEnd = rightPreorderStart+i2;

            right =  build(preorder, rightPreorderStart, rightPreorderEnd, inorder, rightInorderStart, rightInorderEnd, indexMap);
        }
        if(i1>=0){
            root.left = left;
        }

        if(i2>=0){
            root.right = right;
        }

        return root;
    }



}

 class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode(Integer x) { val = x; }
}

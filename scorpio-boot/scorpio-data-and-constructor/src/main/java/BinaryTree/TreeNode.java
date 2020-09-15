package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      public TreeNode(int x) { val = x; }


    //递归调用 前序遍历
      public List<Integer> preorderTraversal(TreeNode root){
          if(root == null){
              return null;
          }

          List<Integer> left = preorderTraversal(root.left);
          List<Integer> right = preorderTraversal(root.right);
          List<Integer> integers = new ArrayList<>();
          integers.add(root.val);
          if(left  != null){
              integers.addAll(left);
          }
          if(right  != null){
              integers.addAll(right);
          }

          return integers;
      }


    //递归调用 后序遍历
    public List<Integer> afterorderTraversal(TreeNode root){
        List<Integer> integers = new ArrayList<>();
        if(root == null){
            return null;
        }

        if(root.left != null){
            List<Integer> leftReturn = afterorderTraversal(root.left);
            if(leftReturn != null){
                integers.addAll(leftReturn);
            }
        }

        if(root.right != null){
            List<Integer> rightReturn = afterorderTraversal(root.right);
            if(right != null){
                integers.addAll(rightReturn);
            }
        }

        integers.add(root.val);

        return integers;
    }
    //迭代 中序遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
          List<Integer> list = new ArrayList<>();
        TreeNode cur =root;

         /* while (cur != null || cur.){
              while(){

                  cur = cur.
              }
              //
          }*/

        return null;
    }

    //是否是平衡二叉树
    boolean isBalanced(TreeNode root) {
          int lh = 0;
          int rh = 0;
          boolean isBalanced = true;
          boolean isBinary = true;
        if(root == null){
            return false;
        }
        rh = height(root.right);
        lh = height(root.left);
        int i = rh - lh;
        if(i>1 || i<-1){
            isBalanced = false;
        }
        /*List<Integer> list = inorderTraversal(root);
        int pre =list.get(0);
        for (Integer cur:list
             ) {
             if(cur < pre){
                 isBinary = false;
                 break;
             }
             pre = cur;
        }*/
        /*if(isBalanced && isBinary){
            return true;
        }*/
        return isBalanced;
    }

    //计算高度
    int height(TreeNode root){
          int h = 0;
          int leftHeight = 0;
          int rightHeight = 0;
        if(root == null){
          return h;
        }
        h++;
        if(root.left!=null){
            leftHeight = height(root.left);
        }

        if(root.right!=null){
            rightHeight = height(root.right);
        }
        if(leftHeight > rightHeight){
            return h+leftHeight;
        }
        return h+rightHeight;
    }

    //递归调用 中序遍历
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> integers = new ArrayList<>();
        if(root == null){
            return null;
        }

        if(root.left != null){
            List<Integer> leftReturn = inorderTraversal(root.left);
            if(leftReturn != null){
                integers.addAll(leftReturn);
            }
        }
        integers.add(root.val);


        if(root.right != null){
            List<Integer> rightReturn = inorderTraversal(root.right);
            if(rightReturn != null){
                integers.addAll(rightReturn);
            }
        }

        return integers;
    }
}

class TreeNodeTest{

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(1);
        root.left = null;
        TreeNode node1 = new TreeNode(2);
        root.right = node1;
        TreeNode node2 = new TreeNode(3);
        node1.left = node2;
        List<Integer> list = root.preorderTraversal(root);
        System.out.println(list.toString());

        List<Integer> list1 = root.inorderTraversal(root);
        System.out.println(list1);

        List<Integer> list2 = root.afterorderTraversal(root);
        System.out.println(list2);*/

        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left=node3;
        node2.right=node4;

        List<Integer> list1 = root.inorderTraversal(root);
        System.out.println(list1);

        boolean balanced = root.isBalanced(root);
        System.out.println(":  "+balanced);
    }

}

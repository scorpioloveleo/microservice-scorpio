package com.scorpio.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。



 示例：

 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 *
 */

public class TestOp {

    public static void main(String[] args) {
        //int[] test = {-8,1,2,3,4};
        TreeNode root = new TreeNode(1);
        /*root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);*/
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List<String> stringList = serialize(root);
        String serStr = "[";
        for (String str:stringList) {
            if(serStr.equals("[")){
                serStr = serStr +str;
            }else {
                serStr = serStr+","+str;
            }
        }
        serStr = serStr+"]";
        System.out.println("序列化的string: " + serStr);

        /**
         * 反序列化
         */
        TreeNode rdeserialize = rdeserialize(stringList);
        System.out.println(rdeserialize.val);
        System.out.println(rdeserialize.left.val);
        /*System.out.println(rdeserialize.left.left.val);
        System.out.println(rdeserialize.left.right.val);*/
        System.out.println(rdeserialize.right.val);
    }

    public static List<String> serialize(TreeNode root) {
        //先序遍历
        List<String> stringList = preorderTraversal(root);


        //serialize(root.left);
        return stringList;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        //
        return null;
    }



    /**
     * 先序遍历
     */
    public static List<String> preorderTraversal(TreeNode root){
        List<String> integers = new ArrayList<>();

        if(root == null){
            integers.add("None");
            return integers;
        }

        List<String> left = preorderTraversal(root.left);
        List<String> right = preorderTraversal(root.right);
        integers.add(root.val+"");
        if(left  != null){
            integers.addAll(left);
        }
        if(right  != null){
            integers.addAll(right);
        }

        return integers;
    }
    /**
     * 根据先序遍历的string重构treeNode
     */
    public static TreeNode rdeserialize(List<String> l) {
        /**
         *
         */
        if(l.get(0).equals("None")){
           l.remove(0);
           return null;
       }


        return null;
    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



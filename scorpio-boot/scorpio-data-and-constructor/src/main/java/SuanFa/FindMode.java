package SuanFa;

import java.util.*;

public class FindMode {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(9);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(7);
        treeNode.right.right = new TreeNode(5);
        findMode(treeNode);
    }
    public static int[] findMode(TreeNode root) {

        Map<Integer, Integer> maps = new HashMap<>();
        bianli(root, maps);

        //找到最多的次数
        Set<Map.Entry<Integer, Integer>> entries = maps.entrySet();
        int times = -1;
        for (Map.Entry<Integer, Integer> entry:
             entries) {
            if(entry.getValue()>times){
                times = entry.getValue();
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry:
                entries) {
            if(entry.getValue() == times){
                list.add(entry.getKey());
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    /**
     * 遍历
     */
    public static void bianli(TreeNode root, Map<Integer, Integer> maps) {
        if(root == null){
            return;
        }
        //放入root
        boolean exist = maps.containsKey(root.val);
        if(exist){
            maps.put(root.val, maps.get(root.val)+1);
        }else {
            maps.put(root.val, 1);
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        if(left != null){
            bianli(left, maps);
        }
        if(right != null){
            bianli(right, maps);
        }
    }
}

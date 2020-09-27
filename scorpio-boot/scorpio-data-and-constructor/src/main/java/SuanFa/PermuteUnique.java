package SuanFa;

import java.util.*;

public class PermuteUnique {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        List<List<Integer>> lists = permuteUnique(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList();
        if(length == 0){
            return res;
        }
        // 排序
        Arrays.sort(nums);

        /**
         * 元素是否使用
         */
        boolean[] used = new boolean[length];
        Stack<Integer> list = new Stack<>();
        dfs(nums, length, 0, used, list, res);

        return res;
    }

    public static void dfs(int[] nums, int len, int depth, boolean[] used, Stack<Integer> list, List<List<Integer>> res){
        if(depth == len){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < len; i++) {
            if(used[i]){
                continue;
            }

            //剪枝叶 排序的意义, used[i-1] == false 代表同一深度结点, used[i-1] == true，代表不同深度的结点
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            list.push(nums[i]);
            used[i] = true;
            dfs(nums, len, depth+1, used, list, res);
            //撤销
            used[i] = false;
            list.pop();
        }
    }


    /**
     * 正解
     * @param nums
     * @return
     */

    public List<List<Integer>> permuteUnique2(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 排序（升序或者降序都可以），排序是剪枝的前提
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        // 使用 Deque 是 Java 官方 Stack 类的建议
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs2(nums, len, 0, used, path, res);
        return res;
    }

    private void dfs2(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; ++i) {
            if (used[i]) {
                continue;
            }

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;

            dfs2(nums, len, depth + 1, used, path, res);
            // 回溯部分的代码，和 dfs 之前的代码是对称的
            used[i] = false;
            path.removeLast();
        }
    }

}

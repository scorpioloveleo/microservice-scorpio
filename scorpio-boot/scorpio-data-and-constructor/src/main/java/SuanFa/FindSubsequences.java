package SuanFa;

import java.util.ArrayList;
import java.util.List;

public class FindSubsequences {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        List<List<Integer>> subsequences = findSubsequences(nums);
        for (List<Integer> list:subsequences) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        nums.clone();
        //构造2个元素的升序列
        int length = nums.length;
        List<List<Integer>> lists = new ArrayList<>();

        int last = -1;
        for (int i = 0; i < length-1; i++) {
            int[] byIndex = getByIndex(i, nums);
            buchong( lists, byIndex, nums[i+1]);
            for (List<Integer> list:lists) {
                System.out.println(list);
            }
            System.out.println("----------------");
        }

        return lists;
    }

    public static void buchong(List<List<Integer>> lists, int[] num, int n){
        //能不能在之前的序列进行添加
        int size = lists.size();
        for (int i = 0; i < size; i++) {
            List<Integer> list = lists.get(i);

            if(list.size()>=15){
                continue;
            }
            //获取最大的数
            Integer last = list.get(list.size() - 1);
            if(n >= last){
                ArrayList<Integer> objects = new ArrayList<>();
                objects.addAll(list);
                objects.add(n);
                //有一种情况不能添加
                if(num[num.length -1] == n && last !=n){
                    continue;
                }

                if(num[num.length -1] == n && last ==n){
                    //num[i]重复超过3次也不添加
                    int t =0;
                    for (int j = 0; j < num.length; j++) {
                        if(num[j] == n){
                            t++;
                        }
                    }
                    if(t>2){
                        continue;
                    }
                }
                lists.add(objects);
            }
        }
        //以之前的为起点，新的数字为终点的序列
        for (int i = 0; i < num.length; i++) {
            if(num[i] <= n){
                ArrayList<Integer> objects = new ArrayList<>();
                objects.add(num[i]);
                objects.add(n);
                //已经存在该数字不能添加
                boolean check = true;
                for (int j = 0; j < lists.size(); j++) {
                    if(lists.get(j).size() != 2){
                        continue;
                    }
                    if(lists.get(j).get(0)!=num[i]){
                        continue;
                    }
                    if(lists.get(j).get(1) ==n){
                        check = false;
                    }

                }
                if(check){
                    lists.add(objects);
                }
            }
        }
    }

    public static int[] getByIndex(int i, int[] nums){
        int[] ints = new int[i+1];
        for (int j = 0; j <= i; j++) {
            ints[j] = nums[j];
        }
        return ints;
    }



}

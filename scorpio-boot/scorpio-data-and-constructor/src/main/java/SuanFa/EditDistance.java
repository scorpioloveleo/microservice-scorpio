package SuanFa;

import java.util.Arrays;

public class EditDistance {

    public static void main(String[] args) {
        int[] dp = new int[]{2, 7, 11, 15};
        int[][] editdistance = editdistance("adex", "adcde");
        System.out.println(Arrays.deepToString(editdistance));
    }

    static int[][] editdistance(String str1, String str2){
        int str1L = str1.length();
        int str2L = str2.length();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        //每一步的抉择有4种 0:跳过 1:添加 2:删除 3:替换
        int[][] dp = new int[str1L+1][str2L+1]; //最多进行str2L步就可以解决题目
        //初始化
        for (int i = 0; i <=str1L ; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= str2L; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= str1L; i++) {
            for (int j = 1; j <= str2L; j++) {
                if(chars1[i-1] == chars2[j-1]){
                    //跳过
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                //替换 删除 添加
                dp[i][j] =Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1 ;
            }
        }
        //System.out.println(dp[str1L][str2L]);
        return dp;//[str1L][str2L];
    }

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] back = {};
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                int sum = nums[i]+nums[j];
                if(sum == target){
                    back = new int[]{i,j};
                }
            }
        }
        return back;
    }
}

package SuanFa;

import java.util.Date;

public class CoinsChange {

    public static void main(String[] args) {
        int i = coinsChange(3, new int[]{1,2,3});
        System.out.println(i);
    }

    public static int coinsChange(int amount, int[] coins){
        //dp[i][j] 从1开始
        int[][] dp = new int[coins.length + 1][amount+1];
        // base dp
        for (int i = 0; i <= coins.length ; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount ; j++) {
                if(j - coins[i-1]>=0){
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[coins.length][amount];
    }
}

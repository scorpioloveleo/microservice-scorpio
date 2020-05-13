package SuanFa;

import java.util.Arrays;

public class trapEggs {
    public static void main(String[] args) {
        System.out.println(trapEggggs(10, 100));
        System.out.println("----------"+eggDropDP(10, 100));
    }

    //错误答案，没有写出来，心态炸裂，以后有机会再看这道题。
    public static int trapEggggs(int k, int n){
        int[][] dp = new int[k+1][n+1];
        //base
        for (int i = 0; i <= n ; i++) {
            dp[1][i] = i;
        }
        for (int i = 1; i <= k ; i++) {
            dp[i][0] = 0;
        }
        //从第1层开始
        for (int j = 1; j <= k ; j++) {
            for (int i = 1; i <= n ; i++) {
                //min = Math.min(min , dp[k][i] = Math.max(dp[k-1][i-1], dp[k][n-i])+1) ;
                dp[j][i] = n;
                for (int p = 1; p <= n; p++) { //从p层楼开始抛
                    dp[j][i] = Math.min(dp[j][i], Math.max(dp[j-1][p-1], dp[j][n-p])+1);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[k][n];
    }

    //正确答案
    public static int eggDropDP(int n, int k){
        /* A 2D table where entery dp[i][j] will represent minimum
           number of trials needed for i eggs and j floors. */
        int[][] dp = new int[n+1][k+1];

        // We need one trial for one floor and0 trials for 0 floors
        for(int i=1; i<=n; i++){
            dp[i][1] = 1;
            dp[i][0] = 0;
        }
        // We always need j trials for one egg and j floors.
        for(int j=1; j<=k; j++){
            dp[1][j] = j;
        }
        // Fill rest of the entries in table using optimal substructure
        // property
        for(int i=2; i<=n; i++){         // i eggs
            for(int j=2; j<=k; j++){ // j floors
                dp[i][j] = Integer.MAX_VALUE;
                for(int x=1; x<=j; x++){ // try every floor from 1...j
                    int res = 1 + Math.max(dp[i-1][x-1], dp[i][j-x]);
                    dp[i][j] = Math.min(dp[i][j], res);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][k];
    }
}

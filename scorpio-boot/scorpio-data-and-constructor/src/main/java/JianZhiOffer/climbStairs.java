package JianZhiOffer;

public class climbStairs {

    public static void main(String[] args) {
        numWays(0);
    }

    public static int numWays(int n) {

        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        /**
         * 构造dp
         */
        int[] dp = new int[n+1];
        if(n>2){
            dp[1] =1;
            dp[2] =2;
            for (int i = 3; i < n+1; i++) {
                dp[i] = (dp[i-1]+dp[i-2])%1000000007;
            }
        }
        return dp[n];
    }

    public static int numWays1(int n) {
        int[] dp = new int[n+1];
        dp[0] =0;
        dp[1] =1;
        dp[2] =2;

        if(n <= 2){
            return dp[n];
        }
        /**
         * 计算
         */
        for (int i = 1; i <= n; i++) {
            //dp[i] = dp[]
        }
        return (numWays(n - 1)  + numWays(n - 2) )%1000000007;
    }

}

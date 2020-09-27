package JianZhiOffer;

public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(cuttingRope(9));
    }

    //动态规划解法
    public static int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if(n < 2){
            return dp[n];
        }
        for (int i = 2; i <= n; i++) {
            dp[i] = -1;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max( j*(i - j), j*dp[i-j]), dp[i]);
            }
        }
        return dp[n];
    }

}

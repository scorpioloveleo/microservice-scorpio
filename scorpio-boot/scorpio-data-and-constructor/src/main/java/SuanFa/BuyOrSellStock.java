package SuanFa;

import java.util.*;

public class BuyOrSellStock {

    public static void main(String[] args) {
        int day = 5;
        int k = 1;
        int[] stack = {2,5,3,9,1};
        int[] stack3 = {2,9,8,1,7};


        int ints = buyOrsell(stack);
        System.out.println(ints);
        int ints2 = buyOrsell2(stack);
        System.out.println(ints2);
        int ints3 = buyOrsell3(stack3);
        System.out.println(ints3);
        int ints4 = buyOrsell4(stack3, 2);
        System.out.println(ints4);
        //System.out.println(Arrays.deepToString(ints));
        //

    }


    public static int buyOrsell(int[] stack){

        /**
         * 当k等于1时，即交易次数固定为1
         */
        //初始化dp
        int[][] dp = new int[stack.length+1][2];
        dp[0][1] = 0;
        dp[0][0] = 0;
        dp[1][1] = -2;
        dp[1][0] = 0;

        for (int i = 2; i <= stack.length; i++) {
            dp[i][1] = Math.max(-stack[i-1], dp[i-1][1]);
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+stack[i-1]);
        }
        return dp[stack.length][0];
    }

    public static int buyOrsell2(int[] stack){

        /**
         * 当k等于时，即交易次数不固定
         */
        //初始化dp
        int[][] dp = new int[stack.length][2];
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < stack.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(temp, dp_i_1+stack[i]);
            dp_i_1 = Math.max(temp-stack[i], dp_i_1);
        }
        return dp_i_0;
    }

    public static int buyOrsell3(int[] stack){

        /**
         * 当k等于时，即交易次数不固定，但是sell之后需要隔一天才能buy.
         */
        //初始化dp
        int[][] dp = new int[stack.length+1][2];
        dp[0][1] = 0;
        dp[0][0] = 0;
        dp[1][1] = -2;
        dp[1][0] = 0;
        dp[2][1] = -5;
        dp[2][0] = 0;

        for (int i = 2; i <= stack.length; i++) {
            dp[i][1] = Math.max(dp[i-2][0]-stack[i-1], dp[i-1][1]);
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+stack[i-1]);
        }
        return dp[stack.length][0];
    }

    public static int buyOrsell4(int[] stack, int k){

        /**
         * 当k等于任意整数时，即交易次数固定为某一个整数时的时候
         */
        //初始化dp
        int[][][] dp = new int[stack.length][k+1][2];

        for (int i = 0; i < stack.length; i++) {
            if(i- 1 == -1){
                dp[0][1][0]= 0;
                dp[0][0][0]= 0;
                dp[0][1][1]= -2;
                dp[0][0][1]= Integer.MIN_VALUE;
                continue;
            }
            for (int j =1; j <=k; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]+stack[i]);
                dp[i][j][1] = Math.max(dp[i-1][j-1][0]-stack[i], dp[i-1][j][1]);
            }
        }
        return dp[stack.length-1][k][0];
    }
}

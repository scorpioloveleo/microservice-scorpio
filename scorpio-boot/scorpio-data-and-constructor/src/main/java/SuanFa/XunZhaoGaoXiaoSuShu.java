package SuanFa;

import java.util.Arrays;

public class XunZhaoGaoXiaoSuShu {

    public static void main(String[] args) {
        count1(9000000);
    }

    //
    public static int count1(int n){
        //int[] do = new dp[];
        int count = 0;
        for (int i = 2;  i<= n; i++) {
            boolean prime = isPrime(i);
            if(prime){
                System.out.println(": "+i);
                count++;
            }
        }
        return count;
    }

    public static boolean isPrime(int value){
        for (int i = 2; i*i < value; i++) {
            if (value%i == 0){
                return false;
            }
        }
        return true;
    }

    public static int count2(int n){
        boolean[] isPrime = new boolean[n];
        //初始化
        Arrays.fill(isPrime, true);
        int count = 0;
        //后面的非素数都会在循环到它之前设置为false;
        for (int i = 2;  i*i< n; i++) {
            if(isPrime[i]){
                for (int j = i*i; j <n; j+=i) {
                    //1,2,3,4,5
                    isPrime[j] = false;
                }
            }
        }
        //计算true个数就好
        //todo
        return count;
    }
}

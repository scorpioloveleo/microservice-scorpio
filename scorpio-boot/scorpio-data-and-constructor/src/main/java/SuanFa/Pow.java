package SuanFa;

public class Pow {

    public static void main(String[] args) {

        System.out.println(3/2);
        System.out.println(-3/2);

        //System.out.println(myPow(34.00515, -3));
        System.out.println(myPow2(2.00000,-2147483648));
        System.out.println(myPow3(2.00000,-2147483648));

    }

    /*public static double myPow(double x, int n) {
        long N = n;
        return N>0 ? result(x, N) : 1.0/result(x, -N);

    }*/
    //超时
    public static double result1(double x, int n){
        double result = 1.0;
        for (int i = 0; i < n; i++) {
            result = result*x;
        }
        return result;
    }

    //减少循环
    public static double result(double x, int n){
        if(n == 0){
            return 1.0;
        }
        double y = n<0?1.0/result(x, -n/2):result(x, n/2);
        return n%2 == 0 ? y*y: y*y*x;
    }

    public static double myPow2(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        double y = n<0?myPow2(x, -n/2):myPow2(x, n/2);
        double result =  n%2 == 0 ? y*y: y*y*x;
        return n<0?1.0/result:result;
    }

    //正解
    public static double myPow3(double x, long n) {
        if(n == 0){
            return 1.0;
        }
        double y = n<0?myPow3(x, -n/2):myPow3(x, n/2);
        double result =  n%2 == 0 ? y*y: y*y*x;
        return n<0?1.0/result:result;
    }
}

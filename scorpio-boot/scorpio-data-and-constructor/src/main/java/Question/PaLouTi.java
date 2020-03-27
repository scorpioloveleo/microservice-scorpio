package Question;

public class PaLouTi {

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }


    public static int climbStairs(int n) {
        if(n<0) return -1;
        if(n<=2) return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }



}

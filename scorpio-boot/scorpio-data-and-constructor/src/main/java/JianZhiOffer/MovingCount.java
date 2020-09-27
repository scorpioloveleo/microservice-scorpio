package JianZhiOffer;

public class MovingCount {

    public static void main(String[] args) {
        int i = movingCount(2, 3, 1);
        System.out.println(i);
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] used = new boolean[m][n];
        return count(used, m, n, 0, 0, k);
    }

    public static int count(boolean[][] used, int m, int n, int x, int y, int k){
        if(x<0 || x>=m || y<0 || y>=n || jisuan(x, y)>k || used[x][y]){
            return 0;
        }
        int total = 0;
        //是否计算
        total++;
        used[x][y] = true;

        total = total+count(used, m, n, x-1, y, k)+count(used, m, n, x+1, y, k)+count(used, m, n, x, y-1, k)+count(used, m, n, x, y+1, k);
        return total;
    }

    public static int jisuan(int n, int m){
        return (n/100 + n / 10 % 10 + n % 10) +(m/100 + m / 10 % 10 + m % 10);
    }
}

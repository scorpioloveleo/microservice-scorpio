package SuanFa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerBreak {

    public static void main(String[] args) {
        int n = 3;
        int a = integerBreak2(n);
        System.out.println(a);
       /*int[] ar = new int[]{2,2,2,2,9};
        int[] jiaozheng = jiaozheng(ar);
        System.out.println(Arrays.toString(jiaozheng));*/
    }




        public static int integerBreak2(int n) {
            if(n==2){
                return 1;
            }
            int b = n;
            int max = 0;
            List<Integer> lists = new ArrayList<>();
            for (int i = 2; i < n; i++) {
                int sqrt = n/i;
                int sum = 1;
                int temp = n;
                /**
                 * 特殊情况
                 */
                if((n - i*sqrt)>=(i-1)){
                    sqrt++;
                }
                //拆成i个数字
                for (int j = 0; j < i; j++) {
                    if( j == i-1){
                        //最后一次不操作直接
                        sum = sum * temp;
                        lists.add(temp);
                        System.out.println("乘以: " + temp+" 等于 "+ sum);
                    }else {
                        temp = temp-sqrt;
                        sum = sum*sqrt;
                        lists.add(sqrt);
                        System.out.println("乘以: " + sqrt+" 等于 "+ sum);
                    }
                }
                if(sum > max){
                    max = sum;
                    lists.clear();
                    System.out.println("----------------------");
                }else {
                    break;
                }
            }
             //拼数组
            int[] nums = new int[lists.size()];
            for (int i = 0; i < lists.size(); i++) {
                nums[i] = lists.get(i);
            }

            int[] jiaozheng = jiaozheng(nums);
            System.out.println(Arrays.toString(jiaozheng));
            int max1 = 1;
            for (int i = 0; i < jiaozheng.length; i++) {
                max1 = max1*jiaozheng[i];
            }
            return max1;
        }

    /**
     * 矫正的方法
     */
    public static int[] jiaozheng(int[] array){
        /**
         * 检查是否梯次递增
         */
        for (int i = array.length-1; i >0 ; i--) {
            int i1 = array[i] - array[i - 1];
            if(array[i]>array[i-1] && i1>=2){
                /**
                 * 计算需要分给其他数字多少
                 */
                int aad = 1;
                /*if(i1 - array.length >0){
                    aad = i1/(array.length - 1);
                    if(i1>(array.length -1)){
                        aad++;
                    }
                }*/
                for (int j = i-1; j >=0; j--) {
                    array[j]+=aad;
                    array[i]-=aad;
                    if(array[i] - aad<array[i-1]){
                        break;
                    }
                    if(i1 == 0){
                        break;
                    }
                }
            }
        }

        if(array[array.length -1]-array[array.length -2]<2){
            return array;
        }else {
            jiaozheng(array);
        }
        return array;
    }


    public int integerBreak(int n) {
        if (n == 2 || n == 3) return n - 1;
        int num_3 = 0, num_2 = 0;
        while (n > 0) {
            n -= 3;
            ++num_3;
            if (n == 2) {
                num_2 = 1;
                break;
            }
            if (n == 1) {
                --num_3;
                num_2 = 2;
                break;
            }
        }
        double v = Math.pow(3, num_3) * Math.pow(2, num_2);
        return (int)v;

    }
}

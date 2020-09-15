package SuanFa;

public class MagicIndex {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2, 3, 4, 5,  6,7,8,10,11 ,12,15,17,27};
        int magicIndex = erfen(nums,27);
        System.out.println(magicIndex);
    }
//1 3 5   7   9 11 13  （7）           1 3 5   7 8  9 11 13 （8）
    public static int findMagicIndex(int[] nums) {
        int length = nums.length;
        boolean flag = true;
        int left = 0;
        int right = length;
        int mid = length/2;
        while (flag){
            if(nums[mid] == mid){
                flag = false;
            }else {
                if(nums[mid] > mid){
                    right = mid-1;
                }else {
                    left = mid;
                }
                mid = (left + right)/2;
            }
            System.out.println("left: num["+left+"] = "+nums[left]);
            System.out.println("right: num["+right+"] = "+nums[right]);
            System.out.println("-------------");
        }

        return nums[mid];
    }

    /**
     * 二分法
     */
    public static  int erfen(int[] nums, int n){
        int length = nums.length;
        boolean flag = true;
        int left = 0;
        int right = length - 1;
        int mid = length/2;
        while (flag){
            if(nums[mid] == n){
                flag = false;
            }else {
                if(nums[mid] > n){
                    right = mid-1;
                }else {
                    left = mid;
                }
                mid = (left + right)/2;
            }
            if(nums[right] == n){
                return right;
            }
        }
        return mid;
    }
}

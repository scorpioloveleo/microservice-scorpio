package SuanFa;

public class LognestHuiwen {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcdbbfcba"));
    }

    public static String longestPalindrome(String s){
        //每一个字符都有可能是中心点
        int length = s.length();
        char[] chars = s.toCharArray();
        //初始化
        String longest = "";
        for (int i = 0; i < length; i++) {
            String i1 = jisuanLong(chars, i + 1);
            if(longest.length()<i1.length()){
                longest = i1;
            }
        }
        return longest;
    }

    public static  String jisuanLong(char[] chars, int index){
        String long1 = String.valueOf(chars[index-1]);
        String long2 = "";
        int count1 = 1;
        int count2 = 0;
        int length = chars.length;

        //以该字符为中心
        int pre = index - 2;
        int next = index;
        if(index > length/2){
            for (int i = next; i < length; i++) {
                if(chars[i] == chars[pre--]){
                    count1+=2;
                    long1 = chars[i]+long1+chars[pre+1];
                }

                else
                    break;
            }
        }else {
            for (int i = pre; i >= 0 ; i--) {
                if(chars[i] == chars[next++]){
                    count1+=2;
                    long1 = chars[i]+long1+chars[next-1];
                }

                else
                    break;
            }
        }
        //以该字符为重复字符
        pre = index - 2;
        next = index;
        if(index<length){
            for (int i = pre+1; i >=0; i--) {
                if(chars[i] == chars[next++]){
                    count2+=2;
                    long2 = chars[i]+ long2 + chars[next-1];
                }else {
                    break;
                }
                if(next >= length){
                    break;
                }
            }
        }
        return count1>count2?long1:long2;
    }

}

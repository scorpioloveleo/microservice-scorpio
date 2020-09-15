package SuanFa;
//696
public class CountBinarySubstrings {

    public static void main(String[] args) {

        String str = "10101";
        char[] chars = str.toCharArray();
        int i = countBinarySubstrings(str);
        System.out.println(i);
    }
    
    public static int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            //以当前字符为第一个字符
            int curr = i;
            int first = 0;
            char fistrChar = chars[i];
            char secondChar = chars[i];
            int second = 0;

            int length = 0;


            while (curr < chars.length){
                if(fistrChar == chars[curr]){
                    first++;
                    length++;
                }else {
                    break;
                }
                curr++;
            }
            /**
             * 第一个的数量统计之后，进行数量的判断
             */
            if('0' == fistrChar){
                //第一个是0,那就算1
                secondChar = '1';
            }else {
                secondChar = '0';
            }
            /**
             * 计算第二个字符的数量
             */
            if(curr+length > chars.length){
                continue;
            }
            for (int j = curr; j < curr+length; j++) {
                if(secondChar == chars[j]){
                    second++;
                }else {
                    break;
                }
            }

            if(first!=0 && first == second){
                num++;
            }
        }
        return num;
    }
}

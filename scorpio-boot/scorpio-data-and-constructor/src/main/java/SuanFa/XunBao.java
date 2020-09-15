package SuanFa;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.sun.xml.internal.fastinfoset.util.CharArray;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class XunBao {

    private static final Logger log = LoggerFactory.getLogger(XunBao.class);

    public static void main(String[] args) {
       // shuzu(new String[]{"S#O", "M..", "M.T"});
        List<Map<String, Object>> cardInfoList = new ArrayList<>();
        Map<String, Object> stringObjectMap = new HashMap<>();
        stringObjectMap.put("bankCardNo", "2020062569164645");
        cardInfoList.add(stringObjectMap);
        if(cardInfoList != null && cardInfoList.size()>0){
            for (Map<String, Object> maps:cardInfoList) {
                String bankCardNo = (String)maps.get("bankCardNo");
                String encryptAccount = encryptBankAcct(bankCardNo, null);
                maps.put("bankCardNo", encryptAccount);
            }
        }

        for (Map<String, Object> maps:cardInfoList) {
            String bankCardNo = (String)maps.get("bankCardNo");
            System.out.println(bankCardNo);
        }


    }
    public static void esds(){
        throw new NullPointerException();
    }

    public static int minimalSteps(String[] maze) {
        char[][] shuzu = shuzu(maze);

        return 0;
    }

    private static String replaceBetween(String sourceStr, int begin, int end, String replacement) {
        if (sourceStr == null) {
            return "";
        }
        if (replacement == null) {
            replacement = "*";
        }
        int replaceLength = end - begin;
        if (StringUtils.isNotBlank(sourceStr) && replaceLength > 0) {
            StringBuilder sb = new StringBuilder(sourceStr);
            sb.replace(begin, end, StringUtils.repeat(replacement, replaceLength));
            return sb.toString();
        } else {
            return sourceStr;
        }
    }

    public static String encryptBankAcct(String sourceStr, String replacement) {
        if (sourceStr == null) {
            return "";
        }
        int begin = 6;
        int end = sourceStr.length() - 4;

        if (sourceStr == null) {
            return "";
        }
        if (replacement == null) {
            replacement = "*";
        }
        int replaceLength = end - begin;
        if (StringUtils.isNotBlank(sourceStr) && replaceLength > 0) {
            StringBuilder sb = new StringBuilder(sourceStr);
            sb.replace(begin, end, StringUtils.repeat(replacement, replaceLength));
            return sb.toString();
        } else {
            return sourceStr;
        }
    }

    //将String数组化
    public static char[][] shuzu(String[] maze) {
        int length = maze.length;
        int length1 = maze[0].length();
        char[][] str = new char[length][length1];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
                str[i][j] = maze[i].charAt(j);
            }
        }
        System.out.println(str.length);
        System.out.println(str[0].length);
        System.out.println(Arrays.deepToString(str));
        return str;
    }
    //判断墙壁#数量以及是否不可解
   public void tets(){

   }
    //判断

    /**
     * 最短路径，广度优先算法解析
     */
    public int shortestPath(int[][] grid, int k) {
        int length = grid.length;
        int length1 = grid[0].length;
        //构建地图
        int[][][] dp = new int[length][length1][k];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length1; j++) {
               // dp[][][] =
                //dp[i][j][k] = Math.min()
            }
        }
        return 0;
    }
}

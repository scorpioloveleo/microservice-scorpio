package JianZhiOffer;

import org.apache.commons.lang3.StringUtils;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 *
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 */
public class ReplaceSpace {
    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     *
     *
     * 例如，给出
     *
     * 前序遍历 preorder = [3,9,15,7,20,5,6]
     * 中序遍历 inorder = [15,9,7,3,5,20,6]
     *
     * 返回如下的二叉树：
     *
     *           3
     *        /    \
     *       9     20
     *     /  \   /  \
     *    15  7  5    6
     *
     *
     *
     * 限制：
     *
     * 0 <= 节点个数 <= 5000
     *
     */

    public static void main(String[] args) {
        String tihuan = tihuan("We are happy.");
        System.out.println(tihuan);
    }
    public static String tihuan(String s){
        char[] charTihuan = new char[3*s.length()];
        char[] chars = s.toCharArray();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char aChar = chars[i];
            if(aChar == ' '){
                charTihuan[index++] = '%';
                charTihuan[index++] = '2';
                charTihuan[index++] = '0';
            }else {
                charTihuan[index++] = aChar;
            }
        }
        return new String(charTihuan);
    }
    public String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

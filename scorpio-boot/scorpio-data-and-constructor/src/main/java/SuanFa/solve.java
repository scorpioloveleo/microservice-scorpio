package SuanFa;

import org.apache.commons.lang3.CharUtils;

import java.util.Arrays;

public class solve {
    public static void main(String[] args) {
        char[][] xx = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] xx1 = new char[][]{{},{},{}};
        if(xx1.length == 0 || xx1[0].length == 0){
            System.out.println("1111");
        }
        //solve(xx);
    }

    public static void solve(char[][] board) {
        //找到所有的靠边O
        int length = board.length;
        if(length == 0){
            return;
        }
        int kuan = board[0].length;
        if(kuan == 0){
            return;
        }
        //遍历
        for (int i = 0; i < kuan; i++) {
            //标记
            if(board[0][i] == 'O'){
                change(0, i, board, length, kuan);
            }

            if(board[length-1][i] == 'O'){
                change(length-1, i, board, length, kuan);
            }
        }

        for (int i = 0; i < length; i++) {
            //标记
            if(board[i][0] == 'O'){
                change(i, 0, board, length, kuan);
            }

            if(board[i][kuan-1] == 'O'){
                change( i, kuan-1, board, length, kuan);
            }
        }
        //完毕之后
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < kuan; j++) {
                if('O' == board[i][j]){
                    board[i][j] = 'X';
                }else if('#' == board[i][j]){
                    board[i][j] = 'O';
                }
            }
        }
        System.out.println(Arrays.deepToString(board));

    }

    //将边界相关的元素全部标#
    public static void change(int i, int j, char[][] board, int length, int kuan){
        if('#' == board[i][j] || 'X'==board[i][j]){
            return;
        }
        board[i][j] = '#';
        //上
        if(i-1>=0){
            change(i-1, j, board, length, kuan);
        }
        //下
        if(i+1<length){
            change(i+1, j, board, length, kuan);
        }
        //左
        if(j-1>=0){
            change(i, j-1, board, length, kuan);
        }
        //右
        if(j+1<kuan){
            change(i, j+1, board, length, kuan);
        }
    }
}

package JianZhiOffer;

import com.sun.org.apache.bcel.internal.generic.FADD;

public class Test {

    public static void main(String[] args) {
        //Integer i = 0;
        char[][] board = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        //char[][] board = new char[][]{{'a','b',},{'c','d'}};
        String word = "AAB";
        boolean exist = exist(board, word);
        System.out.println(exist);
    }

    public static boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        //boolean[][] used = new boolean[board.length][board[0].length];
        boolean circle = false;
        int step = 0;
        STOP:
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                circle = circle(board, word.toCharArray(), i, j, step);
                //if(board[i][j] == chars[step]){
                    //符合就在此基础上进行匹配
                    //used[i][j] = true;
                    //circle = circle(board, i, j, board.length, board[0].length, used, chars, step);

                    /*if(circle){
                        break STOP;
                    }*/
                    //used[i][j] = false;
                //}
            }
        }
        return  circle;
    }

    //direction 代表4个方向, 1向上, 2向下, 3向左, 4向右
    public static boolean circle(char[][] board, int positionX, int positionY, int bianjieX, int bianjieY, boolean[][] used, char[] words, int step){
        if(step == words.length -1){
            return true;
        }
        boolean isOk = false;

        //待匹配字段
        char word = words[step + 1];
        //4个方向,上方
        if(positionX-1>=0 && !used[positionX-1][positionY]){
            if(board[positionX-1][positionY] == word){
                used[positionX-1][positionY] = true;
                //上方已匹配
                isOk = circle(board, positionX-1, positionY, bianjieX, bianjieY, used, words, step + 1);
                if(isOk){
                    return isOk;
                }
                //回溯
                used[positionX-1][positionY] = false;
            }
        }

        //下
        if(positionX+1<bianjieX && !used[positionX+1][positionY]){
            if(board[positionX+1][positionY] == word){
                used[positionX+1][positionY] = true;
                //上方已匹配
                isOk = circle(board, positionX+1, positionY, bianjieX, bianjieY, used, words, step + 1);
                if(isOk){
                    return isOk;
                }
                //回溯
                used[positionX+1][positionY] = false;
            }
        }

        //左
        if(positionY-1>=0 && !used[positionX][positionY-1]){
            if(board[positionX][positionY-1] == word){
                used[positionX][positionY-1] = true;
                //上方已匹配
                isOk = circle(board, positionX, positionY-1, bianjieX, bianjieY, used, words, step+1);
                if(isOk){
                    return isOk;
                }
                //回溯
                used[positionX][positionY-1] = false;
            }
        }

        //右
        if(positionY+1<bianjieY && !used[positionX][positionY+1]){
            if(board[positionX][positionY+1] == word){
                used[positionX][positionY+1] = true;
                //上方已匹配
                isOk = circle(board, positionX, positionY+1, bianjieX, bianjieY, used, words, step+1);
                if(isOk){
                    return isOk;
                }
                //回溯
                used[positionX][positionY+1] = false;
            }
        }


        return isOk;
    }

    /**
     * 最好的答案
     */
    public static boolean circle(char[][] board, char[] word, int i, int j,  int step){
        if(i>=board.length || i<0 || j>=board[0].length||j<0 || word[step]!=board[i][j]){
            return false;
        }
        if(step == word.length -1){
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = circle(board, word, i + 1, j, step + 1) || circle(board, word, i - 1, j, step + 1) ||
                circle(board, word, i, j + 1, step + 1) || circle(board, word, i , j - 1, step + 1);
        board[i][j] = temp;
        return res;

    }
}

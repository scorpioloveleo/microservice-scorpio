package SuanFa;

import java.util.Arrays;

public class ShortestPath {

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        // shortestPath();
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

    /*public static int shortestPath(int[][] grid, int k) {

        return -1;
    }*/

    public int shortestPath(int[][] grid, int k) {
        int len = grid.length,col = grid[0].length;
        if (k >= len + col -3) return len+col-2;     //没有这句，超时
        boolean[][] visited = new boolean[len][col];  //避免dfs发生原路返回的情况
        int result = shortestPathDfs(grid,0,0,len,col,0,k,visited);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int shortestPathDfs(int[][] grid,int i,int j,int row,int col,int covered,int k,boolean[][] visited) {
        if (i < 0 || i >= row || j < 0 || j >= col) return Integer.MAX_VALUE; //递归出口
        if (i == row-1 && j == col-1) return covered;   //递归出口，结果
        if (visited[i][j]) return Integer.MAX_VALUE; //递归出口

        if (grid[i][j] == 1) {
            if (k > 0) k--;   //k做出牺牲，让1变为0
            else return Integer.MAX_VALUE; //k已经为0了，但是此块为1，则是一条死路
        }

        visited[i][j] = true;  //记录这条路径上这个节点已经访问过

        //取4个方向上可能路径的最小值返回
        int minOf4Dicrect = Integer.MAX_VALUE;
        minOf4Dicrect = Math.min(minOf4Dicrect,shortestPathDfs(grid,i-1,j,row,col,covered+1,k,visited));
        minOf4Dicrect = Math.min(minOf4Dicrect,shortestPathDfs(grid,i+1,j,row,col,covered+1,k,visited));
        minOf4Dicrect = Math.min(minOf4Dicrect,shortestPathDfs(grid,i,j+1,row,col,covered+1,k,visited));
        minOf4Dicrect = Math.min(minOf4Dicrect,shortestPathDfs(grid,i,j-1,row,col,covered+1,k,visited));

        visited[i][j] = false; //回溯
        return minOf4Dicrect;
    }

}

package SuanFa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //入度表,记录指该课程
        int[] indegree = new int[numCourses];
        List<List<Integer>> lists = new ArrayList();
        Queue<Integer> queue = new LinkedList<>();

        //初始化
        for (int i = 0; i < numCourses; i++) {
            lists.add(new ArrayList<Integer>());
        }

        //1.构建需要的数据结构
        for (int[] p:prerequisites) {
            //记录课程的入度值
            indegree[p[0]]++;
            //关联的课程
            lists.get(p[1]).add(p[0]);
        }
        //2.第一次将入度值为0的课程放入栈中
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        //将栈中的数据拿出进行
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            numCourses--;
            List<Integer> list = lists.get(poll);
            for (Integer integer:list) {
                //指向该课程的课程入度值--
                if(--indegree[integer] == 0){
                    queue.add(integer);
                }
            }
        }

        return numCourses == 0;

    }
}

import java.util.*;

public class Question207 {

    public static void main(String[] args) {

    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] container = new int[numCourses];
        List<List<Integer>> requisites = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            requisites.add(new ArrayList<>());
        }

        for (int[] clazz : prerequisites) {
            int need = clazz[1];
            int after = clazz[0];
            container[after]++;
            requisites.get(need).add(after);
        }

        boolean flag = true;//继续处理
        while (flag){
            flag = false;
            if (queue.isEmpty()){
                for (int i = 0; i < numCourses; i++) {
                    if (container[i] == 0){
                        queue.add(i);
                        container[i] = -1;
                        flag = true;
                    }
                }
            }else {
                Integer need = queue.poll();
                for (Integer data : requisites.get(need)){
                    container[data]--;
                }
                flag = true;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (container[i] > 0){
                return false;
            }
        }

        return true;
    }
}
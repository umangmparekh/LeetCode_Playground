package crowdstrike;

import java.util.*;

public class CourseScheduleFindOrder {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        // Step 1 : build adjacency list + in degree array
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int course = pre[0], prereq = pre[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        // Step 2:  seed queue with all courses that have no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0 ) queue.offer(i);
        }

        // Step 3 : BFS - process nodes, reduce neighbour in degrees
        int[] order = new int[numCourses];
        int idx = 0;

        while(!queue.isEmpty()){
            int course = queue.poll();
            order[idx++] = course;

            for(int next : adj.get(course)){
                indegree[next]--;
                if(indegree[next] == 0) queue.offer(next);
            }
        }

        // Step 4:  if we processed all courses, no cycle exists
        return idx == numCourses ? order : new int[0];

    }

    public static void main(String[] args){
        int n = 4;
        int[][] courses = new int[][]{{1,0},{2,0}, {3,1}, {3,2} };
        System.out.println(Arrays.toString(findOrder(n, courses)));

        int n1 = 2;
        int[][] courses1 = new int[][]{{1,0},{0,1}};
        System.out.println(Arrays.toString(findOrder(n1, courses1)));

        int n2 = 1;
        int[][] courses2 = new int[][]{};
        System.out.println(Arrays.toString(findOrder(n2, courses2)));

    }
}

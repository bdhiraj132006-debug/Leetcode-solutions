class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0; i < numCourses; i++)
        {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] p : prerequisites)
        {
            int course = p[0];
            int prereq = p[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
        {
            if(indegree[i] == 0)
            {
                queue.offer(i);
            }
        }

        int taken = 0;
        while(!queue.isEmpty())
        {
            int current = queue.poll();
            taken++;

            for(int next:graph.get(current))
            {
                indegree[next]--;
                if(indegree[next] == 0)
                {
                    queue.offer(next);
                }
            }
        }

        return taken == numCourses;
    }
}
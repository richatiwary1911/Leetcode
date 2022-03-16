class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer> graph[] = new ArrayList[numCourses];        
        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        
        int inDegree[] = new int[numCourses];
        for(int p[] : prerequisites)
        {
            graph[p[0]].add(p[1]);
            inDegree[p[1]] ++;
        }
        
        Queue<Integer> que = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++)
            if(inDegree[i] == 0)
                que.add(i);
        
        int count = 0;
        
        while(!que.isEmpty())
        {
            int rem = que.remove();
            count++;
            
            for(int nbr : graph[rem])
                if(--inDegree[nbr] == 0)
                    que.add(nbr);
        }
        return numCourses == count;
    }
}
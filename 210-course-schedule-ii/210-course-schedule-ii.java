class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer> graph[] = new ArrayList[numCourses];        
        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        
        int inDegree[] = new int[numCourses];
        for(int p[] : prerequisites)
        {
            graph[p[0]].add(p[1]);
            inDegree[p[1]] ++;
        }
        
        int idx = -1;
        int ans[] = new int[numCourses];
        
        Queue<Integer> que = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++)
            if(inDegree[i] == 0)
                que.add(i);
        
        int count = 0;
        
        while(!que.isEmpty())
        {
            int rem = que.remove();
            ans[numCourses - 1 - (++idx)] = rem;
            
            for(int nbr : graph[rem])
                if(--inDegree[nbr] == 0)
                    que.add(nbr);
        }
        return idx < numCourses - 1 ? new int[0] : ans;
        
    }
}
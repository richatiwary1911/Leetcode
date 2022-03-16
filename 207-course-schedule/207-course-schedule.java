class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //using Kahn's algo
        
//         ArrayList<Integer> graph[] = new ArrayList[numCourses];        
//         for(int i = 0; i < numCourses; i++)
//             graph[i] = new ArrayList<>();
        
//         int inDegree[] = new int[numCourses];
//         for(int p[] : prerequisites)
//         {
//             graph[p[0]].add(p[1]);
//             inDegree[p[1]] ++;
//         }
        
//         Queue<Integer> que = new LinkedList<>();
        
//         for(int i = 0; i < numCourses; i++)
//             if(inDegree[i] == 0)
//                 que.add(i);
        
//         int count = 0;
        
//         while(!que.isEmpty())
//         {
//             int rem = que.remove();
//             count++;
            
//             for(int nbr : graph[rem])
//                 if(--inDegree[nbr] == 0)
//                     que.add(nbr);
//         }
//         return numCourses == count;
 
//-----------------------------------------------------------------------------------------------------------------        
        //cycle detection using DFS
        ArrayList<Integer> graph[] = new ArrayList[numCourses];        
        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        
        //int inDegree[] = new int[numCourses];
        for(int p[] : prerequisites)
        {
            graph[p[0]].add(p[1]);
            //inDegree[p[1]] ++;
        }
        
        int state[] = new int[numCourses];
        List<Integer> path = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            if(state[i] == 0)
                dfs(graph, i, state, path);
        
        return path.size() == numCourses;
    }
    
    public boolean dfs(ArrayList<Integer> graph[], int src, int state[], List<Integer> path)
    {
        state[src] = 1;
        for(int nbr : graph[src])
        {
            if(state[nbr] == 1)
                return false;
            
            if(state[nbr] == 0)
                if(!dfs(graph, nbr, state, path)) return false;
        }
        state[src] = 2;
        path.add(src);
        return true;
    }
}
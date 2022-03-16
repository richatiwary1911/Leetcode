class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int indegree[][] = new int[n][m];
        int dirns[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
               for(int dir[] : dirns)
               {
                   int x = i + dir[0];
                   int y = j + dir[1];
                   
                   if(x >= 0 && y >= 0 && x < n && y < m && matrix[i][j] < matrix[x][y])
                       indegree[x][y]++;
               }
            }
        }
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(indegree[i][j] == 0)
                    que.add(i * m + j);
            }
        }
        int level = 0;
        while(!que.isEmpty())
        {
            int size = que.size();
            while(size-- > 0)
            {
                int rem = que.remove();
                int i = rem / m;
                int j = rem % m;
                
                for(int dir[] : dirns)
                {
                    int x = dir[0] + i;
                    int y = dir[1] + j;
                    
                    if(x >= 0 && y >= 0 && x < n && y < m && matrix[i][j] < matrix[x][y])
                        if(--indegree[x][y] == 0)
                            que.add(x * m + y);
                }
            }
            level ++;
        }
        return level;
    }
}
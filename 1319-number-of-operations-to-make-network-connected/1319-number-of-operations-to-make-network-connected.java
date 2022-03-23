class Solution {
    
    int parent[];
    int size[];
    
    public int makeConnected(int n, int[][] connections) {   

        if(n -1 > connections.length)
            return -1;
        
        parent = new int[n];
        size = new int[n];
        
        for(int i = 0; i < n; i++)
            parent[i] = i;
        
        for(int i = 0; i < n; i++)
            size[i] = 1;
        
        for(int edge[] : connections)
        {
            int u = edge[0];
            int v = edge[1];
            
            int p1 = findParent(u);
            int p2 = findParent(v);
            
            if(p1 != p2)
            {
                merge(p1, p2);
            }
        }
        
        int numberOfComponents = 0;
        for(int i = 0; i < n; i++)
            if(i == parent[i])  numberOfComponents++;
        
        return numberOfComponents - 1;        
    }
        
    public int findParent(int u)
    {
        return parent[u] == u ? u : (parent[u] = findParent(parent[u]));
    }
    
    public void merge(int u, int v)
    {
        if(size[u] >= size[v])
        {
            parent[v] = u;
            size[u] += size[v];
        }
        else
        {
            parent[u] = v;
            size[v] += size[u];
        }
    }
}
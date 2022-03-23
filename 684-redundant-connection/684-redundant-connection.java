class Solution {
    
    int parent[];
    int size[];
    
    public int[] findRedundantConnection(int[][] edges) {
        
        int n = edges.length;
        parent = new int[n + 1];
        size = new int[n + 1];
        
        for(int i = 1; i <= n; i++)
            parent[i] = i;
        
        for(int i = 1; i <= n; i++)
            size[i] = 1;
        
        for(int edge[] : edges)
        {
            int u = edge[0];
            int v = edge[1];
            
            int p1 = findParent(u);
            int p2 = findParent(v);
            
            if(p1 != p2)
            {
                merge(p1, p2);
            }
            else
            {
                return edge;  //coz it's a cycle
            }
        }
        return new int[0];
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
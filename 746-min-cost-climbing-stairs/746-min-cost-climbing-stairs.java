class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        // int n = cost.length;
        // return Math.min(rec(cost, n - 1), rec(cost, n -2));
        
        int n = cost.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        
        return Math.min(memo(cost, n - 1, dp), memo(cost, n - 2, dp));
    }
    
//     public int rec(int cost[], int n)
//     {
//         if(n == 0 || n == 1)
//             return cost[n];
        
//         if(n < 0)
//             return 0;
        
//         return Math.min(rec(cost, n - 1), rec(cost, n - 2)) + cost[n];
//     }
    
    public int memo(int cost[], int n, int dp[])
    {
        if(n == 0 || n == 1)
            return dp[n] = cost[n];
        
        if(n < 0)
            return 0;
        
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = Math.min(memo(cost, n - 1, dp), memo(cost, n - 2, dp)) + cost[n];
    }
}
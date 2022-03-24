class Solution {
    public int climbStairs(int n) {
        
        //return rec(n);    
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return memo(n, dp);
    } 
    
//     public int rec(int n)
//     {
//         if(n == 0)
//             return 1;
        
//         if(n < 0)
//             return 0;
        
//         return rec(n - 1) + rec(n - 2);
//     }
    
    public int memo(int n, int dp[])
    {
        if(n == 0)
            return dp[n] = 1;
        
        if(n < 0)
            return 0;
        
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = memo(n - 1, dp) + memo(n - 2, dp);
    }
}
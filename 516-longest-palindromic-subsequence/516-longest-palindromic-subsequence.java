class Solution {
    public int longestPalindromeSubseq(String s) {
       
        //return rec(s, 0, s.length() -1);
        
        int dp[][] = new int[s.length()][s.length()];
        for(int d[] : dp)
            Arrays.fill(d, -1);
        
        return memo(s, 0, s.length() - 1, dp);
    }
    
//     public int rec(String s, int i, int j)
//     {
//         if(i >= j)
//         {
//             if(i == j)
//                 return 1;
            
//             return 0;
//         }
        
//         int ans = 0;
        
//         if(s.charAt(i) == s.charAt(j))
//             ans += rec(s, i + 1, j - 1) + 2;
//         else
//             ans += Math.max(rec(s, i + 1, j), rec(s, i, j - 1));
        
//         return ans;
//     }
    
    public int memo(String s, int i, int j, int dp[][])
    {
        if(i >= j)
        {
            if(i == j)
                return dp[i][j] = 1;
            
            return dp[i][j] = 0;
        }
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int ans = 0;
        
        if(s.charAt(i) == s.charAt(j))
            ans += memo(s, i + 1, j - 1, dp) + 2;
        else
            ans += Math.max(memo(s, i + 1, j, dp), memo(s, i, j - 1, dp));
        
        return dp[i][j] = ans;
    }
}
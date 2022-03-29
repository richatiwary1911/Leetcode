class Solution {
    public int numDistinct(String s, String t) {
        
        //return rec(s, t, 0, 0);
        
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        for(int d[] : dp)
            Arrays.fill(d, -1);
        
        return memo(s, t, 0, 0, dp);
        
      
    }
    
//     public int rec(String s, String t, int i, int j)
//     {
//         if(i == s.length() || j == t.length())
//         {
//             if(j == t.length())
//                 return 1;
            
//             return 0;
//         }
        
//         int ans = 0;
//         if(s.charAt(i) == t.charAt(j))
//         {
//             ans += rec(s, t, i + 1, j + 1);
//             ans += rec(s, t, i + 1, j);
//         }
//         else
//             ans += rec(s, t, i + 1, j);
        
//         return ans;
//     }
    
    public int memo(String s, String t, int i, int j, int dp[][])
    {
        if(i == s.length() || j == t.length())
        {
            if(j == t.length())
                return dp[i][j] = 1;
            
            return dp[i][j] = 0;
        }
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int ans = 0;
        if(s.charAt(i) == t.charAt(j))
        {
            ans += memo(s, t, i + 1, j + 1, dp);
            ans += memo(s, t, i + 1, j, dp);
        }
        else
            ans += memo(s, t, i + 1, j, dp);
        
        return dp[i][j] = ans;
    }
         
}
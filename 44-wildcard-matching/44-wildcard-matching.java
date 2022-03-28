class Solution {
    public boolean isMatch(String s, String p) {
        
        if(p.length() == 0)
            return s.length() == 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(p.charAt(0));
        
        int i = 1;
        while(i < p.length())
        {
            if(p.charAt(i) == '*' && p.charAt(i - 1) == p.charAt(i))
                i++;
            
            else if(i < p.length())
                sb.append(p.charAt(i++));
        }
        
        p = sb.toString();
        
        // return rec(s, p, s.length(), p.length());
        
        int dp[][] = new int[s.length() + 1][p.length() + 1];
        for(int d[] : dp)
            Arrays.fill(d, -1);
        
        return memo(s, p, s.length(), p.length(), dp);
    }
    
//     public boolean rec(String s, String p, int m, int n)
//     {
//         if(m == 0 || n == 0)
//         {
//             if((m == 0 && n == 0) || (n == 1 && p.charAt(n - 1) == '*'))
//                 return true;
            
//             return false;
//         }
        
//         if(s.charAt(m - 1) == p.charAt(n - 1) || p.charAt(n - 1) == '?')
//             return rec(s, p, m - 1, n - 1);
        
//         else if(p.charAt(n - 1) == '*')
//             return (rec(s, p, m, n - 1) || rec(s, p, m - 1, n));
        
//         else
//             return false;
//     }
    
    public boolean memo(String s, String p, int m, int n, int dp[][])
    {
        if(m == 0 || n == 0)
        {
            dp[m][n] = (m == 0 && n == 0) || (n == 1 && p.charAt(n - 1) == '*') ? 1 : 0;
                return dp[m][n] == 1;
        }
        
        if(dp[m][n] != -1)
            return dp[m][n] == 1;
        
        if(s.charAt(m - 1) == p.charAt(n - 1) || p.charAt(n - 1) == '?')
            dp[m][n] = memo(s, p, m - 1, n - 1, dp) ? 1 : 0;
        
        else if(p.charAt(n - 1) == '*')
            dp[m][n] = (memo(s, p, m, n - 1, dp) || memo(s, p, m - 1, n, dp)) ? 1 : 0;
        
        else
            dp[m][n] = 0;
        
        return dp[m][n] == 1;
    }

}
class Solution {
    public String longestPalindrome(String s) {
        
        //return rec(s, 0, s.length() - 1);
        
        String dp[][] = new String[s.length()][s.length()];
        return memo(s, 0, s.length() - 1, dp);
    }
    
//     public String rec(String s, int i, int j)
//     {
//         if(i >= j)
//             return i == j ? s.substring(i, j + 1) : "";
        
//         if(s.charAt(i) == s.charAt(j) && rec(s, i + 1, j - 1).length() == j - i - 1)
//             return s.substring(i, j + 1);
//         else
//         {
//             String a = rec(s, i + 1, j);
//             String b = rec(s, i, j - 1);
            
//             return a.length() > b.length() ? a : b;
//         }
//     }
    
    public String memo(String s, int i, int j, String dp[][])
    {
        if(i >= j)
            return dp[i][j] = (i == j ? s.substring(i, j + 1) : "");
        
        if(dp[i][j] != null)
            return dp[i][j];
        
        if(s.charAt(i) == s.charAt(j) && memo(s, i + 1, j - 1, dp).length() == j - i - 1)
            return dp[i][j] = s.substring(i, j + 1);
        else
        {
            String a = memo(s, i + 1, j, dp);
            String b = memo(s, i, j - 1, dp);
            
            return dp[i][j] = a.length() > b.length() ? a : b;
        }
    }
}
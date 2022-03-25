class Solution {
    public int numDecodings(String s) {
        
        //return (int)rec(s, 0);
        
        long dp[] = new long[s.length() + 1];
        Arrays.fill(dp, -1);
        
        return (int)memo(s, 0, dp);
       
    }

//     public long rec(String s, int idx)
//     {
//         if(idx == s.length())
//             return 1;
        
//         char a = s.charAt(idx);
//         if(a == '0')
//             return 0; 
        
//         long ans = 0;
//         if(a == '*')
//         {
//             ans += 9 * rec(s, idx + 1);
            
//             if(idx < s.length() - 1)
//             {
//                 char b = s.charAt(idx + 1);
//                 if(b == '*')
//                 {
//                     ans += 15 * rec(s, idx + 2);
//                 }
//                 else
//                 {
//                     if(b >= '0' && b <= '6')
//                         ans += 2 * rec(s, idx + 2);
                
//                     if(b >= '7' && b <= '9')
//                         ans += rec(s, idx + 2);
//                 }
//             }
            
//         }
//         else
//         {
//             ans += rec(s, idx + 1);
            
//             if(idx < s.length() - 1)
//             {
//                 char b = s.charAt(idx + 1);
                
//                 if(b == '*')
//                 {
//                     if(a == '1')
//                         ans += 9 * rec(s, idx + 2);
                    
//                     if(a == '2')
//                         ans += 6 * rec(s, idx + 2);
//                 }
                
//                 else
//                 {
//                     if(Integer.parseInt(s.substring(idx, idx + 2)) <= 26)
//                         ans += rec(s, idx + 2);    
//                 }
                
//             }
//         }
        
//         return ans % ((int) 1e9 + 7);
//     }
    
    public long memo(String s, int idx, long dp[])
    {
        if(idx == s.length())
            return dp[idx] = 1;
        
        if(dp[idx] != -1)
            return dp[idx];
        
        char a = s.charAt(idx);
        if(a == '0')
            return dp[idx] = 0; 
        
        long ans = 0;
        if(a == '*')
        {
            ans += 9 * memo(s, idx + 1, dp);
            
            if(idx < s.length() - 1)
            {
                char b = s.charAt(idx + 1);
                if(b == '*')
                {
                    ans += 15 * memo(s, idx + 2, dp);
                }
                else
                {
                    if(b >= '0' && b <= '6')
                        ans += 2 * memo(s, idx + 2, dp);
                
                    if(b >= '7' && b <= '9')
                        ans += memo(s, idx + 2, dp);
                }
            }
            
        }
        else
        {
            ans += memo(s, idx + 1, dp);
            
            if(idx < s.length() - 1)
            {
                char b = s.charAt(idx + 1);
                
                if(b == '*')
                {
                    if(a == '1')
                        ans += 9 * memo(s, idx + 2, dp);
                    
                    if(a == '2')
                        ans += 6 * memo(s, idx + 2, dp);
                }
                
                else
                {
                    if(Integer.parseInt(s.substring(idx, idx + 2)) <= 26)
                        ans += memo(s, idx + 2, dp);    
                }
                
            }
        }
        
        return dp[idx] = ans % ((int) 1e9 + 7);
    }
}
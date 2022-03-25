class Solution {
    public int numDecodings(String s) {
          
        //return rec(s);
        
        // HashMap<String, Integer> dp = new HashMap<>();
        // return memo(s, dp);
        
        int dp[] = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return memo1(s, 0, dp);
        
    }
    
//     public int rec(String s)
//     {
//         if(s.length() == 0)
//             return 1;
        
//         int n = s.charAt(0) - '0';
//         if(n == 0)
//             return 0;
        
//         int ans = 0;
//         ans += rec(s.substring(1));
        
//         if(s.length() > 1)
//         {
//             n = n * 10 + s.charAt(1) - '0';
//             if(n <= 26)
//                 ans += rec(s.substring(2));
//         }
//         return ans;
//     }
    
//     public int memo(String s, HashMap<String, Integer> dp)
//     {
//         if(s.length() == 0)
//         {
//             dp.put(s, 1);
//             return 1;
//         }
        
//         if(dp.containsKey(s))
//             return dp.get(s);
        
//         int n = s.charAt(0) - '0';
//         if(n == 0)
//         {
//             dp.put(s, 0);
//             return 0;
//         }
        
//         int ans = 0;
//         ans += memo(s.substring(1), dp);
        
//         if(s.length() > 1)
//         {
//             n = n * 10 + s.charAt(1) - '0';
//             if(n <= 26)
//                 ans += memo(s.substring(2), dp);
//         }
        
//         dp.put(s, ans);
//         return ans;
//     }
    
    public int memo1(String s, int idx, int dp[])
    {
         if(idx == s.length())
            return dp[idx] = 1;
        
        if(dp[idx] != -1)
            return dp[idx];
        
        int n = s.charAt(idx) - '0';
        if(n == 0)
            return dp[idx] = 0;
        
        int ans = 0;
        ans += memo1(s, idx + 1, dp);
        
        if(idx < s.length() - 1)
        {
            n = n * 10 + s.charAt(idx + 1) - '0';
            if(n <= 26)
                ans += memo1(s, idx + 2, dp);
        }
        return dp[idx] = ans;
    }

}
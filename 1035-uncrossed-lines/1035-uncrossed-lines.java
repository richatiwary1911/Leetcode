class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        //return rec(nums1, nums2, 0, 0);
        
        int dp[][] = new int[nums1.length + 1][nums2.length + 1];
        for(int d[] : dp)
            Arrays.fill(d, -1);
        
        return memo(nums1, nums2, 0, 0, dp);
        
    }
    
//     public int rec(int nums1[], int nums2[], int i, int j)
//     {
//         if(i == nums1.length || j == nums2.length)
//             return 0;
        
//         if(nums1[i] == nums2[j])
//         {
//             return rec(nums1, nums2, i + 1, j + 1) + 1;
//         }
//         else
//         {
//             return Math.max(rec(nums1, nums2, i + 1, j), rec(nums1, nums2, i, j + 1));
//         }
        
//     }
    
    public int memo(int nums1[], int nums2[], int i, int j, int dp[][])
    {
        if(i == nums1.length || j == nums2.length)
            return dp[i][j] = 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(nums1[i] == nums2[j])
        {
            return dp[i][j] = memo(nums1, nums2, i + 1, j + 1, dp) + 1;
        }
        else
        {
            return dp[i][j] = Math.max(memo(nums1, nums2, i + 1, j, dp), memo(nums1, nums2, i, j + 1, dp));
        }
        
    }
    

}
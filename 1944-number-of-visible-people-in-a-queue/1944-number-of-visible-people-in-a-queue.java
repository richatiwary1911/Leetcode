class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int ans[] = new int[n];
        
        for(int i = n - 1; i >= 0; i--)
        {
            int personCount = 0;
            
            while(!st.isEmpty() && st.peek() < heights[i])
            {
                st.pop();
                personCount++;
            }
            
            ans[i] = personCount + (st.isEmpty() ? 0 : 1);
            st.push(heights[i]);
        }
        return ans;
        
    }
} 
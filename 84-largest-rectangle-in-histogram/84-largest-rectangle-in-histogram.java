class Solution {
    public int largestRectangleArea(int[] heights) {
        
        return findMax(heights);
    }
    
    public int[] nextMinToLeft(int heights[])
    {
        Stack<Integer> st = new Stack<>();
        int leftMinArray[] = new int[heights.length];
        for(int i = 0; i < heights.length; i++)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();
        
            leftMinArray[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return leftMinArray;
    }
    
    public int[] nextMinToRight(int heights[])
    {
        Stack<Integer> st = new Stack<>();
        int rightMinArray[] = new int[heights.length];
        
        for(int i = heights.length - 1; i >= 0; i--)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
                st.pop();
            
            rightMinArray[i] = st.isEmpty() ? heights.length : st.peek();
            st.push(i);
        }
        return rightMinArray;
    }
    
    public int findMax(int heights[])
    {
        int left[] = nextMinToLeft(heights);
        int right[] = nextMinToRight(heights);
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < heights.length; i++)
        {
            max = Math.max((right[i] - left[i] - 1) * heights[i], max);
        }
        
        return max;       
    }
}
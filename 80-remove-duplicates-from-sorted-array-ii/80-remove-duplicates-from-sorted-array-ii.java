class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2) return nums.length;
        
        int i = 2;
        for(int j = i; j < nums.length; j++) {
            if(nums[i-2] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
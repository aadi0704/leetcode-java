class Solution {
    public int sortPermutation(int[] nums) {
        int ans = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                ans = ans&nums[i];
            }
        }
        return ans==-1?0:ans;
    }
}


# Approach
1. Initialize a variable `ans` to -1.
2. Iterate through the array `nums` and check if each element is at its correct position (i.e., `nums[i] == i`).
3. If an element is not at its correct position, perform a bitwise AND operation between `ans` and the element.
4. Return the final value of `ans`, or 0 if `ans` is still -1.


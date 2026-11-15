class Solution {
    public int countConsistent(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int min = Integer.MAX_VALUE;
            int bit = -1;
            for(int j=i;j<n;j++){
                min = Math.min(min,nums[j]);
                bit&=nums[j];
                if(bit==min) count++;
            }
        }
        return count;
    }
}
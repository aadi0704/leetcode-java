class Solution {
    public long minCost(int[] nums) {
        int n = nums.length;
        if(n<=1) return 0;
        int i=0;
        long min = Long.MAX_VALUE;
        while(i<n){
            int j=i;
            while(j+1<n && nums[j]==nums[j+1]){
                j++;
            }
            
            if(i<n-1 && j>0) {
                long cost = (long)(i+n-j-1)*nums[i];
                min=Math.min(min,cost);
            }
            i=j+1;
        }
        return min;
        
    }
}
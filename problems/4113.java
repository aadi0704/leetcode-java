class Solution {
    long[] dp;
    public long dfs(int[] nums,int i){
        if(i>=nums.length) return 0;
        if(dp[i]!=Long.MIN_VALUE) return dp[i];

        long takeOne = nums[i];
        if(takeOne%3==0){
            takeOne -= dfs(nums,i+1);
        }
        else{
            takeOne += dfs(nums,i+1);
        }

        long takeTwo = Long.MIN_VALUE;
        if(i+1<nums.length){
            takeTwo = nums[i]+nums[i+1];
            if(takeTwo%3==0){
                takeTwo-=dfs(nums,i+2);
            }
            else{
                takeTwo+=dfs(nums,i+2);
            }
        }
        dp[i]=Math.max(takeOne,takeTwo);
        return dp[i];
        
    }
    public long maxDifference(int[] nums) {
        int n = nums.length;
        dp = new long[n];
        Arrays.fill(dp,Long.MIN_VALUE);
        return dfs(nums,0);
    }
}
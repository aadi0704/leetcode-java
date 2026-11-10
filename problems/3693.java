class Solution {
    int[] dp;
    public int solve(int n,int[] costs,int i){
        if(i==n) return 0;
        if(i>n) return 100001;
        if(dp[i]!=-1) return dp[i];
        int oneStep = 100001;
        int twoStep = 100001;
        int threeStep = 100001;
        if(i+1-1<n){
            oneStep = solve(n,costs,i+1)+costs[i+1-1]+(int)Math.pow(i+1-i,2);
        }
        if(i+2-1<n){
            twoStep = solve(n,costs,i+2)+costs[i+2-1]+(int)Math.pow(i+2-i,2);
        }
        if(i+3-1<n){
            threeStep = solve(n,costs,i+3)+costs[i+3-1]+(int)Math.pow(i+3-i,2);
        }

        dp[i] =  Math.min(oneStep,Math.min(twoStep,threeStep));
        return dp[i];

    }
    public int climbStairs(int n, int[] costs) {
        dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(n,costs,0);
    }
}
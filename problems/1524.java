class Solution {
    int MOD = 1000000007;
    int[][] dp;
    public int solve(int[] arr,int i,int parity){
        if(i==arr.length) return 0;
        if(dp[i][parity]!=-1) return dp[i][parity];
        int newPar = (parity+arr[i]%2)%2;
        int count = newPar==1?1:0;
        count=(count+solve(arr,i+1,newPar))%MOD;
        dp[i][parity]=count;
        return dp[i][parity];
    }
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        dp = new int[n][2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            ans=(ans+solve(arr,i,0))%MOD;
        }
        return ans;

    }
}
class Solution {
    int[][] cost;
    int[][] dp;
    public int getCost(String s,int i,int j){
        if(cost[i][j]!=-1) return cost[i][j];
        int len = j-i+1;
        int ans = Integer.MAX_VALUE;

        for(int d=1;d<len;d++){
            if(len%d!=0) continue;

            int changes=0;
            for(int k=0;k<d;k++){
                int left = i+k;
                int right = j-d+1+k;
                while(left<right){
                    if(s.charAt(left)!=s.charAt(right)){
                        changes++;
                    }
                    left+=d;
                    right-=d;
                }
                
            }
            ans = Math.min(ans,changes);
        }
        return cost[i][j]=ans;
    }
    public int solve(String s,int i,int k){
        if(k==0){
            if(i==s.length()){
                return 0;
            }
            return 100000;
        }
        if(dp[i][k]!=-1){
            return dp[i][k];
        }
        int ans = 100000;
        int n = s.length();
        for(int j=i+1;j<=n-2*(k-1)-1;j++){
            int cost = getCost(s,i,j);
            int rem = solve(s,j+1,k-1);
            ans = Math.min(cost+rem,ans);
        }
        dp[i][k]=ans;
        return dp[i][k];
    }
    public int minimumChanges(String s, int k) {
        int n = s.length();
        cost = new int[n][n];
        for(int[] row:cost){
            Arrays.fill(row,-1);
        }
        dp = new int[n][k+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(s,0,k);

    }
}



#### Approach
1. We define a 2D array `cost` to store the minimum number of changes required to make the substring `s[i...j]` periodic.
2. We define a 2D array `dp` to store the minimum number of changes required to partition the string `s` into `k` periodic substrings starting from index `i`.
3. The `getCost` function calculates the minimum number of changes required to make the substring `s[i...j]` periodic by checking all possible periods `d` that divide the length of the substring. For each period, it counts the number of changes needed to make the substring periodic.
4. The `solve` function uses dynamic programming to find the minimum number of changes required to partition the string `s` into `k` periodic substrings. It iterates through all possible end indices `j` for the first substring and recursively calculates the cost for the remaining substrings.
5. The `minimumChanges` function initializes the `cost` and `dp` arrays and calls the `solve` function to get the final answer.



Example Explanation:
For the input string `s = "aabbcc"` and `k = 2`, the optimal partitioning would be `["aabbcc"]` with 0 changes, or `["aabb", "cc"]` with 2 changes. The function returns the minimum number of changes required, which is 0.

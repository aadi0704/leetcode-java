class Solution {
    int MOD = 1_000_000_007;
    int[][] dp;
    int m, n;

    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n];

        for (int i=0;i<m;i++) {
            Arrays.fill(dp[i],-1);
        }

        return dfs(0,0,grid);
    }

    public int dfs(int r,int c,int[][] grid) {
        if (r >= m||c >= n) {
            return 0;
        }

        if (r==m - 1&&c ==n - 1) {
            return 1;
        }

        if (dp[r][c]!=-1) {
            return dp[r][c];
        }

        long right = move(r,c,0,1,grid);
        long down =move(r,c,1,0,grid);

        return dp[r][c]=(int)((right+down)%MOD);
    }

    public long move(int r,int c,int dr,int dc,int[][] grid) {
        r+= dr;
        c+=dc;

        while (r<m&&c<n) {
            if (grid[r][c]==0) {
                return dfs(r,c,grid);
            }
            if (dr==0&&dc==1) {
                dr =1;
                dc =0;
            } else {
                dr= 0;
                dc =1;
            }
            r+=dr;
            c+=dc;
        }
        return 0;
    }
}
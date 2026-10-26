class Solution {
    public long bfs(int[][] grid,int n,int m,int i,int j){
        Queue<int[]> q =new ArrayDeque<>();
        q.add(new int[]{i,j});
        long value = grid[i][j];
        grid[i][j]=0;
        int[][] directions = {{1,0},{0,1},{0,-1},{-1,0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int[] direction:directions){
                int rd = r + direction[0];
                int cd = c + direction[1];
                if(rd>=0 && cd>=0 && rd<n && cd<m && grid[rd][cd]!=0){
                    value+=grid[rd][cd];
                    q.add(new int[]{rd,cd});
                    grid[rd][cd]=0;
                }
            }
        }
        return value;
    }
    public int countIslands(int[][] grid, int k) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    long totalValue = bfs(grid,n,m,i,j);
                    if(totalValue%k==0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
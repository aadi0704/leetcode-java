class Solution {
    boolean[][] visited;
    int n,m;
    public int bfs(int[][] grid,int r,int c){
        visited[r][c]=true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        int count = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int rd = curr[0];
            int cd = curr[1];
            count++;
            for(int i=0;i<m;i++){
                if(grid[rd][i]==1 && !visited[rd][i]){
                    visited[rd][i]=true;
                    q.add(new int[]{rd,i});
                }
            }
            for(int i=0;i<n;i++){
                if(grid[i][cd]==1 && !visited[i][cd]){
                    visited[i][cd]=true;
                    q.add(new int[]{i,cd});
                }
            }
        }
        return count;


    }
    public int countServers(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int servers = bfs(grid,i,j);
                    
                    if(servers>1){
                        count+=servers;
                    }
                }
            }
        }
        return count;
    }
}
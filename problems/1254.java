class Solution {
    public static void bfs(Queue<int[]> q,int[][] grid,int n,int m){
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int[] direction:directions){
                int rd = r+direction[0];
                int cd = c+direction[1];
                if(rd>=0 && cd>=0 && rd<n && cd<m &&grid[rd][cd]==0){
                    q.add(new int[]{rd,cd});
                    grid[rd][cd]=1;
                }
            }
        }
    }
    public int closedIsland(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i=0;i<n;i++){
            if(grid[i][0]==0){
                q.add(new int[]{i,0});
                grid[i][0]=1;
            }
            if(grid[i][m-1]==0){
                q.add(new int[]{i,m-1});
                grid[i][m-1]=1;
            }
        }
        for(int j=0;j<m;j++){
            if(grid[0][j]==0){
                q.add(new int[]{0,j});
                grid[0][j]=1;
            }
            if(grid[n-1][j]==0){
                q.add(new int[]{n-1,j});
                grid[n-1][j]=1;
            }
        }
        bfs(q,grid,n,m);


        
        int count =0;

        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                    bfs(q,grid,n,m);
                    grid[i][j]=1;
                    count++;
                }
            }
        }
        return count;
    }
}



## Approach
1. We will use a breadth-first search (BFS) approach to traverse the grid and mark the land cells (0s) that are connected to the boundary as water (1s). This will help us identify the closed islands.
2. We will first iterate through the boundary cells of the grid (first and last rows, first and last columns) and for each land cell (0) found, we will perform a BFS to mark all connected land cells as water (1).
3. After marking the boundary-connected land cells, we will iterate through the inner cells of the grid (excluding the boundary) and for each unvisited land cell (0), we will perform a BFS to mark all connected land cells as water (1) and increment our closed island count.

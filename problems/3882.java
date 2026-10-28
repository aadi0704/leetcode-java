class Solution {
    private boolean[][][] visited;
    private int ans;
    public void solve(int[][] grid,int i,int j,int xor){
        int n =grid.length;
        int m = grid[0].length;
        xor^=grid[i][j];
        if(visited[i][j][xor]) return;
        visited[i][j][xor]=true;
        
        if(i==n-1 && j==m-1){
            ans=Math.min(ans,xor);
            return ;
        }
        if(j+1<m){
            solve(grid,i,j+1,xor);
        }
        if(i+1<n){
            solve(grid,i+1,j,xor);
        }
    }
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        visited=new boolean[n][m][1024];
        ans=Integer.MAX_VALUE;
        solve(grid,0,0,0);
        return ans;
    }
}



### Approach:
1. We can use a recursive backtracking approach to explore all possible paths from the top-left corner to the bottom-right corner of the grid.
2. We will maintain a 3D boolean array `visited` to keep track of the states we have already visited, where `visited[i][j][xor]` indicates whether we have visited cell `(i, j)` with a cumulative XOR value of `xor`.
3. We will initialize the answer `ans` to `Integer.MAX_VALUE` and update it whenever we reach the bottom-right corner of the grid with a new minimum XOR value.
4. The recursive function `solve` will take the current position `(i, j)` and the cumulative XOR value as parameters. It will explore moving right and down in the grid, updating the XOR value accordingly.
5. If we reach the bottom-right corner, we will compare the current XOR value with `ans` and update `ans` if the current XOR is smaller.
6. Finally, we will return the minimum XOR value found after exploring all paths.


Why 3d array?
The 3D array `visited` is used to keep track of the states we have already visited during our recursive exploration of the grid. The dimensions of the array are as follows:
- The first dimension corresponds to the row index `i` of the grid.
- The second dimension corresponds to the column index `j` of the grid.
- The third dimension corresponds to the cumulative XOR value `xor` that we have computed so far while traversing the grid.
This allows us to avoid revisiting the same cell `(i, j)` with the same cumulative XOR value, which would lead to redundant calculations and potentially infinite loops. By marking a state as visited, we ensure that we only explore unique paths and efficiently find the minimum XOR value.


example:
Let's consider an example grid:
[
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]
In this grid, we want to find the minimum XOR value among all possible paths from the top-left corner (0, 0) to the bottom-right corner (2, 2).
example path:
One possible path is:
1. Start at (0, 0) with value 1. Cumulative XOR = 1.
2. Move right to (0, 1) with value 2. Cumulative XOR = 1 ^ 2 = 3.
3. Move down to (1, 1) with value 5. Cumulative XOR = 3 ^ 5 = 6.
4. Move down to (2, 1) with value 8. Cumulative XOR = 6 ^ 8 = 14.
5. Move right to (2, 2) with value 9. Cumulative XOR = 14 ^ 9 = 7.
In this case, the cumulative XOR value for this path is 7. The algorithm will explore all possible paths and keep track of the minimum XOR value found, which will be returned as the final answer.



class Solution {
    long[] dp;
    boolean[] visited;
    List<List<Integer>> child;
    public int maxScore(int[] parent, int[] op, int[] score) {
        int n = parent.length;
        child = new ArrayList<>();
        for(int i=0;i<n;i++){
            child.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            child.get(parent[i]).add(i);
        }
        dp = new long[n];
        visited = new boolean[n];
        return (int)dfs(0,op,score);
    }
    public long dfs(int node,int[] op,int[] score){
        if(visited[node]) return dp[node];
        if(child.get(node).isEmpty()){
            visited[node]=true;
            return score[node];
        }
        long total = 0;
        long min = Long.MAX_VALUE;

        for(int c:child.get(node)){
            long val = dfs(c,op,score);
            total+=val;
            min = Math.min(min,val);
        }

        if(op[node]==1){
            dp[node]=score[node]+total-min;
        }
        else{
            dp[node]=score[node]+total-Math.min(0L,min);
        }
        visited[node]=true;
        return dp[node];
    }
}
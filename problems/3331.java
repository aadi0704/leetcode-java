class Solution {
    List<Integer>[] tree;
    int[] last;
    List<Integer>[] newTree;
    public int[] findSubtreeSizes(int[] parent, String s) {
        tree = new ArrayList[parent.length];;
        for(int i=0;i<parent.length;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=1;i<parent.length;i++){
            tree[parent[i]].add(i);
        }
        last = new int[26];
        Arrays.fill(last,-1);
        newTree = new ArrayList[parent.length];
        for(int i=0;i<parent.length;i++){
            newTree[i]=new ArrayList<>();
        }
        dfs1(s,0,parent);
        int[] ans = new int[parent.length];
        dfs2(0,ans);
        return ans;
    }
    public void dfs1(String s,int node,int[] parent){
        int ch=s.charAt(node)-'a';
        int prev = last[ch];
        if(node!=0){
            if(prev==-1) newTree[parent[node]].add(node);
            else newTree[prev].add(node);
        }
        
        last[ch]=node;
        for(int child:tree[node]){
            dfs1(s,child,parent);
        }
        last[ch]=prev;
    }
    public int dfs2(int node,int[] ans){
        int size = 1;
        for(int child:newTree[node]){
            size+=dfs2(child,ans);
        }
        ans[node]=size;
        return size;
    }
}
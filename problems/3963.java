class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans =new String[m];
        String first = "";
        for(int i=0;i<n;i++){
            first+='.';
        }
        ans[0]=first;
        String row = "";
        for(int j=0;j<n-1;j++){
            row+="#";
        }
        row+='.';
        for(int i=1;i<m;i++){
            ans[i]=row;
        }
        return ans;
    }
}
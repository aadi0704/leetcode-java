class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int sum =0;
            for(int j=i;j<n;j++){
                int len = j-i+1;
                sum+=nums.get(j);
                if(len>=l && len<=r && sum>0){
                    min = Math.min(min,sum);
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if((nums[i]^nums[j])==0){
                    ans = ans^nums[i];
                }
            }
        }
        return ans;
    }
}
class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int low = 1;
        int high=n;
        int ans = n;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(nums,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;

    }
    public boolean check(int[] nums,int len){
        Map<Long,Integer> hmap = new HashMap<>();
        long base = 131;
        long mod =1_000_000_007;
        long power = 1;
        for(int i=0;i<len-1;i++){
            power = (power*base)%mod;
        }
        long hash = 0;
        for(int i=0;i<len;i++){
            hash = (hash*base+nums[i])%mod;
        }
        hmap.put(hash,1);
        for(int i=len;i<nums.length;i++){
            hash=(hash-(power*nums[i-len])%mod+mod)%mod;
            hash = (hash*base+nums[i])%mod;
            hmap.put(hash,hmap.getOrDefault(hash,0)+1);
        }

        for(int value:hmap.values()){
            if(value==1) return true;
        }
        return false;
    }
}
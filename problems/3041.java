class Solution {
    public int maxSelectedElements(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        Arrays.sort(nums);
        int ans = 0;
        for(int num:nums){
            int take = hmap.getOrDefault(num-1,0)+1;
            int incremented = hmap.getOrDefault(num,0)+1;
            hmap.put(num,Math.max(hmap.getOrDefault(num,0),take));
            hmap.put(num+1,Math.max(hmap.getOrDefault(num+1,0),incremented));
            ans = Math.max(ans,Math.max(hmap.get(num),hmap.get(num+1)));
        }
        return ans;
    }
}
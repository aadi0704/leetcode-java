class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        Arrays.fill(result,-1);
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && nums[i%n]>=st.peek()){
                st.pop();
            }
            if(i<n && !st.isEmpty()){
                result[i]=st.peek();
            }
            st.push(nums[i%n]);
        }
        return result;
    }
}
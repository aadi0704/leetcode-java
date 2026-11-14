class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        Arrays.fill(nse,n);
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(!st.isEmpty()) nse[i]=st.peek();
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();
        int[] pse = new int[n];
        Arrays.fill(pse,-1);
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(!st.isEmpty()) pse[i]=st.peek();
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();
        int[] nge = new int[n];
        Arrays.fill(nge,n);
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(!st.isEmpty()) nge[i]=st.peek();
            st.push(i);
        }
        while(!st.isEmpty()) st.pop();
        int[] pge = new int[n];
        Arrays.fill(pge,-1);
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(!st.isEmpty()) pge[i]=st.peek();
            st.push(i);
        }

        long sum = 0;
        for(int i=0;i<n;i++){
            long val = ((nge[i]-i)*(i-pge[i])-(nse[i]-i)*(i-pse[i]));
            sum+=val*nums[i];
        }
        return sum;
        
    }
}
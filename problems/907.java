class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = 1000000007;
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        Arrays.fill(nse,n);
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()) nse[i]=st.peek();
            st.push(i);
        }
        while(!st.isEmpty()){
            st.pop();
        }
        int[] pse = new int[n];
        Arrays.fill(pse,-1);
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(!st.isEmpty()) pse[i]=st.peek();
            st.push(i);
        }
        long sum =0;
        for(int i=0;i<n;i++){
            long val = (long)(nse[i]-i)*(i-pse[i]);
            sum = (sum + val*arr[i])%mod;
        }
        return (int)sum;

    }
}
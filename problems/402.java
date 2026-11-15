class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        int n = num.length();
        for(int i=0;i<n;i++){
            char digit = num.charAt(i);
            while(!st.isEmpty() && st.peek()>digit && k!=0){
                st.pop();
                k--;
            }
            st.push(digit);
        }
        while(k!=0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        String ans = sb.toString();
        return ans.length()==0?"0":ans;

    }
}
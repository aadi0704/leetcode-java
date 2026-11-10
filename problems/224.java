class Solution {
    public int cal(String eq){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<eq.length();i++){
            char ch = eq.charAt(i);
            if(Character.isDigit(ch)){
                int num= 0;
                while(i<eq.length() && Character.isDigit(eq.charAt(i))){
                    num = num*10+(eq.charAt(i)-'0');
                    i++;
                }
                st.push(num);
                i--;
            }
            else if(ch=='+'||ch=='-'){
                int b = st.pop();
                int a = st.pop();
                if(ch=='+'){
                    st.push(a+b);
                }
                else{
                    st.push(a-b);
                }
            }
            else if(ch=='#') {
                continue;
            }
        }
        return st.pop();
    }
    public String postFix(String s){
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isWhitespace(ch)) continue;
            if(Character.isDigit(ch)) {
                while(i<s.length()&&Character.isDigit(s.charAt(i))) {
                    sb.append(s.charAt(i));
                    i++;
                }
                sb.append('#');
                i--;
            }
            else if(ch=='(') st.push(ch);
            else if(ch==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    sb.append(st.pop());
                }
                st.pop();
            }
            else{
                int j =i-1;
                while(j>=0&&Character.isWhitespace(s.charAt(j))) {
                    j--;
                }
                boolean unary = (ch=='-' && (j<0 || s.charAt(j)=='(' || s.charAt(j)=='+' || s.charAt(j)=='-'));
                if(unary){
                    sb.append('0');
                    sb.append('#');
                }
                while(!unary && !st.isEmpty() && st.peek()!='('){
                    sb.append(st.pop());
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
    public int calculate(String s) {
        String postFixEquation = postFix(s);
        return cal(postFixEquation);
    }
}
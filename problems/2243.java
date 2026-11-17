class Solution {
    public String sumOfDigit(String part){
        int num=0;
        for(char ch:part.toCharArray()){
            num+=ch-'0';
        }
        return num+"";
    }
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder sb = new StringBuilder();
            int n = s.length();
            int i=0;
            while(i<n){
                String part = s.substring(i,Math.min(i+k,n));
                String res = sumOfDigit(part);
                sb.append(res);
                i+=k;
                
            }
            s=sb.toString();
        }
        return s;
        
    }
}
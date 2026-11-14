class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int i = digits.length-1;
        while(i>0 && digits[i]<=digits[i-1]){
            i--;
        }
        if(i==0) return -1;
        int j = digits.length-1;
        while(digits[j]<=digits[i-1]){
            j--;
        }
        char temp = digits[i-1];
        digits[i-1]=digits[j];
        digits[j]=temp;
        Arrays.sort(digits,i,digits.length);
        long result = Long.parseLong(new String(digits));
        return (result >Integer.MAX_VALUE || result<=n)?-1:(int)result;
    }
}
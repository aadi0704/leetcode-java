class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";

        int n = num1.length();
        int m = num2.length();
        int total = n+m;
        int[] result = new int[total];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int product = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum = product + result[i+j+1];
                result[i+j+1]=sum%10;
                result[i+j]+=sum/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while(start<total && result[start]==0){
            start++;
        }
        for(int k=start;k<total;k++){
            sb.append(result[k]);
        }
        return sb.toString();
    }
}

###   Approach   ####
1. Check if either `num1` or `num2` is "0". If so, return "0" immediately, as multiplying by zero results in zero.
2. Determine the lengths of `num1` and `num2`, storing them in variables `n` and `m`, respectively.
3. Calculate the total length of the result, which is `n + m`, and create an integer array `result` of size `total` to hold the intermediate and final results of the multiplication.
4. Use two nested loops to iterate through each digit of `num1` and `num2` from right to left (least significant digit to most significant digit). The outer loop iterates over `num1`, and the inner loop iterates over `num2`.
5. For each pair of digits, calculate the product of the digits and add it to the corresponding position in the `result` array. The position is determined by the indices of the digits being multiplied.
   - Calculate the sum of the product and the existing value at `result[i + j + 1]`.
   - Update `result[i + j + 1]` with the last digit of the sum (using modulo 10) and carry over the remaining value to `result[i + j]` (using integer division by 10).
6. After processing all digit pairs, create a `StringBuilder` to construct the final result.
7. Skip any leading zeros in the `result` array by finding the first non-zero index.
8. Append the remaining digits from the `result` array to the `StringBuilder`.  
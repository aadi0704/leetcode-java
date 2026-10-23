class Solution {
    public int divide(int dividend, int divisor) {
        long a = (long)dividend;
        long b = (long)divisor;
        if(a==Integer.MIN_VALUE && b==-1) return Integer.MAX_VALUE;
        if(a==Integer.MIN_VALUE && b==1) return Integer.MIN_VALUE;
        boolean flag = a>0==b>0;
        long ans = 0;
        a = Math.abs(a);
        b = Math.abs(b);
        for(int i=31;i>=0;i--){
            if((b<<i)<=a){
                a-=(b<<i);
                ans|=(1L<<i);
            }
        }
        return (int)(!flag?-ans:ans);
    }
}


###   Approach   ####
1. Convert both `dividend` and `divisor` to long to handle edge cases where the result might exceed the range of integers.
2. Check for the edge case where `dividend` is `Integer.MIN_VALUE` and `divisor` is -1. In this case, return `Integer.MAX_VALUE` to avoid overflow.
3. Check for the edge case where `dividend` is `Integer.MIN_VALUE` and `divisor` is 1. In this case, return `Integer.MIN_VALUE`.
4. Determine the sign of the result by checking if both `dividend` and `divisor` have the same sign. Store this in a boolean variable `flag`.
5. Take the absolute values of both `dividend` and `divisor` to simplify the division process.
6. Initialize a variable `ans` to 0. This variable will store the result of the division.
7. Use a for loop to iterate from 31 down to 0. This loop will check each bit position to see if the divisor can be subtracted from the dividend.
   - Inside the loop, check if `(b << i)` is less than or equal to `a`. If it is, subtract `(b << i)` from `a` and set the corresponding bit in `ans` using the bitwise OR operation.
8. After the loop, return the result. If `flag` is false (meaning the result should be negative), return `-ans`. Otherwise, return `ans`.
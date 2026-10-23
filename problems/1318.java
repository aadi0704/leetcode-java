class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while(a!=0 || b!=0 || c!=0){
            if((c&1)==0){
                if((a&1)==1) count++;
                if((b&1)==1) count++;
            }
            else{
                if((a&1)==0 && (b&1)==0) count++;
            }
            a>>=1;
            b>>=1;
            c>>=1;
        }
        return count;
    }
}

##  Approach   ####
1. Initialize a variable `count` to 0. This variable will be used to count the number of flips needed to make the bitwise OR of `a` and `b` equal to `c`.
2. Use a while loop that continues as long as any of `a`, `b`, or `c` is not equal to 0. This loop will process each bit of the numbers from least significant to most significant.
3. Inside the loop, check the least significant bit of `c` using the bitwise AND operation (`c & 1`).
   - If the least significant bit of `c` is 0, check the least significant bits of `a` and `b`. If either of them is 1, increment the `count` for each 1 found, as we need to flip those bits to 0.
   - If the least significant bit of `c` is 1, check if both `a` and `b` have their least significant bits as 0. If so, increment the `count`, as we need to flip one of them to 1 to satisfy the condition.
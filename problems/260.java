class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num:nums){
            xor = xor^num;
        }
        int setBit = xor & ~(xor-1);
        int[] ans = new int[2];
        int a = 0;
        int b = 0;
        for(int num:nums){
            if((num&setBit)!=0){
                a = a^num;
            }
            else{
                b = b^num;
            }
        }

        ans[0]=Math.min(a,b);
        ans[1]=Math.max(a,b);
        return ans;
    }
}


## Approach ###
1. Initialize a variable `xor` to 0. This variable will be used to store the XOR of all numbers in the input array `nums`.
2. Iterate through each number in the `nums` array and perform a bitwise XOR operation with `xor`. This will give us the XOR of the two unique numbers in the array, as all other numbers appear twice and will cancel each other out.
3. Find the rightmost set bit in the `xor` result by performing a bitwise AND operation between `xor` and its two's complement (`~(xor - 1)`). This will help us differentiate between the two unique numbers.
4. Initialize two variables `a` and `b` to 0. These will be used to store the two unique numbers.
5. Iterate through the `nums` array again. For each number, check if the rightmost set bit (found in step 3) is set in the number. If it is, perform a bitwise XOR operation with `a`. If it is not, perform a bitwise XOR operation with `b`. This will separate the two unique numbers into `a` and `b`.
6. Finally, store the two unique numbers in the `ans` array, ensuring that the smaller number is placed first, and return the `ans` array.
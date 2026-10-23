class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for(int num:nums){
            xor^=num;
        }
        int count = 0;
        xor^=k;
        while(xor!=0){
            count++;
            xor=xor&(xor-1);
        }
        return count;
    }
}


####   Approach   ####
1. Initialize a variable `xor` to 0. This variable will be used to store the cumulative XOR of all elements in the `nums` array.
2. Iterate through each element `num` in the `nums` array and update `xor` by performing a bitwise XOR operation with `num`. This will give us the cumulative XOR of all elements in the array.
3. Initialize a variable `count` to 0. This variable will be used to count the number of set bits (1s) in the XOR result after XORing it with `k`.
4. Update `xor` by performing a bitwise XOR operation with `k`. This will give us the XOR result that we need to analyze for set bits.
5. Use a while loop that continues as long as `xor` is not equal to 0. Inside the loop, increment `count` by 1 for each set bit found and update `xor` by performing a bitwise AND operation with `xor - 1`. This operation removes the least significant set bit from `xor`.
6. Once the loop is complete, return the value of `count`, which represents the number of operations needed to make the cumulative XOR of the array equal to `k`.


example:
nums = [2, 1, 3, 4], k = 1
1. Initialize `xor` to 0.
2. Iterate through `nums`:
   - For num = 2: xor = 0 ^ 2 = 2
   - For num = 1: xor = 2 ^ 1 = 3
   - For num = 3: xor = 3 ^ 3 = 0
   - For num = 4: xor = 0 ^ 4 = 4
3. Initialize `count` to 0.
4. Update `xor` by XORing it with `k`: xor = 4 ^ 1 = 5
5. Use a while loop to count the set bits in `xor`:
   - First iteration: xor = 5 (binary 101), count = 1, xor = 5 & (5 - 1) = 4 (binary 100)
   - Second iteration: xor = 4 (binary 100), count = 2, xor = 4 & (4 - 1) = 0
6. The loop ends, and we return `count`, which is 2. Therefore, the minimum number of operations needed to make the cumulative XOR of the array equal to `k` is 2.

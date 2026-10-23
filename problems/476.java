class Solution {
    public int findComplement(int num) {
        int mask = 1;
        while(mask<num){
            mask = (mask<<1)|1;
        }
        return mask^num;
    }
}




###   Approach   ####
1. Initialize a variable `mask` to 1. This variable will be used to create a bitmask that has all bits set to 1 up to the most significant bit of `num`.
2. Use a while loop to shift the `mask` left by 1 and set the least significant bit to 1 until `mask` is greater than or equal to `num`. This will ensure that `mask` has all bits set to 1 up to the most significant bit of `num`.
3. Once the loop is complete, `mask` will be a number that has all bits set to 1 up to the most significant bit of `num`. For example, if `num` is 5 (binary 101), `mask` will become 7 (binary 111).
4. Finally, return the result of `mask` XOR `num`. The XOR operation will flip all the bits of `num` where `mask` has 1s, effectively giving us the complement of `num`. For example, if `num` is 5 (binary 101) and `mask` is 7 (binary 111), the result of `mask ^ num` will be 2 (binary 010), which is the complement of 5.
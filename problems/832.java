class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int[] row:image){
            int left = 0;
            int right = row.length-1;
            while(left<=right){
                int temp = row[left]^1;
                row[left] = row[right]^1;
                row[right] = temp;
                left++;
                right--;
            }

        }
        return image;
    }
}


###  Approach   ####
1. Iterate through each row of the image.
2. For each row, initialize two pointers: `left` starting at the beginning of the row and `right` starting at the end of the row.
3. While `left` is less than or equal to `right`, perform the following steps:
   - Store the value of `row[left]` XOR 1 in a temporary variable `temp`. This operation flips the bit (0 becomes 1 and 1 becomes 0).
   - Set `row[left]` to the value of `row[right]` XOR 1, effectively flipping the bit at the `right` position and assigning it to the `left` position.
   - Set `row[right]` to the value stored in `temp`, which is the flipped value of the original `row[left]`.
   - Increment the `left` pointer and decrement the `right` pointer to move towards the center of the row.
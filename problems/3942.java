class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zero=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zero=i;
                break;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int step:new int[]{1,-1}){
            boolean valid = true;
            for(int i=1;i<n;i++){
                int prev = (zero+(i-1)*step+n)%n;
                int curr = (zero+i*step+n)%n;

                if(nums[prev]>nums[curr]){
                    valid = false;
                    break;
                }
            }
            if(valid){
               if(step==1){
                  ans = Math.min(ans,zero);
                  ans = Math.min(ans,n-zero+2);
               }
               else{
                ans = Math.min(ans,zero+2);
                ans = Math.min(ans,n-zero);
               }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}



###  Approach   ####
1. Initialize a variable `n` to the length of the input array `nums`.
2. Initialize a variable `zero` to 0. This variable will be used to store the index of the first occurrence of 0 in the array.
3. Use a for loop to iterate through the array `nums` to find the index of the first occurrence of 0. If found, store the index in the variable `zero` and break the loop.
4. Initialize a variable `ans` to `Integer.MAX_VALUE`. This variable will be used to store the minimum number of operations needed to make the array sorted.
5. Use a for-each loop to iterate through an array containing two values: 1 and -1. These values represent the two possible directions (clockwise and counterclockwise) to check for sorting.
6. Inside the loop, initialize a boolean variable `valid` to true. This variable will be used to check if the array can be sorted in the current direction.
7. Use another for loop to iterate from 1 to `n-1`. Inside this loop, calculate the indices of the previous and current elements based on the current direction (`step`). Use modulo operation to handle wrapping around the array.
8. Check if the previous element is greater than the current element. If it is, set `valid` to false and break the loop, as the array cannot be sorted in this direction.
9. After checking all elements, if `valid` is true, calculate the number of operations needed to sort the array in the current direction and update `ans` with the minimum value.
   - If `step` is 1 (clockwise), calculate the operations as `zero` and `n - zero + 2`.
   - If `step` is -1 (counterclockwise), calculate the operations as `zero + 2` and `n - zero`.
10. After checking both directions, return `ans` if it is not equal to `Integer.MAX_VALUE`, otherwise return -1, indicating that it is not possible to sort the array.
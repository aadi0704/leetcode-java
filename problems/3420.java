class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        long cost = 0;
        long ans = 0;
        int j = n-1;
        for(int i=n-1;i>=0;i--){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                int l = dq.pollLast();
                int r = dq.isEmpty()?j+1:dq.peekLast();
                cost +=(long)(r-l)*(nums[i]-nums[l]);
            }
            dq.offer(i);
            while(cost>k){
                cost -= nums[dq.peekFirst()]-nums[j];
                if(dq.peekFirst()==j){
                    dq.pollFirst();
                }
                j--;
            }
            ans += j-i+1;
        }
        return ans;
    }
}



### Approach:
1. Initialize a deque to keep track of indices of the elements in the array.
2. Initialize variables `cost` to keep track of the total cost of the current subarray and `ans` to store the final count of non-decreasing subarrays.
3. Iterate through the array from the end to the beginning using index `i`.
4. For each element, while the deque is not empty and the current element is greater than the last element in the deque, pop elements from the deque and update the cost accordingly.
5. Add the current index `i` to the deque.
6. While the cost exceeds `k`, reduce the cost by removing elements from the front of the deque and adjusting the index `j`.
7. Update the answer by adding the number of valid subarrays ending at index `i`, which is `j - i + 1`.



Example explanation:
For the input array `nums = [1, 2, 3, 4] and `k = 5`, the function will count all non-decreasing subarrays whose total cost does not exceed `k`. The cost is calculated based on the differences between the elements in the subarray. The function will return the total count of such subarrays.
[1,2,3,4] has the following non-decreasing subarrays:
- [1]
- [1,2]
- [1,2,3]
- [1,2,3,4]
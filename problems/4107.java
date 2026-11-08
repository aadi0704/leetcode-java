class Solution {
    public int countSuffix(int[] nums, int[] target) {
        int n=nums.length;
        int[] a=nums.clone();
        int[] b=target.clone();
        Arrays.sort(a);
        Arrays.sort(b);
        if(!Arrays.equals(a,b)){
            return 0;
        }
        int first = n-1;
        for(int i=0;i<n;i++){
            if(nums[i]!=target[i]){
                first=i;
                break;
            }
        }
        int last=0;
        for(int i=0;i<n-1;i++){
            if(target[i]<target[i+1]){
                last=i+1;
            }
        }
        return Math.max(0,first-last+1);
    }
}


### Approach
1. Clone the input arrays `nums` and `target` to `a` and `b` respectively.
2. Sort both cloned arrays `a` and `b`.
3. Check if the sorted arrays `a` and `b` are equal. If they are not equal, return 0 since it is impossible to make `nums` equal to `target` by sorting any suffix.
4. Initialize `first` to `n-1` (the last index of the array).
5. Iterate through the `nums` array to find the first index where `nums[i]` is not equal to `target[i]`. Update `first` to this index.
6. Initialize `last` to 0.
7. Iterate through the `target` array to find the last index where `target[i]` is less than `target[i+1]`. Update `last` to this index.
8. Calculate the length of the suffix that can be sorted to make `nums` equal to `target` by returning `Math.max(0, first - last + 1)`. This ensures that if `first` is less than `last`, the result will be 0, indicating no valid suffix exists.



Example Explanation:
- For the input `nums = [1, 3, 2, 4]` and `target = [1, 2, 3, 4]`, the sorted versions of both arrays are equal, so we proceed to find the indices.
- The first index where `nums` and `target` differ is at index 1 (`3` vs `2`), so `first = 1`.
- The last index where `target[i] < target[i+1]` is at index 2 (`2 < 3`), so `last = 2`.
- The length of the suffix that can be sorted is `Math.max(0, 1 - 2 + 1) = Math.max(0, 0) = 0`, indicating that no valid suffix exists to sort `nums` into `target`.

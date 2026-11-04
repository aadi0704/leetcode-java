class Solution {
    long[][] dp;
    long[] cost;
    TreeMap<Integer,Integer> left = new TreeMap<>();
    TreeMap<Integer,Integer> right = new TreeMap<>();
    int ls = 0;
    int rs=0;
    long leftSum = 0;
    long rightSum = 0;
    public void insert(TreeMap<Integer,Integer> map,int num){
        map.put(num,map.getOrDefault(num,0)+1);
    }
    public void erase(TreeMap<Integer,Integer> map,int num){
        int count = map.get(num);
        if(count==1){
            map.remove(num);
        }
        else{
            map.put(num,count-1);
        }
    }
    public void add(int num){
        if(left.isEmpty() || num<=left.lastKey()){
            insert(left,num);
            ls++;
            leftSum+=num;
        }
        else{
            insert(right,num);
            rs++;
            rightSum+=num;
        }
        balance();
    }
    public void remove(int num){
        if(left.getOrDefault(num,0)>0){
            erase(left,num);
            ls--;
            leftSum-=num;
        }
        else{
            erase(right,num);
            rs--;
            rightSum-=num;
        }
        balance();
    }
    public void balance(){
        int target = (ls+rs+1)/2;
        while(ls>target){
            int num = left.lastKey();
            erase(left,num);
            ls--;
            leftSum-=num;
            insert(right,num);
            rs++;
            rightSum+=num;
        }
        while(ls<target){
            int num = right.firstKey();
            erase(right,num);
            rs--;
            rightSum-=num;
            insert(left,num);
            ls++;
            leftSum+=num;
        }
    }
    public long getCost(){
        int median = left.lastKey();
        return median*ls-leftSum + rightSum - median*rs;
    }
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        dp = new long[k+1][n+1];
        cost = new long[n+1];
        left.clear();
        right.clear();
        ls=rs=0;
        leftSum=rightSum=0;

        for(int i=0;i<n;i++){
            add(nums[i]);
            if(i>=x){
                remove(nums[i-x]);
            }
            if(i>=x-1){
                cost[i+1]=getCost();
            }
        }
        
        for(long[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,k,n,x);
    }
    public long solve(int i,int k,int n,int x){
        if(k==0) return 0;
        if(i>n-x || n-i<k*x) return Long.MAX_VALUE/2;
        if(dp[k][i]!=-1) return dp[k][i];
        long skip = solve(i+1,k,n,x);
        long take = cost[i+x]+solve(i+x,k-1,n,x);
        return dp[k][i]=Math.min(skip,take);
    }
}

### Approach
1. We are given an array of integers `nums`, and we need to perform `k` operations where in each operation we can select a subarray of length `x` and replace it with its median. The goal is to minimize the total cost of these operations.
2. We will use a dynamic programming approach to solve this problem. We will maintain a 2D array `dp` where `dp[k][i]` represents the minimum cost to perform `k` operations starting from index `i`.
3. We will also maintain a `cost` array where `cost[i]` represents the cost of replacing the subarray starting at index `i` with its median.
4. To efficiently calculate the median and the cost of replacing a subarray, we will use two `TreeMap` structures to keep track of the elements in the left and right halves of the current window of size `x`. The left half will contain the smaller elements, and the right half will contain the larger elements. This allows us to efficiently find the median and calculate the cost.
5. The `add` method adds a new number to the appropriate half (left or right) and updates the sums and counts accordingly. The `remove` method removes a number from the appropriate half and updates the sums and counts. The `balance` method ensures that the left half always contains the median.
6. The `getCost` method calculates the cost of replacing the current window with its median.
7. Finally, we will use a recursive function `solve` to compute the minimum cost by either skipping the current index or taking the current subarray and moving to the next index. The base cases handle when no operations are left or when there are not enough elements left to perform the required operations.


example Explanation:
- For the input `nums = [1, 3, 2, 4, 5]`, `x = 2`, and `k = 2`, we can perform the following operations:
  - First operation: Replace the subarray `[1, 3]` with its median `2`. The cost is `|1-2| + |3-2| = 1 + 1 = 2`.
  - Second operation: Replace the subarray `[4, 5]` with its median `4`. The cost is `|4-4| + |5-4| = 0 + 1 = 1`.
- The total cost is `2 + 1 = 3`, which is the minimum cost for performing `2` operations on the given array.

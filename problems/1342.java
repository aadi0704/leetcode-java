class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;
        while(num!=0){
            if((num&1)==0){
                num=num>>1;
            }
            else{
                num--;
            }
            steps++;
        }
        return steps;
    }
}

####  Approach   ####
1. Initialize a variable `steps` to 0. This variable will be used to count the number of steps taken to reduce `num` to 0.
2. Use a while loop that continues as long as `num` is not equal to 0.
3. Inside the loop, check if `num` is even by performing a bitwise AND operation with 1 (`num & 1`). If the result is 0, it means `num` is even.
   - If `num` is even, right shift `num` by 1 (`num = num >> 1`) to divide it by 2.
   - If `num` is odd, decrement `num` by 1 (`num--`) to make it even.
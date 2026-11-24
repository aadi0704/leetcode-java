import java.math.BigInteger;
class Solution {
    public long gcd(long a,long b){
        while(b!=0){
            long temp = b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public int maxLength(int[] nums) {
        int ans = 2;
        int n = nums.length;
        for(int i=0;i<n;i++){
            BigInteger product = BigInteger.ONE;
            long gcd = 0;
            long lcm = 1;
            for(int j=i;j<n;j++){
                int num = nums[j];
                product = product.multiply(BigInteger.valueOf(num));
                gcd = gcd(gcd,num);
                lcm = (lcm/gcd(lcm,num))*num;
                long tar = gcd*lcm;
                if(product.equals(BigInteger.valueOf(tar))){
                    ans = Math.max(ans,j-i+1);
                }
                else if(product.compareTo(BigInteger.valueOf(tar))>0){
                    break;
                }
            }
        }
        return ans;
    }
}
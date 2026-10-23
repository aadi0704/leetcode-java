class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int i=left;i<=right;i++){
            int setBit = Integer.bitCount(i);
            if(check(setBit)){
                ans++;
            }
        }
        return ans;
    }
    public boolean check(int n){
        if(n<2) return false;
        if(n==2 || n==3) return true;
        if(n%2==0 || n%3==0) return false;

        for(int i=5;i*i<=n;i+=6){
            if(n%i==0 || n%(i+2)==0) return false;
        }
        return true;
    }
}
class Solution {
    public boolean canAliceWin(int n) {
        int stone =10;
        int turn=0;
        while(n>=stone){
            n-=stone;
            stone--;
            turn++;
        }
        return turn%2==1;
        
    }
}
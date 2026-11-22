class Solution {
    public boolean checkString(String s) {
        boolean prevB=false;
        for(char ch:s.toCharArray()){
            if(ch=='b') prevB=true;
            else if(ch=='a' && prevB) return false;
        }
        return true;
    }
}
class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean sorted = true;
        for(int i=1;i<n;i++){
            if(s.charAt(i)<s.charAt(i-1)){
                sorted= false;
                break;
            }
        }
        if(sorted) return 0;
        if(n==2) return -1;
        char min = 'z';
        char max = 'a';
        for(char ch:s.toCharArray()){
            min = (char)Math.min(min,ch);
            max = (char)Math.max(max,ch);
        }

        if(s.charAt(0)==min || s.charAt(n-1)==max){
            return 1;
        }
        for(int i=1;i<n-1;i++){
            if(s.charAt(i)==min || s.charAt(i)==max){
                return 2;
            }
        }
        
        return 3;
    }
}



###  Approach   ####
1. Initialize a variable `n` to the length of the string `s`.
2. Check if the string `s` is already sorted in non-decreasing order. If it is, return 0 as no operations are needed.
3. If the length of the string `n` is 2, return -1 as it is impossible to sort the string with only two characters.
4. Initialize two variables `min` and `max` to 'z' and 'a' respectively. These variables will be used to find the minimum and maximum characters in the string.
5. Iterate through each character `ch` in the string `s` and update `min and `max` accordingly.
6. Check if the first character of the string is equal to `min` or if the last character of the string is equal to `max`. If either condition is true, return 1 as only one operation is needed to sort the string.
7. Iterate through the characters of the string from index 1 to n-2 (excluding the first and last characters) and check if any character is equal to `min` or `max`. If found, return 2 as two operations are needed to sort the string.
8. If none of the above conditions are met, return 3 as three operations are needed to sort the string.

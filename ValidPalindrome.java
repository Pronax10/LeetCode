/*
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */

 //Solution with Runtime 1ms
 class Solution {
    public boolean isPalindrome(String s) {
        int left=0;int right=s.length()-1;

        while(left < right){
            if(!isAlphaNumeric(s.charAt(left))){
                left++;
            }
            else if(!isAlphaNumeric(s.charAt(right))){
                right--;
            }
            else if(lowerCase(s.charAt(left)) != lowerCase(s.charAt(right)))
                return false;
            
            else
            {
                left++;
                right--;
            }
        }
        return true;
    }
    private char lowerCase(char a) {
        if(a >= 'A' && a <= 'Z'){
            return (char) (a - 'A' + 'a');
        }
        return a;
    }
    private boolean isAlphaNumeric(char a) {
        return a >= 'a' && a <= 'z' || a >= 'A' && a <= 'Z' || a >= '0' && a <= '9';
    }
}

//Solution with runtime 15ms
//replaceAll is time consuming !!!
class Solution2 {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        System.out.println(s);
        if(s.equals(""))
            return true;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1))
                return false;
        }
        return true;
    }
}
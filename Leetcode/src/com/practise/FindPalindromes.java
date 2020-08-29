package com.practise;

import java.util.HashSet;
import java.util.Set;

public class FindPalindromes {

    public static boolean isPalindrome(String string, int  start, int end){
        final StringBuffer buffer = new StringBuffer(string);
        return buffer.toString().equals(buffer.reverse().toString());

    }


    public static void operateString(String mainString, int start, int end, Set<String> palindromes){
        String parseString = mainString.substring(start,end+1);
        if(FindPalindromes.isPalindrome(parseString, start, end)){
            palindromes.add(parseString);
        }
        if(start < end){
            operateString(mainString , start , end -1, palindromes);
            operateString(mainString , start +1 , end, palindromes);
        }
    }


    public static void main(String[] args) {
        String string = "bababa";
        final Set<String> palindromes = new HashSet<>();
        FindPalindromes.operateString(string, 0, string.length() -1, palindromes);
        System.out.println(palindromes);
    }
}


package slindingWindow2Pointer;

import java.util.HashMap;
import java.util.Map;

public class LL02_LongestSubStringNoRepetition {
    public static void main(String[] args) {
        char chars[]={'c','a','d','b','z','a','b','c','d'};

        int maxSubstringLength = longestSubStringWithNoRepetition(chars);
        System.out.println("Max Length: "+maxSubstringLength);
    }

    private static int longestSubStringWithNoRepetition(char[] chars) {
        Map<Character,Integer> charIndexMap = new HashMap<>();
        int leftIndex=0,rightIndex=0;
        int maxLength = 0;
        while (rightIndex<chars.length){
             Character presentChar = chars[rightIndex];
             if(charIndexMap.get(presentChar)!=null){
                int matchIndex = charIndexMap.get(presentChar);
                leftIndex = Math.max(matchIndex+1,leftIndex);
             }
             charIndexMap.put(presentChar,rightIndex);

             maxLength=Math.max(maxLength,rightIndex-leftIndex+1);
             rightIndex++;
        }
        return maxLength;
    }
}

//Mistake: Understand the significance of Line 22 i.e.,(leftIndex = Math.max(matchIndex+1,leftIndex);)
//Time Complexity:  As much as rightIndex  moved = O(n)
//Space Complexity: O(256) as there are only 256 chars in this world

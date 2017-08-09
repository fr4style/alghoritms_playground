package com.fflorio;

import java.util.HashSet;
import java.util.Set;

/**
 * ::GEMSTONES::
 * John has discovered various rocks. Each rock is composed of various elements, and each element is represented by a
 * lower-case Latin letter from 'a' to 'z'. An element can be present multiple times in a rock. An element is called a
 * gem-element if it occurs at least once in each of the rocks.
 *
 * Given the list of  rocks with their compositions, display the number of gem-elements that exist in those rocks.
 *
 * ::Input Format::
 *
 * The first line consists of an integer, , the number of rocks.
 * Each of the next  lines contains a rock's composition. Each composition consists of lower-case letters of English alphabet.
 *
 * ::Constraints::
 *
 * Each composition consists of only lower-case Latin letters ('a'-'z').
 * length of each composition
 *
 * ::Output Format::
 *
 * Print the number of gem-elements that are common in these rocks. If there are none, print 0.
 *
 * ::Sample Input::
 *
 * 3
 * abcdde
 * baccd
 * eeabg
 * Sample Output
 *
 * 2
 * ::Explanation::
 *
 * Only "a" and "b" are the two kinds of gem-elements, since these are the only characters that occur in every rock's composition.
 *
 * Solutions created by Francesco Florio
 * floriofrancesco@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        String[] arr = {
                "xyz",
                "baccd",
                "eeabg"
        };
        int result = gemstones(arr);
        System.out.println(result);
    }

    static int gemstones(String[] arr){
        if(arr == null || arr.length == 0) {
            return 0;
        }

        final Set<Character> commonChars = new HashSet<Character>();
        final Set<Character> tmpSet = new HashSet<Character>();

        for(int i=0; i<arr[0].length(); i++){
            commonChars.add(arr[0].charAt(i));
        }

        for(int i=1; i<arr.length && commonChars.size() > 0; i++){
            removeUncommonElements(commonChars, tmpSet, arr[i]);
        }

        return commonChars.size();
    }

    static void removeUncommonElements(final Set<Character> commonChars, final Set<Character> tempSet, final String currentComposition){
        tempSet.clear();
        Character currentCharacter;
        for(int i =0; i< currentComposition.length(); i++){
            currentCharacter = currentComposition.charAt(i);
            if(commonChars.contains(currentCharacter)){
                tempSet.add(currentCharacter);
            }
        }

        commonChars.clear();
        commonChars.addAll(tempSet);
    }
}

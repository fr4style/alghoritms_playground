package com.fflorio;

import com.fflorio.solutions.Alghoritm;
import com.fflorio.solutions.SimpleAlghoritm;

/**
 * :: ALTERNATING CHARACTERS ::
 *
 * You are given a string containing characters 'Aì and 'B' only, your task is to change it into a string such that
 * every two consecutive characters are different. To do this, you are allowed to delete one or more characters in the string.
 * Your task is to find the minimum number of required deletions.
 *
 * For example, string 'ABAA' should be changed to 'ABA' by deleting one character 'A'.
 *
 * :: Input ::
 * The first line contains an integer , i.e. the number of test cases.
 * The next  lines contain a string .
 *
 * :: Constraints ::
 * 1 <= t <= 10
 * 1 <= |s| <= 10^5
 *
 * :: Output Format ::
 * For each test case, print the minimum number of deletions required in a new line.
 *
 * :: Sample Input ::
 * 5
 * AAAA
 * BBBBB
 * ABABABAB
 * BABABA
 * AAABBB
 *
 * :: Solution ::
 * 3
 * 4
 * 0
 * 0
 * 4
 *
 * Solution by francesco on 2017-08-22.
 * floriofrancesco@gmail.com
 */

public class Main {

    public static void main(String[] args){
        final String[] input = {
            "AAAA",
            "BBBBB",
            "ABABABAB",
            "BABABA",
            "AAABBB",
            "ABABAABBA"
        };

        for(String currInput : input){
            solve(currInput, new SimpleAlghoritm());
        }
    }

    private static void solve(final String input, final Alghoritm... alghoritms){
        for(Alghoritm alghoritm : alghoritms){
            final int solution  = alghoritm.alterningCharacters(input);
            System.out.println(String.format("[%s] Solution for %s: %d", alghoritm.getLabel(), input, solution));
        }
    }

}

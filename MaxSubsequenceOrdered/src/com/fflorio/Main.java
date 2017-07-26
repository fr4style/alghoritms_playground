package com.fflorio;

import com.fflorio.alghoritms.DefaultAlghoritm;
import com.fflorio.alghoritms.FindSubsequenceOrderedAlghoritm;

import java.util.Arrays;

/**
 * Given an array, find the biggest subsequence of orderd items.
 * Created by Francesco Florio on 2017-07-26.
 * floriofrancesco@gmail.com
 */
public class Main {

    public static void main(String[] args){
        int[] input = { 1, 3, 6, 7, 8, 11, 12, 13, 14, 15, 20, 23};
        System.out.println("Input: "+ Arrays.toString(input));
        solve(input, new DefaultAlghoritm());
    }

    private static void solve(final int[] input, final FindSubsequenceOrderedAlghoritm... alghoritms){
        for(FindSubsequenceOrderedAlghoritm alghoritm : alghoritms){
            final Solution solution = alghoritm.findSubsequence(input);
            System.out.println("["+alghoritm.getLabel()+"] "+solution.toString());
        }
    }
}

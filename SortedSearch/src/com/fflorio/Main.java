package com.fflorio;

import com.fflorio.alghoritms.SortedSearchAlghoritm;
import com.fflorio.alghoritms.SortedSearchBinary;

import java.util.Arrays;
import java.util.Locale;

/**
 * Implement function countNumbers that accepts a sorted array of integers and counts the number of array elements
 * that are less than the parameter lessThan.
 * For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because there are two
 * array elements less than 4.
 * https://www.testdome.com/questions/java/sorted-search/9879?questionIds=9879,8733&generatorId=27&type=fromtest&testDifficulty=Hard
 *
 * Created by Francesco Florio on 2017-07-26.
 * floriofrancesco@gmail.com
 */
public class Main {

    public static void main(String[] args){
        final int[] inputArray = { 1, 3, 5, 7 };
        final int lessThan = 4;

        System.out.println(String.format(Locale.getDefault(), "Input: %s\nLess than: %s\n", Arrays.toString(inputArray), lessThan));
        solve(inputArray, lessThan, new SortedSearchBinary());
    }

    private static void solve(final int[] inputArray, final int lessThan, final SortedSearchAlghoritm... alghoritms){
        for(SortedSearchAlghoritm sortedSearchAlghoritm : alghoritms){
            final int output = sortedSearchAlghoritm.countNumbers(inputArray, lessThan);
            System.out.println(String.format(Locale.getDefault(), "[Alghoritm: %s] Solution is: %d\n",
                    sortedSearchAlghoritm.getLabel(), output));
        }
    }
}

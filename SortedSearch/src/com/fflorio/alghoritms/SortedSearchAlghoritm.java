package com.fflorio.alghoritms;

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
public interface SortedSearchAlghoritm {

    int countNumbers(int[] sortedArray, int lessThan);

    String getLabel();
}

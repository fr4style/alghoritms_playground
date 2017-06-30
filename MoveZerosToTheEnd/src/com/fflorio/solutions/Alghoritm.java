package com.fflorio.solutions;

/**
 * Created by francesco on 2017-06-29.
 */
public interface Alghoritm {

    /**
     * @param input the input array with 0 or more '0' values, that will be changed in the same array with the 0
     *              at the end, and the same order for the single items not 0
     * @return the number of 0's found
     */
    int solve(final int[] input);

    String label();
}

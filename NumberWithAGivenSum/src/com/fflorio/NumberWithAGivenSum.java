package com.fflorio;

import com.sun.tools.javac.util.Pair;

/**
 * Numbers with a Given Sum
 *
 * Given an increasingly sorted array and a number {@code s}, please find two numbers whose sum is {@code s}.
 * If there are multiple pairs with sum s, just output any one of them.
 *
 * For example, if the inputs are an array {1, 2, 4, 7, 11, 15} and a number 15,
 * please out two numbers 4 and 11 since 4+11=15.
 *
 * Created by francesco on 2017-06-14.
 */
interface NumberWithAGivenSum {

    /**
     *
     * @param input the input array of integer >= 0
     * @param sumToFind the sum to find
     * @return an {@code int[2]} containing the two value that added are the valueToFind
     */
    int[] solve(final int[] input, final int sumToFind);

    String label();
}

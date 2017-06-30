package com.fflorio.solutions;

/**
 * Created by francesco on 2017-04-26.
 */
public class SolutionV5 implements Solution {

    @Override
    public String label() {
        return "[V5]";
    }

    @Override
    public int findMissingValue(int[] collection) {
        long sum = collection.length+1;
        for(int i = 0; i < collection.length; i++){
           sum = sum + (i+1) - collection[i];
        }
        return (int)sum;
    }
}

package com.fflorio.solutions;

/**
 * Created by francesco on 2017-04-26.
 */
public class SolutionV2 implements Solution {

    @Override
    public String label() {
        return "[V2]";
    }

    @Override
    public int findMissingValue(int[] collection) {
        long sum = getTriangularNumber(collection.length+1);
        for(int item : collection){
            sum -= item;
        }
        return (int)sum;
    }

    private final long getTriangularNumber(final long n){
        long value = n * (n+1) / 2;
        return value;
    }
}

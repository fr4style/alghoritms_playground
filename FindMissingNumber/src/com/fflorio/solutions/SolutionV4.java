package com.fflorio.solutions;

import java.math.BigInteger;

/**
 * Created by francesco on 2017-04-26.
 */
public class SolutionV4 implements Solution {

    @Override
    public String label() {
        return "[V4]";
    }

    @Override
    public int findMissingValue(int[] collection) {
        BigInteger sum = getTriangularNumber(collection.length+1);
        for(int item : collection){
            sum = sum.subtract(BigInteger.valueOf(item));
        }
        return sum.intValue();
    }

    private final BigInteger getTriangularNumber(final long n){
        BigInteger bigN = BigInteger.valueOf(n);
        BigInteger bigNPlus1 = BigInteger.valueOf(n+1);
        return bigN.multiply(bigNPlus1).divide(BigInteger.valueOf(2));
    }
}

package com.fflorio.solutions;

/**
 * The idea is to use a number like a boolean array and use the XOR operator to removed the values found.
 * At the end of the first cycle, it's possible to convert the final value into the solution to the problem.
 * The side effect of this approach is the size of the collection, if it is too big, the {@code binaryNumber}
 * will be in overflow and the solution will be wrong.
 *
 * I'm open to improvements :)
 *
 * Created by Francesco Florio on 2017-04-25.
 * floriofrancesco@gmail.com
 *
 */
public class SolutionV1 implements Solution {

    @Override
    public String label() {
        return "[V1]";
    }

    @Override
    public int findMissingValue(final int[] collection){
        long binaryNumber = convertCollectionInABinaryNumber(collection.length);
        for(int i = 0; i< collection.length; i++){
            binaryNumber = binaryNumber ^ valueToPutInXor(collection[i]);
        }
        return convertBinaryNumberInDecimalNumber(binaryNumber);
    }

    /**
     * Calculate the number that in bit has the same size of the collection and all {@code 1}.
     * I.e. for a collection of {@code 4} elements, the result is {@code 15}, that in bit is {@code 1111}
     *
     * @param collectionSize the collection size
     * @return the number that in bit has the same size of the collection and all {@code 1}.
     */
    private static long convertCollectionInABinaryNumber(final int collectionSize){
        final double maxPowValue = Math.pow(2, collectionSize+1);
        if(Double.isInfinite(maxPowValue)){
            throw new RuntimeException("Invalid input, value too big");
        }
        return (long)(maxPowValue - 1);
    }

    private static long valueToPutInXor(final int collectionValue){
        return (long)(Math.pow(2, collectionValue - 1));
    }

    private static int convertBinaryNumberInDecimalNumber(final long binaryNumber){
        return log2(binaryNumber)+1;
    }
    private static int log2(long x) {
        return (int) (Math.log(x) / Math.log(2));
    }
}

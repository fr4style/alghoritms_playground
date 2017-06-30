package com.fflorio;

/**
 * Created by francesco on 2017-06-14.
 */
public class BooleanIndexAlgorithm implements NumberWithAGivenSum {

    @Override
    public int[] solve(int[] input, int sumToFind) {
        final int[] output = new int[2];

        int maxIndex = input[input.length-1];
        boolean[] existingItems = new boolean[maxIndex];
        for(int i=0; i<input.length-1; i++){
            existingItems[input[i]] = true;
        }

        for(int i=0; i<input.length; i++){
            output[0] = input[i];
            output[1] = sumToFind - input[i];
            if(isValidSolution(output[0], output[1], existingItems)){
                return output;
            }
        }

        return null;
    }

    private boolean isValidSolution(final int value1, final int value2, final boolean[] existingItems){
        return value2 > 0 &&  // the difference must be a positive value
               value1 != value2 && // I can't use two times the same value
               existingItems[value2]; //The value must exist
    }

    @Override
    public String label() {
        return "Boolean Index";
    }
}

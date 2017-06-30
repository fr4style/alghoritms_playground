package com.fflorio.solutions;

/**
 * Created by francesco on 2017-06-29.
 */
public class ArrayAlghoritm implements Alghoritm {

    @Override
    public int solve(int[] input) {
        if(input == null || input.length == 0){
            return 0;
        }
        
        final int inputSize = input.length;
        final int[] indexArray1Based = new int[inputSize];

        int nonZeroCount = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0) {
                indexArray1Based[nonZeroCount] = (i + 1);
                nonZeroCount++;
            }
        }

        for (int i = 0; i < nonZeroCount; i++) {
            if (i != (indexArray1Based[i] - 1)) {
                input[i] = input[indexArray1Based[i] - 1];
            }
        }

        for (int i = nonZeroCount; i < inputSize; i++) {
            input[i] = 0;
        }

        return inputSize - nonZeroCount;
    }

    @Override
    public String label() {
        return "Array Alghoritm";
    }
}

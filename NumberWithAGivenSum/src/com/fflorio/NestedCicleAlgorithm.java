package com.fflorio;

/**
 * Created by francesco on 2017-06-14.
 */
public class NestedCicleAlgorithm implements NumberWithAGivenSum {

    @Override
    public int[] solve(int[] input, int sumToFind) {
        final int[] output = new int[2];

        for(int i=0; i<input.length; i++){
            output[0] = input[i];
            int sum = 0;
            for(int j = i+1; j < input.length && sum <= sumToFind; j++){
                output[1] = input[j];
                sum = output[0] + output[1];
                if(sum == sumToFind){
                    return output;
                }
            }
        }

        return null;
    }

    @Override
    public String label() {
        return "NestedCycle";
    }
}

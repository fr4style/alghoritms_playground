package com.fflorio;

/**
 * Created by francesco on 2017-06-14.
 */
public class PointersAlgorithm implements NumberWithAGivenSum{
    @Override
    public int[] solve(int[] input, int sumToFind) {
        int i = 0;
        int j = input.length-1;

        while(j>i){
            int tmpSum = input[i] + input[j];
            if(tmpSum == sumToFind){
                return new int[]{input[i],input[j]};
            }else if(tmpSum < sumToFind){
                i++;
            }else{
                j--;
            }
        }
        return null;
    }

    @Override
    public String label() {
        return "Pointers";
    }
}

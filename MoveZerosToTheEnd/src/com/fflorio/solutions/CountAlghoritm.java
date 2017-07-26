package com.fflorio.solutions;

/**
 * Created by francesco on 2017-06-29.
 */
public class CountAlghoritm implements Alghoritm{

    @Override
    public int solve(int[] input) {
        int nZero = 0;

        for(int i=0; i<input.length; i++){
            if(input[i] == 0){
                nZero++;
            }


        }

        return nZero;
    }

    @Override
    public String label() {
        return "Count Alghoritm";
    }
}

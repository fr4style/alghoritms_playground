package com.fflorio.solutions;

/**
 * Created by francesco on 2017-06-29.
 */
public class IndexAlghoritm implements Alghoritm {

    @Override
    public int solve(int[] input) {
        int i = 0;
        int j = input.length - 1;
        int nZero = 0;
        do{
            if(input[i] != 0){
                i++;
            }
            else 
        }while (j > i);

        return nZero;
    }

    @Override
    public String label() {
        return "Index Alghoritm";
    }
}

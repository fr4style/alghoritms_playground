package com.fflorio.solutions;

/**
 * Created by francesco on 2017-06-29.
 */
public class IndexAlghoritm implements Alghoritm {

    @Override
    public int solve(int[] input) {
        if(input == null || input.length == 0){
            return 0;
        }

        final int inputSize = input.length;
        int i = 0;
        int k = 0;
        int zeroCounter = 0;
        for (;i < inputSize && k < inputSize; i++, k++){
            if(input[i] == 0){
                zeroCounter++;
                boolean isFound = false;
                for(k = i+1; k < inputSize && !isFound; k++) {
                    if(input[k] !=0 ){
                        int tmp = input[i];
                        input[i] = input[k];
                        input[k] = tmp;
                        isFound = true;
                    }
                    else{
                        zeroCounter++;
                    }
                }
            }
        }
        while(i < inputSize){
            input[i++] = 0;
        }
        return zeroCounter;
    }

    @Override
    public String label() {
        return "Index Alghoritm";
    }
}

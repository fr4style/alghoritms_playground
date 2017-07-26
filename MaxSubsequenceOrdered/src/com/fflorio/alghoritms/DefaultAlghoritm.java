package com.fflorio.alghoritms;

import com.fflorio.Solution;

/**
 * Created by francesco on 2017-07-26.
 */
public class DefaultAlghoritm implements FindSubsequenceOrderedAlghoritm {

    @Override
    public Solution findSubsequence(int[] input) {
        int currStart = 0;
        int currEnd = 0;
        int start = 0;
        int end = 0;

        for(int i = 1; i < input.length; i++){
            if(input[i-1]+1 == input[i]){
                currEnd = i;
            }else{
                if(currEnd - currStart > end - start){
                    start = currStart;
                    end = currEnd;
                }
                currStart = i;
                currEnd = i;
            }
        }

        if(currEnd - currStart > end - start){
            start = currStart;
            end = currEnd;
        }

        return new Solution(start, end, input[start], input[end]);
    }

    @Override
    public String getLabel() {
        return "Default alghoritm";
    }
}

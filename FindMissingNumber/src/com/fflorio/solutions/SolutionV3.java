package com.fflorio.solutions;

/**
 * Created by francesco on 2017-04-26.
 */
public class SolutionV3 implements Solution {

    @Override
    public String label() {
        return "[V3]";
    }

    @Override
    public int findMissingValue(int[] collection) {
        final boolean[] founded = new boolean[collection.length+1];
        for(int i = 0; i< collection.length; i++){
            final int index = collection[i]-1;
            founded[index] = true;
        }

        for(int i = 0; i< founded.length; i++){
            if(!founded[i]){
                return i+1;
            }
        }
        return 0;
    }
}

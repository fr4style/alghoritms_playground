package com.fflorio.solutions;

/**
 * Created by francesco on 2017-08-22.
 */
public class SimpleAlghoritmWithOutputLog implements Alghoritm {

    @Override
    public String getLabel() {
        return getClass().getSimpleName();
    }

    @Override
    public int alterningCharacters(String s) {
        if(s == null || s.length() <= 1){
            return 0;
        }

        final String input = s.toLowerCase();
        StringBuilder output = new StringBuilder();
        output.append(input.charAt(0));
        int currentCharacter = input.charAt(0);
        int nextIndex = 1;
        int deletedCount = 0;
        while(nextIndex < s.length()){
            char nextCharacter = input.charAt(nextIndex);
            if(currentCharacter != nextCharacter){
                output.append(nextCharacter);
                currentCharacter = nextCharacter;
            }else{
                deletedCount++;
            }
            nextIndex++;
        }
        System.out.println(String.format("\tInput: %s, Output: %s, Diff: %d",
                input.toUpperCase(), output.toString().toUpperCase(), deletedCount));
        return deletedCount;
    }
}

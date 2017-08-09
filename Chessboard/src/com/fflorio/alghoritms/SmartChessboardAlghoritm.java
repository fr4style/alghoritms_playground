package com.fflorio.alghoritms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by francesco on 2017-08-09.
 */
public class SmartChessboardAlghoritm implements ChessboardAlghoritm {

    @Override
    public int solve(String[] input) {
        final int N = input.length;
        final int totalSlots = N * N;
        final int secondChars = (totalSlots / 2);
        final int firstChars = secondChars + (totalSlots % 2);

        final Map<Character, Integer> counterForFirst = new HashMap<Character, Integer>();
        final Map<Character, Integer> counterForSecond = new HashMap<Character, Integer>();

        for(int i = 0; i < totalSlots; i++){
            final int row = i / N;
            final int column = i % N;
            addCharTo(isCounterForFirst(row, column) ? counterForFirst : counterForSecond,
                      getCharInPosition(input, row, column));
        }

        TempSolution maxForFirstChar = calculateTempSolution(counterForFirst);
        TempSolution maxForSecondChar = calculateTempSolution(counterForSecond);

        if(maxForFirstChar.character == maxForSecondChar.character){
            if(maxForFirstChar.occurences > maxForSecondChar.occurences){
                maxForSecondChar = calculateTempSolution(counterForSecond, maxForFirstChar.character);
            }else{
                maxForFirstChar = calculateTempSolution(counterForFirst, maxForSecondChar.character);
            }
        }

        return (firstChars - maxForFirstChar.occurences) + (secondChars - maxForSecondChar.occurences);
    }

    private TempSolution calculateTempSolution(Map<Character, Integer> currSolution){
        return calculateTempSolution(currSolution, null);
    }

    private TempSolution calculateTempSolution(Map<Character, Integer> currSolution, Character alreadyUsedChar){
        int maxOccurences = 0;
        Character maxCharacter = null;

        for(Character c : currSolution.keySet()){
            if(!c.equals(alreadyUsedChar)) {
                final int currOccurrences = currSolution.get(c);
                if (maxOccurences < currOccurrences) {
                    maxCharacter = c;
                    maxOccurences = currOccurrences;
                }
            }
        }

        return new TempSolution(maxOccurences, maxCharacter);
    }

    private boolean isCounterForFirst(final int row, final int column){
        return (row % 2 == 0) == (column % 2 == 0);
    }

    private void addCharTo(final Map<Character, Integer> collection, char character){
        if(!collection.keySet().contains(character)){
            collection.put(character, 1);
        }else{
            collection.put(character, collection.get(character)+1);
        }
    }

    private char getCharInPosition(final String[] input, final int row, final int column){
        return input[row].charAt(column);
    }

    @Override
    public String getLabel() {
        return "SmartChessboard";
    }

    class TempSolution{
        final int occurences;
        final char character;

        public TempSolution(int occurences, char character) {
            this.occurences = occurences;
            this.character = character;
        }
    }
}

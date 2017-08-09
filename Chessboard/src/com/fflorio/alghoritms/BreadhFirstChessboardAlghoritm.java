package com.fflorio.alghoritms;

import java.util.*;

/**
 * Created by francesco on 2017-08-09.
 */
public class BreadhFirstChessboardAlghoritm implements ChessboardAlghoritm {

    private List<String[]> toGenerate = new ArrayList<String[]>();

    @Override
    public String getLabel() {
        return "BreadhFirst";
    }

    @Override
    public int solve(String[] input) {
        //Invalid input
        if (input == null || input.length < 2 || input.length > 15) {
            return 0;
        }
        //Invalid input
        if (input.length != input[0].length()) {
            return 0;
        }

        final Set<Character> availableCharacters = generateAvailableCharacters(input);

        final List<Item> queue = new ArrayList<Item>();
        queue.add(new Item(input, 0, false));
        int numbersOfEditToCreateChessboard = -1;
        while (numbersOfEditToCreateChessboard < 0) {
            numbersOfEditToCreateChessboard = processItemInTheQueue(queue, availableCharacters);
        }
        return numbersOfEditToCreateChessboard;
    }

    private int processItemInTheQueue(List<Item> queue, Set<Character> availableCharacters) {
        if (queue.isEmpty()) {
            return -1;
        }
        Item currItem = queue.remove(0);
        String[] currInput = currItem.input;
        int level = currItem.level;
        boolean toExpand = currItem.toExpand;
        if(!toExpand) {
            if (isValidChessboard(currInput)) {
                return level;
            }
            queue.add(new Item(currItem.input, currItem.level, true));
        }else {
            generateSubLevels(currInput, level + 1, queue, availableCharacters);
        }
        return -1;
    }

    private void generateSubLevels(final String[] currInput, final int currLevel, List<Item> queue, Set<Character> availableCharacters){
        for(int i=0; i<currInput.length; i++){
            for(int j=0; j<currInput[0].length(); j++){
                Character currentChar = getChar(currInput, i, j);
                Character top = getChar(currInput, i-1, j);
                Character bottom = getChar(currInput, i+1, j);
                Character left = getChar(currInput, i, j-1);
                Character right = getChar(currInput, i, j+1);

                for(Character character : availableCharacters){
                    if(!character.equals(currentChar) && !character.equals(top) && !character.equals(bottom) &&
                            !character.equals(left) && !character.equals(right)){
                        final String[] newInput = currInput.clone();
                        newInput[i] = (newInput[i].substring(0,j))+character+(newInput[i].substring(j+1));
//                        System.out.println("[L #"+currLevel+"] Generated:\n "+ Arrays.toString(newInput));
                        queue.add(0, new Item(newInput, currLevel, false));
                    }
                }
            }
        }
//        System.out.println("Generated...");
    }

    private boolean isValidChessboard(String[] currentInput) {
        final Character x = getChar(currentInput, 0, 0);
        final Character y = getChar(currentInput, 0, 1);
        if (x.equals(y)) {
            return false;
        }

        Character currentCharacter;
        Character rightChar;
        Character bottomChar;
        Character expectedCharacter;

        for (int i = 0; i < currentInput.length; i++) {
            for (int j = 0; j < currentInput[i].length(); j++) {
                currentCharacter = getChar(currentInput, i, j);
                expectedCharacter = getExpectedCharacter(currentCharacter, x, y);
                rightChar = getChar(currentInput, i, j + 1);
                if (rightChar != null && !rightChar.equals(expectedCharacter)) {
                    return false;
                }

                bottomChar = getChar(currentInput, i + 1, j);
                if (bottomChar != null && !bottomChar.equals(expectedCharacter)) {
                    return false;
                }
            }
        }

        return true;
    }

    private Character getExpectedCharacter(Character currentChar, Character x, Character y) {
        return x.equals(currentChar) ? y : x;
    }

    private Character getChar(String[] currentInput, int i, int j) {
        if (i>=0 && i < currentInput.length && j>= 0 && j < currentInput[i].length()) {
            return currentInput[i].charAt(j);
        }
        return null;
    }

    private Set<Character> generateAvailableCharacters(final String[] input) {
        final Set<Character> characters = new HashSet<Character>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length(); j++) {
                characters.add(getChar(input, i, j));
            }
        }
        return characters;
    }

    private class Item{
        String[] input;
        int level;
        boolean toExpand;

        public Item(String[] input, int level, boolean toExpand) {
            this.input = input;
            this.level = level;
            this.toExpand = toExpand;
        }
    }
}

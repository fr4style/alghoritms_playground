package com.fflorio;

/**
 * The question is to reformat a number removing spaces and dash. The output is a string, grouping the number in sets of
 * three elements separated by a dash.
 * The last group (or the latest two groups) can be grouped by two.
 * 
 * Created by francesco on 2017-09-05.
 * floriofrancesco@gmail.com
 */
public class Main {

    public static void main(String[] args){
        final String[] inputs = {
                "00-44  48 5555 8361",
                "0 - 22 1985--324",
                "555372654",
                "12",
                "123-",
                "1 2 4 3"};

        final String[] outputs={
                "004-448-555-583-61",
                "022-198-53-24",
                "555-372-654",
                "12",
                "123",
                "12-43"
        };

        final Solution solution = new MySolution();
        for(int i =0; i<inputs.length; i++){
            final String o = solution.solve(inputs[i]);
            System.out.println(String.format("Input: '%s', Output: '%s', Expected: '%s', Is correct: '%s'",
                    inputs[i],
                    o,
                    outputs[i],
                    (o.equals(outputs[i]) ? "YES" : "NO")));
        }
    }

    private static class MySolution implements Solution {

        @Override public String solve(String S) {
            final StringBuilder stringBuilder = new StringBuilder();
            int digitCounter = 0;
            for (int i = 0; i < S.length(); i++) {
                final char currentChar = S.charAt(i);
                if (Character.isDigit(currentChar)) {
                    evaluateSeparator(stringBuilder, digitCounter);
                    stringBuilder.append(currentChar);
                    digitCounter++;
                }
            }

            if (digitCounter % 3 == 1) {
                groupLastTwoBlocks(stringBuilder);
            }

            return stringBuilder.toString();
        }

        private void groupLastTwoBlocks(final StringBuilder stringBuilder) {
            final int lastSeparatorPosition = stringBuilder.length() - 2;
            stringBuilder.deleteCharAt(lastSeparatorPosition);
            stringBuilder.insert(lastSeparatorPosition - 1, "-");
        }

        private void evaluateSeparator(final StringBuilder stringBuilder, final int digitCounter) {
            if (digitCounter > 0 && (digitCounter % 3) == 0) {
                stringBuilder.append("-");
            }
        }
    }

    private interface Solution {
        String solve(String input);
    }
}

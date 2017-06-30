package com.fflorio;

import com.fflorio.solutions.Alghoritm;
import com.fflorio.solutions.IndexAlghoritm;

import java.util.Arrays;
import java.util.Locale;

/**
 * Created by francesco on 2017-06-29.
 */
public class Main {

    public static void main(String[] args) {
        final int defaultInput[] = { 1, 0, 3, 4, 0, -1, 5, 0, 5, 0, 0, 0, 0, 2, 0 };
        System.out.println("Input: "+Arrays.toString(defaultInput)+"\n");

        solveWith(defaultInput, new IndexAlghoritm());
    }

    private static void solveWith(final int[] input, Alghoritm... algorithms){
        for(Alghoritm algorithm : algorithms){
            final int[] inputClone = input.clone();
            final long t1 = System.currentTimeMillis();
            final int zeroCount = algorithm.solve(inputClone);
            printOutput(algorithm.label(), inputClone, zeroCount, System.currentTimeMillis() - t1);
        }
    }

    private static void printOutput(final String label, final int[] output, final int zeroCount, final long elapsedTime){
        final String outputString=
                String.format(Locale.getDefault(), "%s: #%d zeros found in %d ms\n\t%s", label, zeroCount, elapsedTime, Arrays.toString(output));
        System.out.println(outputString);
    }

}

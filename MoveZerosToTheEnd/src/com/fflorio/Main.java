package com.fflorio;

import com.fflorio.solutions.Alghoritm;
import com.fflorio.solutions.ArrayAlghoritm;
import com.fflorio.solutions.IndexAlghoritm;

import java.util.Arrays;
import java.util.Locale;

/**
 * Created by francesco on 2017-06-29.
 */
public class Main {

    public static void main(String[] args) {
        final int defaultInput[] = { 1, 1, 0, 3, 4, 0, -1, 5, 0, 5, 0, 0, 0, 0, 2, 0 };
        final Alghoritm[] alghoritms = {new IndexAlghoritm(), new ArrayAlghoritm()};
        solveWith(defaultInput, alghoritms);
        solveWith(new int[]{0}, alghoritms);
        solveWith(new int[]{1}, alghoritms);
        solveWith(new int[10000], alghoritms);
        solveWith(null, alghoritms);
        solveWith(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, alghoritms);

    }

    private static void solveWith(final int[] input, Alghoritm... algorithms){
        System.out.println("Input: "+Arrays.toString(input)+"\n");
        for(Alghoritm algorithm : algorithms){
            final int[] inputClone = input == null ? null : input.clone();
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

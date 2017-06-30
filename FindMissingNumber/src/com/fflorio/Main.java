package com.fflorio;

import com.fflorio.helpers.CollectionHelper;
import com.fflorio.solutions.*;

import java.util.Arrays;

/**
 * The problem of the kata is to find the missing value in a unordered array.
 * The solution is into the {@code findMissingValue()} method.
 *
 * Created by Francesco Florio on 2017-04-25.
 * floriofrancesco@gmail.com
 */
public class Main {

    public static void main(String[] args){
        final int[] collection = new int[2000000];
        final int removedValue = CollectionHelper.fillArrayAndGetTheMissingValue(collection);
        System.out.println("Collection: "+ Arrays.toString(collection));
        System.out.println("Removed value: "+ removedValue);
        runAllSolutions(collection, new SolutionV1(), new SolutionV2(), new SolutionV3(), new SolutionV4(), new SolutionV5());
    }

    private static void runAllSolutions(final int[] collection, Solution... solutions){
        for(Solution solution : solutions) {
            final long t1 = System.currentTimeMillis();
            try {
                final int missingValue = solution.findMissingValue(collection);
                System.out.println(solution.label() + " The item missing is: " + missingValue + " (solution found in " + (System.currentTimeMillis() - t1) + " ms)");
            } catch (Exception e) {
                System.out.println(solution.label() + " not working with this input!");
            }
        }
    }

    private static Solution getDefaultSolution(){
        return new SolutionV2();
    }

}

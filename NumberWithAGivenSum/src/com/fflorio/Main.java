package com.fflorio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by francesco on 2017-06-14.
 */
public class Main {

    public static void main(String[] args){
        final int[] input= {1, 2, 4, 7, 11, 15};
        final int sum = 15;
        solveWith(input, sum, new NestedCicleAlgorithm(), new BooleanIndexAlgorithm(), new PointersAlgorithm());

        System.out.println("\n---- Random solution -----\n");

        final int MAX_VALUE = 10000000;
        final int SIZE = 1000000;
        final int[] randomInput = createRandomArray(MAX_VALUE, SIZE);
        final int randomSum = (int)(Math.random() * SIZE);
        System.out.println("Random Array: "+ Arrays.toString(randomInput));
        System.out.println("Random Sum: "+randomSum);
        solveWith(randomInput, randomSum, new NestedCicleAlgorithm(), new BooleanIndexAlgorithm(), new PointersAlgorithm());

        System.out.println("\n---- Worse case -----\n");

        solveWith(randomInput, 0, new NestedCicleAlgorithm(), new BooleanIndexAlgorithm(), new PointersAlgorithm());

    }

    private static void solveWith(final int[] input, final int sum, NumberWithAGivenSum... algorithms){
        for(NumberWithAGivenSum algorithm : algorithms){
            long t1 = System.currentTimeMillis();
            final int[] currentSolution = algorithm.solve(input, sum);
            printOutput(algorithm.label(), currentSolution, t1);
        }
    }

    private static void printOutput(final String label, final int[] solution, long t1){
        if(solution == null){
            System.out.println(label+": no solution found [execution time: "+(System.currentTimeMillis()-t1)+"ms]");
        }else{
            System.out.println(label+ " solution: "+solution[0]+", "+solution[1]+ " found in "+(System.currentTimeMillis()-t1)+"ms");
        }
    }

    private static int[] createRandomArray(final int maxValue, final int size){
        if(maxValue < size){
            throw new IllegalArgumentException("Required maxValue >= size");
        }

        final List<Integer> fullList = new ArrayList<Integer>(maxValue);
        for(int i = 0; i< maxValue; i++){
            fullList.add(i);
        }
        Collections.shuffle(fullList);
        final List<Integer> targetList = fullList.subList(0, size);
        Collections.sort(targetList);

        final int output[] = new int[size];
        for (int i=0; i<targetList.size(); i++) {
            output[i] = targetList.get(i);
        }
        return output;
    }
}

package com.fflorio.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by francesco on 2017-04-26.
 */
public class CollectionHelper {

    public static int fillArrayAndGetTheMissingValue(final int[] arrayToFill){
        List<Integer> fullList = fillInitialList(arrayToFill.length+1);
        Collections.shuffle(fullList);
        final int itemRemoved = fullList.remove(0);
        fillArrayWith(fullList, arrayToFill);
        return itemRemoved;
    }

    private static List<Integer> fillInitialList(final int size){
        List<Integer> fullList = new ArrayList<Integer>(size);
        for(int i = 0; i< size; i++){
            fullList.add(i+1);
        }
        return fullList;
    }

    private static int[] fillArrayWith(final List<Integer> values, final int[] arrayToFill){
        final int size = values.size();
        for(int i = 0; i<size; i++){
            arrayToFill[i] = values.get(i);
        }
        return arrayToFill;
    }
}

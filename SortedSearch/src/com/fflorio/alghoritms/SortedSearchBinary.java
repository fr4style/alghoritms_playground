package com.fflorio.alghoritms;

public class SortedSearchBinary implements SortedSearchAlghoritm {

    @Override
    public int countNumbers(int[] sortedArray, int lessThan) {
        if (sortedArray == null || sortedArray.length == 0) {
            return 0;
        }

        if (sortedArray[0] > lessThan) {
            return 0;
        }

        if (sortedArray[0] == lessThan) {
            return 0;
        }

        if (sortedArray[sortedArray.length - 1] < lessThan) {
            return sortedArray.length;
        }

        int start = 0;
        int end = sortedArray.length - 1;

        int target = 0;
        while (end >= start) {
            target = (start + end) / 2;
            if (sortedArray[target] == lessThan) {
                return target;
            } else if (sortedArray[target] < lessThan) {
                start = target + 1;
            } else {
                end = target - 1;
            }
        }

        return sortedArray[target] > lessThan ? target : target + 1;
    }

    @Override
    public String getLabel() {
        return "Sorted Search using BinarySearch";
    }
}

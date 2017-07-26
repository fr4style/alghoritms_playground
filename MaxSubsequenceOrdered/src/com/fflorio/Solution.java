package com.fflorio;

/**
 * Created by francesco on 2017-07-26.
 */
public class Solution {

    public final int indexStart;
    public final int indexEnd;
    public final int valueStart;
    public final int valueEnd;

    public Solution(int indexStart, int indexEnd, int valueStart, int valueEnd) {
        this.indexStart = indexStart;
        this.indexEnd = indexEnd;
        this.valueStart = valueStart;
        this.valueEnd = valueEnd;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "indexStart=" + indexStart +
                ", indexEnd=" + indexEnd +
                ", valueStart=" + valueStart +
                ", valueEnd=" + valueEnd +
                ", size=" + (indexEnd - indexStart + 1) +
                '}';
    }
}

package com.fflorio;

/**
 * Created by francesco on 2017-08-09.
 */
public class Input {
    public final int requiredSeats;
    public final int[][] seatPrices;
    public final int solution;

    public Input(int requiredSeats, int[][] seatPrices, int solution) {
        this.requiredSeats = requiredSeats;
        this.seatPrices = seatPrices;
        this.solution = solution;
    }
}

package com.fflorio.alghoritms;

/**
 * Created by francesco on 2017-08-09.
 */
public class MySeatAlghoritm implements SeatsAlghoritm {

    @Override
    public String getLabel() {
        return "MyAlghoritm";
    }

    @Override
    public int getMinPrice(int requiredSeats, int[][] seatPrices) {
        if(seatPrices == null || seatPrices.length == 0 || seatPrices[0].length < requiredSeats){
            return -1;
        }

        int minPrice = Integer.MAX_VALUE;
        int currentMinPrice;
        for(int i=0; i<seatPrices.length; i++){
            currentMinPrice = checkMinForSingleLine(requiredSeats, seatPrices[i]);
            if(currentMinPrice < minPrice){
                minPrice = currentMinPrice;
            }
        }

        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }

    private int checkMinForSingleLine(int requiredSeats, int[] seatLinePrices){
        int minPrice = Integer.MAX_VALUE;
        int tmpMinPrice;

        for(int i=0; i<seatLinePrices.length - (requiredSeats - 1); i++){
            tmpMinPrice = 0;
            for(int j = 0; j < requiredSeats && tmpMinPrice != -1; j++) {
                if (seatLinePrices[i + j] == -1) {
                    tmpMinPrice = -1;
                    i += j;
                } else {
                    tmpMinPrice += seatLinePrices[i + j];
                }
            }
            if(tmpMinPrice != -1 && tmpMinPrice < minPrice){
                minPrice = tmpMinPrice;
            }
        }
        return minPrice;
    }


}

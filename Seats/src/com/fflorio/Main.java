package com.fflorio;

import com.fflorio.alghoritms.MySeatAlghoritm;
import com.fflorio.alghoritms.SeatsAlghoritm;

import java.io.*;

/**
 ::SEATS::
 You and your group of friends are planning a holiday trip. You have already chosen the flight that's most suitable
 for you, but still haven't booked the exact seats.

 On the website of the airline you are provided with the seating plan of the plane. Each seat is either already booked
 (thus, unavailable), or there is a price for which you can book it. You want to book 'S' neighbouring seats (all on the
 same row, without any other people between any two of your group). Of course, you'd like to pay as little as possible.

 Let's for example assume that you and two other friends want to travel (thus S = 3), and the seating plan looks as
 follow (we'll denote unavailable seats with 'X'):

  X 42 13 17 23
 11 13  X 10 10
 14 12 15  X  X
 16 17 10 11 19
  X  X  X  X  X
  X 14 17  X 14

 There are 6 rows and 5 columns of seats in the plane. One way to select the seats is to choose three on the first row
 (paying either 42 + 13 +17 = 72 or 13 + 17 + 23 = 53). You cannot select three neighbouring seats on the second row.
 The optimal solution here would be to select 17 + 10 + 11 = 38 on the fourth row.

 ::Input::
 You will be provided an integer requiredSeats - the number of required seats, and a 2-dimensional matrix of numbers
 seatPrices[][] - the prices of the seats in the plane. An already taken (thus unavailable) seat will be indicated by
 the number -1.

 ::Output::
 Return an integer - the lowest price at which you can book requiredSeats neighbouring seats on the same row. If there
 are no such seats available in the entire plane, return -1 instead.

 ::Constraints::
 - 1 <= requiredSeats <= 100
 - The number of rows in seatPrices[][] will be between 1 and 100
 - The number of columns in the seatPrices[][] will be between 1 and 100
 - All rows in seatPrices[][] will contains the same number of elements
 - Each element of the seatPrices[][] will be between 1 and 10000, inclusive

 * Solutions created by Francesco Florio
 * floriofrancesco@gmail.com
 */
public class Main {

    public static void main(String[] args){

        Input[] inputs;
        try {
            inputs = loadInputs();
        }catch (Exception e){
            inputs = new Input[0];
        }

        int counter = 0;
        for(Input input : inputs){
            processInput(++counter, input,  new MySeatAlghoritm());
        }
    }

    private static void processInput(final int counter, Input input, SeatsAlghoritm... alghoritms){
        System.out.println("Test alghoritms for input #"+counter);
        for(SeatsAlghoritm alghoritm : alghoritms){
            int currentSolution = alghoritm.getMinPrice(input.requiredSeats, input.seatPrices);
            System.out.println(String.format("[%s] Expected solution: %d, Solution found: %d",
                    alghoritm.getLabel(), input.solution, currentSolution));
        }
    }

    private static Input[] loadInputs() throws IOException, NullPointerException, NumberFormatException{
        Input[] inputs = new Input[5];
        BufferedReader input;
        BufferedReader output;
        for(int i = 0; i<5; i++){
            input = new BufferedReader(new FileReader(String.format("resources/input00%d.txt", (i+1))));
            output = new BufferedReader(new FileReader(String.format("resources/output00%d.txt", (i+1))));
            int _requiredSeats = Integer.parseInt(input.readLine().trim());


            int _seatPrices_rows = 0;
            int _seatPrices_cols = 0;
            _seatPrices_rows = Integer.parseInt(input.readLine().trim());
            _seatPrices_cols = Integer.parseInt(input.readLine().trim());

            int[][] _seatPrices = new int[_seatPrices_rows][_seatPrices_cols];
            for(int _seatPrices_i=0; _seatPrices_i<_seatPrices_rows; _seatPrices_i++) {
                final String[] values = input.readLine().split(" ");
                for(int _seatPrices_j=0; _seatPrices_j<_seatPrices_cols; _seatPrices_j++) {
                    _seatPrices[_seatPrices_i][_seatPrices_j] = Integer.parseInt(values[_seatPrices_j]);

                }
            }
            inputs[i] = new Input(_requiredSeats, _seatPrices, Integer.parseInt(output.readLine()));
        }

        return inputs;
    }

}

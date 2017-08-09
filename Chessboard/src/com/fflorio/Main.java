package com.fflorio;

import com.fflorio.alghoritms.BreadhFirstChessboardAlghoritm;
import com.fflorio.alghoritms.ChessboardAlghoritm;
import com.fflorio.alghoritms.SmartChessboardAlghoritm;

/**
 :: CHESSBOARD ::
 You are given an array of strings with N elements, where every string contains N characters. This represents an N x N
 field of characters that you would like to turn into a chessboard pattern.

 A chessboard pattern means, that the field can contain only 2 different characters and a character cannot be next to
 or above/below the same character.
 Your task is to return with a number which represent the minimum number of character changes that is required to create
 a chessboard pattern on the character field (a change does not mean character swapping, you can replace a singular
 character with any arbitrary character, that represents 1 change).

 Please note that the origina input can contain more than 2 different characters, but a valid chessboard pattern only
 contains 2 different ones.

 ::Constraints::
 2 <= N <= 15

 ##Example 1##
 ::Input::
 2
 ab
 ba

 ::Output::
 0

 ::Explanation::
 The input is already has chessboard pattern

 ##Example 2##
 ::Input::
 5
 ababa
 bacab
 ababd
 babab
 ababa

 ::Output::
 2

 ::Explanation::
 By changing the 'c' to 'b' and 'd' to 'a' characters the input can be changed into chessboard pattern.

 ##Example 3##
 ::Input::
 3
 abc
 def
 ghi

 ::Output::
 7

 ::Explanation::
 A chessboard pattern can be made with any 2 characters


 Solutions created by Francesco Florio
 floriofrancesco@gmail.com
 */
public class Main {

    public static void main(String[] args) {
        final Input[] inputs = {
                new Input(new String[]{"ab", "ba"}, 0),
                new Input(new String[]{
                        "ababa",
                        "bacab",
                        "ababd",
                        "babab",
                        "ababa"}, 2),
                new Input(new String[]{ "abc", "def", "ghi"}, 7),
                new Input( new String[]{
                        "yyxyxy",
                        "yxyxyx",
                        "xyxyxy",
                        "yxyxyx",
                        "xyxyxy",
                        "yxyxyx"}, 1),
                new Input(new String[]{
                        "xyxyxy",
                        "yxyxyx",
                        "xyxyxy",
                        "yxyxyx",
                        "xyxyxy",
                        "yxyxyx"}, 0),
                new Input(new String[]{
                        "aaa",
                        "bab",
                        "aaa"}, 2)
        };

        int i = 0;
        for(Input input : inputs) {
            processInput(++i, input, /*new BreadhFirstChessboardAlghoritm(),*/ new SmartChessboardAlghoritm());
        }
    }

    private static void processInput(int inputIndex, Input input, ChessboardAlghoritm... alghoritms) {
        System.out.println("Test alghoritms for input #"+inputIndex);
        for(ChessboardAlghoritm chessboardAlghoritm : alghoritms) {
            int currentSolution = chessboardAlghoritm.solve(input.chessboard);
            System.out.println(String.format("[%s] Expected solution: %d, Solution found: %d",
                    chessboardAlghoritm.getLabel(), input.solution, currentSolution));
        }
    }

}

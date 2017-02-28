package com.company;

/**
 * Created by Anthony Vardaro on 2/17/2017.
 *
 */
import java.lang.StringBuilder;
public class MoveSequences {
  /*
    This method rotates a single face
   */
  public static char[][][] rotateFace(char[][][] cube, int face) {
    for(int i = 0; i < 2; i++) {

      char temp = cube[face][0][0];
      cube[face][0][0] = cube[face][0][1];
      cube[face][0][1] = cube[face][0][2];
      cube[face][0][2] = cube[face][1][2];
      cube[face][1][2] = cube[face][2][2];
      cube[face][2][2] = cube[face][2][1];
      cube[face][2][1] = cube[face][2][0];
      cube[face][2][0] = cube[face][1][0];
      cube[face][1][0] = temp;
    }
    return cube;
  }

  /*
    This method rotates a face in the opposite direction.
   */
  public static char[][][] rotatePrime(char[][][] cube, int face) {
    // Doing a 'prime' or 'inverse' move can be thought as moving the face in the normal direction three times
    // EX: U can be rotateFace(cube, 2) and U' can be rotatePrime(cube, 3)
    rotateFace(cube, face);
    rotateFace(cube, face);
    rotateFace(cube, face);
    return cube;
  }

  public static char[][][] move(char[][][] cube, String code, int times) {
    char[][][] referenceCube = cube;
    switch (code) {
      case "R":
        for(int i = 0; i < times; i++) {
          /*char[] temp = {
            referenceCube[5][2][0],
            referenceCube[5][1][0],
            referenceCube[5][0][0],

            referenceCube[0][0][2],
            referenceCube[0][1][2],
            referenceCube[0][2][2],

            referenceCube[1][0][2],
            referenceCube[1][1][2],
            referenceCube[1][2][2],

            referenceCube[2][0][2],
            referenceCube[2][1][2],
            referenceCube[2][2][2]
          };
          char[] change = {
            cube[0][0][2],
            cube[0][1][2],
            cube[0][2][2],
            cube[1][0][2],
            cube[1][1][2],
            cube[1][2][2],
            cube[2][0][2],
            cube[2][1][2],
            cube[2][2][2],
            cube[5][2][0],
            cube[5][1][0],
            cube[5][0][0]
          };
         *//* cube[0][0][2] = temp[0];
          cube[0][1][2] = temp[1];
          cube[0][2][2] = temp[2];

          cube[1][0][2] = temp[3];
          cube[1][1][2] = temp[4];
          cube[1][2][2] = temp[5];

          cube[2][0][2] = temp[6];
          cube[2][1][2] = temp[7];
          cube[2][2][2] = temp[8];

          cube[5][2][0] = temp[9];
          cube[5][1][0] = temp[10];
          cube[5][0][0] = temp[11];*//*

         for(int a = 0; i < 11; i++) {
           System.out.println("at this point we are assigning " + "change[a] " + change[a] + " to " + temp[a]);
           change[a] = temp[a];
         }

       *//*  String newSequence = String.valueOf(temp);
          System.out.println(newSequence);
          System.out.println(newSequence.charAt(0));
         for (int a = 0; a < 11; a++) {
           change[a] = newSequence.charAt(a);
         }*//*

        *//* String newSequence = "";
         StringBuilder sb = new StringBuilder(newSequence);
         for (int a = 0; a < temp.length; a++) {
           sb = sb.append(temp[a]);
           System.out.println("Current char " + sb);
           change[a] = sb.charAt(a);
         }
         System.out.println(sb);*//*

*/

          replace(cube, 0, 5, true, 2);
          rotatePrime(cube, 3);
        }

        break;
      case "R'":
        for(int i = 0; i < times; i++) {
          char[] temp = {
            cube[1][0][2],
            cube[1][1][2],
            cube[1][2][2],

            cube[2][0][2],
            cube[2][1][2],
            cube[2][2][2],

            cube[5][0][2],
            cube[5][1][2],
            cube[5][2][2],

            cube[0][0][2],
            cube[0][1][2],
            cube[0][2][2]
          };
          cube[0][0][2] = temp[0];
          cube[0][1][2] = temp[1];
          cube[0][2][2] = temp[2];

          cube[1][0][2] = temp[3];
          cube[1][1][2] = temp[4];
          cube[1][2][2] = temp[5];

          cube[2][0][2] = temp[6];
          cube[2][1][2] = temp[7];
          cube[2][2][2] = temp[8];

          cube[5][0][0] = temp[9];
          cube[5][1][0] = temp[10];
          cube[5][2][0] = temp[11];

          rotateFace(cube, 3);
        }
        break;
      case "U":
        for (int i = 0; i < times; i++) {
          char[] temp;
        }
    }
    return cube;
  }
  private static char[][][] replace(char[][][] cube, int startingColor, int endColor, boolean column, int rowOrColumn) {
    //this is so ugly and bad but idk how else to determine if a row or column is being replaced
    //TODO: rewrite this with a for loop

    if(column) {
      //its a column
      char[] startingColors = {
        cube[startingColor][0][rowOrColumn],
        cube[startingColor][1][rowOrColumn],
        cube[startingColor][2][rowOrColumn],
      };
      cube[endColor][0][rowOrColumn] = startingColors[0];
      cube[endColor][1][rowOrColumn] = startingColors[1];
      cube[endColor][2][rowOrColumn] = startingColors[2];
    }
    else {
      //its a row
      char[] startingColors = {
        cube[startingColor][rowOrColumn][0],
        cube[startingColor][rowOrColumn][1],
        cube[startingColor][rowOrColumn][2]
      };

      cube[endColor][rowOrColumn][0] = startingColors[0];
      cube[endColor][rowOrColumn][1] = startingColors[1];
      cube[endColor][rowOrColumn][2] = startingColors[2];
    }

    return cube;
  }
}

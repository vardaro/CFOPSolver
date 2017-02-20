package com.company;

import java.util.Scanner;

/**
 Created by Anthony Vardaro 2/17/2017
 This method collects the information about the cube in the unsolved state.
 The data for each face of the scramble is stored in a 2d character array.
 User inputs each face individually, row by row, left to right on each column
 separated by a single space.
 We cycle through each color by storing each 2d array inside a big 3d array that houses all of the faces.

 */
public class GetCubeInput {
  public static char[][][] getCubeInput() {

    Scanner s = new Scanner(System.in);
    //since its 3x3 the row and col can be equivalent and final
    final int GRID = 3;
    //create array of each color
    String[] colors = {"White", "Green", "Yellow", "Orange", "Red", "Blue"};
    char[][] whiteFace = new char[GRID][GRID];
    char[][] greenFace = new char[GRID][GRID];
    char[][] yellowFace = new char[GRID][GRID];
    char[][] orangeFace = new char[GRID][GRID];
    char[][] redFace = new char[GRID][GRID];
    char[][] blueFace = new char[GRID][GRID];
    char[][][] faceArrays = {whiteFace, greenFace, yellowFace, orangeFace, redFace, blueFace};

    //cycle through each color, collect input row by row
    for (int i = 0; i < faceArrays.length; i++) {
      System.out.println("\nInput your " + colors[i] + " face");
      //determines what row and column for index
      for (int row = 0; row < GRID; row++) {
        for (int col = 0; col < GRID; col++) {
          //get input and store it in the faceArrays[]
          faceArrays[i][row][col] = s.next().charAt(0);
        }
      }
    }
    return faceArrays;
  }
}

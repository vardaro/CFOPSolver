/**
 * Created by Anthony Vardaro 2/17/2017
 SOLVED STATE     FAKE INPUT
  w w w             w g o
  w w w             o w b
  w w w             g y g
  g g g             y o r
  g g g             r g b
  g g g             r w y
  y y y             g b o
  y y y             o y y
  y y y             r g b
  o o o             y r w
  o o o             y o r
  o o o             b w o
  r r r             w y g
  r r r             r r b
  r r r             o w b
  b b b             b o r
  b b b             g b w
  b b b             w g y

TEST INPUT SCRAMBLE
F' U' L2 R2 U B2 F2 U B2 D2 R2 F' D2 L2 D' R' B2 D L F
  b b r
  b w r
  y o o
  r w r
  g g r
  w y y
  w o y
  r y g
  w b b
  y w g
  y o o
  g b b
  g g g
  w r y
  o o r
  o w o
  y b r
  w g b
 */
package com.company;

public class Main {

  public static void main(String[] args) {
    // Get the unsolved cube
    //GetCubeInput gci = new GetCubeInput();
    //ValidateCube vc = new ValidateCube();
    //MoveSequences cube = new MoveSequences();
    //Cross cross = new Cross();
    char[][][] cube = GetCubeInput.getCubeInput();

    // Determine if the cube scramble is a valid cube


    if (ValidateCube.check(cube)) {
      // Solve Cube
      currentCube(cube);
      MoveSequences.move(cube, "R", 1);
      /*Cross.solve(cube);
      FirstTwoLayers.firstPair(cube);
      FirstTwoLayers.secondPair(cube);
      FirstTwoLayers.thirdPair(cube);
      FirstTwoLayers.fourthPair(cube);
      LastLayer.OLL(cube);
      LastLayer.PLL(cube);*/
      currentCube(cube);
    } else {
      System.out.println("\nInvalid cube\nTry Again");
    }
  }
  /*
    This method is for testing purposes only. It prints the current cube
   */
  private static void currentCube(char[][][] cube) {
    System.out.println("Current cube:");
    for(int i = 0; i < cube.length; i++) {
      System.out.println(cube[i][0]);
      System.out.println(cube[i][1]);
      System.out.println(cube[i][2]);
    }
  }
}


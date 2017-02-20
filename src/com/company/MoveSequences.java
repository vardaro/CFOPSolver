package com.company;

/**
 * Created by Anthony Vardaro on 2/17/2017.
 *
 */
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
          char[] temp = {
            cube[5][2][0],
            cube[5][1][0],
            cube[5][0][0],

            cube[0][0][2],
            cube[0][1][2],
            cube[0][2][2],

            cube[1][0][2],
            cube[1][1][2],
            cube[1][2][2],

            cube[2][0][2],
            cube[2][1][2],
            cube[2][2][2]
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

          cube[5][2][0] = temp[9];
          cube[5][1][0] = temp[10];
          cube[5][0][0] = temp[11];

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
    }
    return cube;
  }
}

package com.company;

/**
 * Created by Anthony Vardaro on 2/17/2017.
 *
 */
public class MoveSequences {
  private char[][][] cube;

  public MoveSequences(char[][][] cube) {
    this.cube = cube;
  }
  //This method rotates a single face
  public char[][][] rotateCCW(int face) {
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
  public char[][][] rotateCW(int face) {
    // Doing a 'prime' or 'inverse' move can be thought as moving the face in the normal direction three times
    // EX: U can be rotateFace(cube, 2) and U' can be rotatePrime(cube, 3)
    rotateCCW(face);
    rotateCCW(face);
    rotateCCW(face);
    return cube;
  }
  // All cube moves
  public char[][][] move(String code, int times) {
    switch (code) {
      case "R":
        for(int i = 0; i < times; i++) {
          char[] temp = {cube[5][0][0], cube[5][1][0], cube[5][2][0]};

          // yellow -> blue
          cube[5][0][0] = cube[2][2][2];
          cube[5][1][0] = cube[2][1][2];
          cube[5][2][0] = cube[2][0][2];

          // green -> yellow
          cube[2][0][2] = cube[1][0][2];
          cube[2][1][2] = cube[1][1][2];
          cube[2][2][2] = cube[1][2][2];

          // white -> green
          cube[1][0][2] = cube[0][0][2];
          cube[1][1][2] = cube[0][1][2];
          cube[1][2][2] = cube[0][2][2];

          // blue -> white
          cube[0][0][2] = temp[2];
          cube[0][1][2] = temp[1];
          cube[0][2][2] = temp[0];
          rotateCW(3);
        }
        break;
      case "R'":
        for(int i = 0; i < times; i++) {
          char[] temp = {cube[0][0][2], cube[0][1][2], cube[0][2][2]};

          // green -> white
          cube[0][0][2] = cube[1][0][2];
          cube[0][1][2] = cube[1][1][2];
          cube[0][2][2] = cube[1][2][2];

          // yellow -> green
          cube[1][0][2] = cube[2][0][2];
          cube[1][1][2] = cube[2][1][2];
          cube[1][2][2] = cube[2][2][2];

          // blue -> yellow
          cube[2][0][2] = cube[5][2][0];
          cube[2][1][2] = cube[5][1][0];
          cube[2][2][2] = cube[5][0][0];

          // white -> blue
          cube[5][0][0] = temp[2];
          cube[5][1][0] = temp[1];
          cube[5][2][0] = temp[0];
          rotateCCW(3);
        }
        break;
      case "L":
        for (int i = 0; i < times; i++) {
          char[] temp = {cube[0][0][0], cube[0][1][0], cube[0][2][0]};

          // green -> white
          cube[0][0][0] = cube[1][0][0];
          cube[0][1][0] = cube[1][1][0];
          cube[0][2][0] = cube[1][2][0];

          // yellow -> green
          cube[1][0][0] = cube[2][0][0];
          cube[1][1][0] = cube[2][1][0];
          cube[1][2][0] = cube[2][2][0];

          // blue -> yellow
          cube[2][0][0] = cube[5][2][2];
          cube[2][1][0] = cube[5][1][2];
          cube[2][2][0] = cube[5][0][2];

          // white -> blue
          cube[5][2][2] = temp[0];
          cube[5][1][2] = temp[1];
          cube[5][0][2] = temp[2];
          rotateCCW(4);
        }
        break;
      case "L'":
        for(int i = 0; i < times; i++) {
          char[] temp = {cube[0][0][0], cube[0][1][0], cube[0][2][0]};

          // blue -> white
          cube[0][0][0] = cube[5][2][2];
          cube[0][1][0] = cube[5][1][2];
          cube[0][2][0] = cube[5][0][2];

          // yellow -> blue
          cube[5][2][2] = cube[2][0][0];
          cube[5][1][2] = cube[2][1][0];
          cube[5][0][2] = cube[2][2][0];

          // green -> yellow
          cube[2][0][0] = cube[1][0][0];
          cube[2][1][0] = cube[1][1][0];
          cube[2][2][0] = cube[1][2][0];

          // white -> green
          cube[1][0][0] = temp[0];
          cube[1][1][0] = temp[1];
          cube[1][2][0] = temp[2];
          rotateCW(4);
        }
        break;
      case "U":
        for(int i = 0; i < times; i++) {
          char[] temp = {cube[1][0][0], cube[1][0][1], cube[1][0][2]};

          // orange -> green
          cube[1][0][0] = cube[3][0][0];
          cube[1][0][1] = cube[3][0][1];
          cube[1][0][2] = cube[3][0][2];

          // blue -> orange
          cube[3][0][0] = cube[5][0][0];
          cube[3][0][1] = cube[5][0][1];
          cube[3][0][2] = cube[5][0][2];

          // red -> blue
          cube[5][0][0] = cube[4][0][0];
          cube[5][0][1] = cube[4][0][1];
          cube[5][0][2] = cube[4][0][2];

          // green -> red
          cube[4][0][0] = temp[0];
          cube[4][0][1] = temp[1];
          cube[4][0][2] = temp[2];
          rotateCW(2);
        }
        break;
      case "U'":
        for(int i = 0; i< times;i++) {
          char[] temp = {cube[1][0][0], cube[1][0][1], cube[1][0][2]};

          // red -> green
          cube[1][0][0] = cube[4][0][0];
          cube[1][0][1] = cube[4][0][1];
          cube[1][0][2] = cube[4][0][2];

          // blue -> red
          cube[4][0][0] = cube[5][0][0];
          cube[4][0][1] = cube[5][0][1];
          cube[4][0][2] = cube[5][0][2];

          // orange -> blue
          cube[5][0][0] = cube[3][0][0];
          cube[5][0][1] = cube[3][0][1];
          cube[5][0][2] = cube[3][0][2];

          // green -> orange
          cube[3][0][0] = temp[0];
          cube[3][0][1] = temp[1];
          cube[3][0][2] = temp[2];
          rotateCCW(2);
        }
        break;
      case "D":
        for(int i = 0; i < times; i++) {
          char[] temp = {cube[1][2][0], cube[1][2][1], cube[1][2][2]};

          // red -> green
          cube[1][2][0] = cube[4][2][0];
          cube[1][2][1] = cube[4][2][1];
          cube[1][2][2] = cube[4][2][2];

          // blue -> red
          cube[4][2][0] = cube[5][2][0];
          cube[4][2][1] = cube[5][2][1];
          cube[4][2][2] = cube[5][2][2];

          // orange -> blue
          cube[5][2][0] = cube[3][2][0];
          cube[5][2][1] = cube[3][2][1];
          cube[5][2][2] = cube[3][2][2];

          // green -> orange
          cube[3][2][0] = temp[0];
          cube[3][2][1] = temp[1];
          cube[3][2][2] = temp[2];
          rotateCW(0);
        }
        break;
      case "D'":
        for(int i = 0; i<times; i++) {
          char[] temp = {cube[1][2][0], cube[1][2][1], cube[1][2][2]};

          // orange -> green
          cube[1][2][0] = cube[3][2][0];
          cube[1][2][1] = cube[3][2][1];
          cube[1][2][2] = cube[3][2][2];

          // blue -> orange
          cube[3][2][0] = cube[5][2][0];
          cube[3][2][1] = cube[5][2][1];
          cube[3][2][2] = cube[5][2][2];

          // red -> blue
          cube[5][2][0] = cube[4][2][0];
          cube[5][2][1] = cube[4][2][1];
          cube[5][2][2] = cube[4][2][2];

          // green -> red
          cube[4][2][0] = temp[0];
          cube[4][2][1] = temp[1];
          cube[4][2][2] = temp[2];
          rotateCCW(0);
        }
        break;
      case "F'":
        for(int i = 0; i < times; i++) {
          char[] temp = {cube[0][0][0], cube[0][0][1], cube[0][0][2]};

          // red -> white
          cube[0][0][0] = cube[4][0][2];
          cube[0][0][1] = cube[4][1][2];
          cube[0][0][2] = cube[4][2][2];

          // yellow -> red
          cube[4][0][2] = cube[2][2][2];
          cube[4][1][2] = cube[2][2][1];
          cube[4][2][2] = cube[2][2][0];

          // orange -> yellow
          cube[2][2][2] = cube[3][2][0];
          cube[2][2][1] = cube[3][1][0];
          cube[2][2][0] = cube[3][0][0];

          // white -> orange
          cube[3][2][0] = temp[0];
          cube[3][1][0] = temp[1];
          cube[3][0][0] = temp[2];
          rotateCCW(1);
        }
        break;
      case "F":
        for(int i = 0; i < times; i++) {
          char[] temp = {cube[0][0][0], cube[0][0][1], cube[0][0][2]};

          // orange -> white
          cube[0][0][0] = cube[3][2][0];
          cube[0][0][1] = cube[3][1][0];
          cube[0][0][2] = cube[3][0][0];

          // yellow -> orange
          cube[3][2][0] = cube[2][2][2];
          cube[3][1][0] = cube[2][2][1];
          cube[3][0][0] = cube[2][2][0];

          // red -> yellow
          cube[2][2][2] = cube[4][0][2];
          cube[2][2][1] = cube[4][1][2];
          cube[2][2][0] = cube[4][2][2];

          // white -> red
          cube[4][0][2] = temp[0];
          cube[4][1][2] = temp[1];
          cube[4][2][2] = temp[2];
          rotateCW(1);
        }
        break;
      case "B":
        for(int i = 0; i < times; i++) {
          char[] temp = {cube[2][0][0], cube[2][0][1], cube[2][0][2]};

          // orange -> yellow
          cube[2][0][0] = cube[3][0][2];
          cube[2][0][1] = cube[3][1][2];
          cube[2][0][2] = cube[3][2][2];

          // white -> orange
          cube[3][0][2] = cube[0][2][2];
          cube[3][1][2] = cube[0][2][1];
          cube[3][2][2] = cube[0][2][0];

          // red -> white
          cube[0][2][2] = cube[4][2][0];
          cube[0][2][1] = cube[4][1][0];
          cube[0][2][0] = cube[4][0][0];

          // yellow -> red
          cube[4][2][0] = temp[0];
          cube[4][1][0] = temp[1];
          cube[4][0][0] = temp[2];
          rotateCW(5);
        }
        break;
      case "B'":
        for(int i = 0; i < times; i++) {
          char[] temp = {cube[2][0][0], cube[2][0][1], cube[2][0][2]};

          cube[2][0][0] = cube[4][2][0];
          cube[2][0][1] = cube[4][1][0];
          cube[2][0][2] = cube[4][0][0];

          cube[4][2][0] = cube[0][2][2];
          cube[4][1][0] = cube[0][2][1];
          cube[4][0][0] = cube[0][2][0];

          cube[0][2][2] = cube[3][0][2];
          cube[0][2][1] = cube[3][1][2];
          cube[0][2][0] = cube[3][2][2];

          cube[3][0][2] = temp[0];
          cube[3][1][2] = temp[1];
          cube[3][2][2] = temp[2];
          rotateCCW(5);
      }
    }
    return cube;
  }
  public char[][][] algorithm(String algorithm) {
    // Break up the algorithm
    String[] moves = algorithm.split(" ");

    // Assume each move is 1, unless otherwise called as 2
    String sequence;
    int times;
    // Iterate through each move
    for (int i = 0; i<moves.length; i++) {
      times = 1;
      sequence = moves[i];

      // Determine if move is a 2
      if (moves[i].contains("2")) {
        times = 2;
        sequence = Character.toString(moves[i].charAt(0));
        System.out.println(times);
      }
      System.out.println(sequence + times);
      move(sequence, times);
    }
    return cube;
  }
}

package com.company;

/**
 * Created by Anthony Vardaro on 2/17/2017.
 */
public class Cross {
  public static char[][][] solve(char[][][] cube){
    MoveSequences.move(cube, "R", 1);
    return cube;
  }
}

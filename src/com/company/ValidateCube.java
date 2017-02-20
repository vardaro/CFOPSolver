package com.company;

/**
 Created by Anthony Vardaro 2/17/2017
 This method checks for:
 Whether the input doesn't contain abstract chars (ex: u, k, q)
 Whether the input has no repeated center piece
 Whether the input has 4 edge pieces for each color
 Whether the input has 4 corner pieces for each color
 */
public class ValidateCube {
  public static boolean check(char[][][] cube) {

    // This is used to determine whether the user input the colors in the correct order.
    String centerpieceTest = "";
    StringBuilder sb = new StringBuilder(centerpieceTest);

    // Used to determine if the cube contains the correct number of edge and corner pieces.
    int[] indexEdgeCorner = {
      0, // white
      0, // green
      0, // yellow
      0, // orange
      0, // red
      0  // blue
    };

    // Loop through every char in the 3d array.
    for (int depth = 0; depth < cube.length; depth++) {
      for (int row = 0; row < cube[depth].length; row++) {
        for (int col = 0; col < cube[depth][row].length; col++) {
          // Currently tested char
          char currentChar = cube[depth][row][col];

          // The first test checks to see if the input contains all valid chars(r b g o w y) and if each color has the right amount of occurrences(9)
          // If the currentChar is invalid, validCube() returns false.
          if (currentChar != 'w' &&
            currentChar != 'g' &&
            currentChar != 'y' &&
            currentChar != 'o' &&
            currentChar != 'r' &&
            currentChar != 'b') {
            System.out.println("ERROR: Abstract character '" + currentChar + "'");
            return false;
          }

          // Start building string for Test #2
          if (row == 1 && col == 1) {
            centerpieceTest = sb.append(currentChar).toString();
          }

          // Collect number of each color in input
          // Each number in the array should equal 9 (1 center + 4 edges + 4 corners)
          switch (currentChar) {
            case 'w':
              indexEdgeCorner[0]++;
              break;
            case 'g':
              indexEdgeCorner[1]++;
              break;
            case 'y':
              indexEdgeCorner[2]++;
              break;
            case 'o':
              indexEdgeCorner[3]++;
              break;
            case 'r':
              indexEdgeCorner[4]++;
              break;
            case 'b':
              indexEdgeCorner[5]++;
              break;
          }
        }
      }
    }

    // Check if colors are input in the correct order
    if (!centerpieceTest.equals("wgyorb")) {
      System.out.println("\nERROR: Colors were input in wrong order.");
      return false;
    }

    // Check for correct amount of each color
    for (int i = 0; i < indexEdgeCorner.length; i++) {
      // Finds a color that occurs more than 9 times.
      if (indexEdgeCorner[i] != 9) {
        String errorColor = null;
        // Determine the incorrect color
        switch (i) {
          case 0:
            errorColor = "WHITE";
            break;
          case 1:
            errorColor = "GREEN";
            break;
          case 2:
            errorColor = "YELLOW";
            break;
          case 3:
            errorColor = "ORANGE";
            break;
          case 4:
            errorColor = "RED";
            break;
          case 5:
            errorColor = "BLUE";
            break;
        }
        // Print error message and return false
        System.out.println("ERROR: Incorrect amount(" + indexEdgeCorner[i] + ") " + errorColor + " pieces.");
        return false;
      }
    }
    // Input has passed each test
    return true;
  }
}

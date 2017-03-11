package com.company;

/**
 * Created by Anthony Vardaro on 2/17/2017.
 *
 * The general practice in solving a white cross is first to identify the edge pieces already oriented
 * on its corresponding center, if there are any at all.
 *
 * If you have at least one edge piece already oriented, you can orient and permute the remaining
 * edge pieces around that already solved edge piece.
 * For Example:
 * We have a scramble where the white/red edge is oriented properly however it's permuted on the opposite
 * side. The logical solution (since white/red is on its opposite) is orient all the other edge pieces on
 * their corresponding opposite. So if white/red is aligned on orange, white/orange should align with red,
 * white/green should align with blue, and white/blue should align with green. After orienting each piece,
 * we can permute the edge pieces with a "D2" move (assuming the cross is on the bottom).
 *
 * We are calling a method which checks the white side for any oriented edge pieces, because those make building
 * the cross much easier. If we don't find any on the white side, skip this algorithm and solve the cross by
 * searching for edge pieces that are already oriented but not on the white side.
 */

import static com.company.Algorithms.*;

public class Cross {

  // Heres what a solved cross looks like
  private static final String solvedCross = "wgwrwowb";

  // All adjacents are written in their appearance of top, left, right, bottom
  private static int[] sideAdjacents = {
    // white
    1,4,3,5,
    // green
    2,4,3,0,
    // yellow
    5,4,3,2,
    // orange
    2,1,5,0,
    // red
    2,5,1,0,
    // blue
    2,3,0,4
  };
  public static char[][][] solve(char[][][] crossCube) {
    MoveSequences cube = new MoveSequences(crossCube);

    char[] unsolvedCrossArray = {
      // Green White edge
      crossCube[0][0][1],
      crossCube[1][2][1],

      // Red White edge
      crossCube[0][1][0],
      crossCube[4][2][1],

      // Orange White edge
      crossCube[0][1][2],
      crossCube[3][2][1],

      // Blue White edge
      crossCube[0][2][1],
      crossCube[5][2][1],
    };
    String inputCross = new String(unsolvedCrossArray);

    // Determine if cross is already solved
    if (!inputCross.equals(solvedCross)) {
      // Solve cross

      // Identify the edge pieces
      // TODO: figure out way to implement something that ignore previously stored edges
      int[] firstEdge = findEdgePieces(crossCube,1);
      int[] secondEdge = findEdgePieces(crossCube,2);
      int[] thirdEdge = findEdgePieces(crossCube,3);
      int[] fourthEdge = findEdgePieces(crossCube,4);
      for(int i = 0; i < firstEdge.length; i++) {
        System.out.print(firstEdge[i]);
      }



    } else {
      System.out.println("Cube is already solved!");
      return crossCube;
    }
    return crossCube;
  }
  /* This method searches for the white edge pieces used to build a cross */
  private static int[] findEdgePieces(char[][][] cube, int whichEdge) {
    // Loop through every sticker
    int whiteEdges = 0;
    for (int side = 0; side < cube.length; side++) {
      for (int row = 0; row < cube[side].length; row++) {
        for (int col = 0; col < cube[side][row].length; col++) {
          // Determine if the currentChar is a white edge piece
          char currentChar = cube[side][row][col];
          if ((currentChar == 'w') && isEdgePiece(row, col)) {
            // The char is indeed a white edge piece so now we identify its adjacent
            int[] edge = {side,row,col};
            int[] adjacent = adjacent(side,row,col);
            // return index of the white sticker and adjacent sticker
            return new int[] {edge[0],edge[1],edge[2],adjacent[0],adjacent[1],adjacent[2]};
          } else {
            whiteEdges++;
          }
        }
      }
    }
    return null;
  }
  /* This method just checks if the row and col values logically yield an edge piece */
  private static boolean isEdgePiece(int row, int col) {
    // ew
    return (row == 0 && col == 1) || (row == 1 && col == 0) || (row == 1 && col == 2) || (row == 2 && col == 1);
  }
  /* Determines adjacent of edge piece */
  private static int[] adjacent(int side, int row, int col) {
    int startingAdj = side*4; // Because there are four possible adjacents for each side
    int[] adjPattern = edgeLocation(side);
    switch (row) {
      case 0:
        // top
        return new int[]{sideAdjacents[startingAdj], adjPattern[0], adjPattern[1]};
      case 1:
        // left or right
        return (col == 0) ? new int[]{sideAdjacents[startingAdj + 1], adjPattern[2], adjPattern[3]} : new int[]{sideAdjacents[startingAdj + 2], adjPattern[4], adjPattern[5]};
      case 2:
        // bottom
        return new int[] {sideAdjacents[startingAdj + 3],adjPattern[6],adjPattern[7]};
    }
    return null;
  }
  /* Determines location of edge and what the row and col should be for the adjacent */
  private static int[] edgeLocation(int side) {
    // Every possible row and column configuration. row/col
    // configurations can be grouped together. White and yellow are the only exceptions
    int[] white = {2,1,2,1,2,1,2,1};
    int[] yellow = {0,1,0,1,0,1,0,1};
    int[] GreenBlueRedOrange = {2,1,1,2,1,0,0,1};
   // System.out.println("side is: "+side);

    return  (side == 0) ? white : (side == 2) ? yellow : GreenBlueRedOrange;
   /* switch (side) {
      case 0:return white;
      case 2:return yellow;
      default:return GreenBlueRedOrange;
    }*/
  }
}

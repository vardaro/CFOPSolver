# CFOPSolver
<b>This is still a work in progress</b>

Hello!

This is a personal project of mine that solves a 3x3 Rubiks cube using the advanced 4-step CFOP method.
The goal is not to solve the cube in the fewest moves possible, the program is meant to solve it using only the CFOP method.
The purpose is to help users understand CFOP as it is very difficult to wrap you head around at first.
<br>C: Cross (White only)
<br>F: First Two Layers (F2L)
<br>O: Orientation of Last Layer (OLL)
<br>P: Permutation of Last Layer (PLL)

Instructions: 
<br>Know that the centerpiece color of each face predetermines the color of that in the solved state
<br>When solving, the cube must be positioned so that the white face is is facing downward and the green face is facing you
<br>When inputting a cube face, you must input row by row.
<br>'w' = white, 'g' = green, 'b' = blue, 'r' = red, 'o' = orange, 'y' = yellow
<br>Do not rotate the cube when inputting the scramble. Input must White facing down, Green facing you
<br>A single space separates each character, otherwise your input will not be accepted
<br>Ex:
<br>Row 1: w y w
<br>Row 2: y w g
<br>Row 3: o b b
<br>NOTE: Notice how we can infer that this is going to be the white face when in the solved state because the centerpiece is white.

Restrictions:
<br>Cross on the bottom and is done only on the white face facing down and green face facing you
<br>F2L is algorithmic, not intuitive.
<br>2-Look Last Layer meaning one algorithm for OLL and PLL each

Enjoy!

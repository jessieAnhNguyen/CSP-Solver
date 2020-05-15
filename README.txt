CSC 242: Introduction to Artificial Intelligence

Collaborators: Anh Nguyen, Phuong Vu
NetIDs: anguy39, pvu3

Project 2 - Constraint Satisfaction Problems

Compiling instruction: either use the IntelliJ IDE (recommended) as we mainly developed our project using this tool, or in your terminal type
javac *.java then java Main

We are not able to fill in the checkboxes in the submission form. However, we did use good object-oriented design to avoid giant main method 
and use instance variables correctly.

Folders and files included:
1. Arc: each problem has its own implementation of arc - this is used for implementing the AC-3 algorithm.
2. Backtracking Search: contains the implementation of backtrack search and AC-3 algorithm. We have abstract AC-3 method but do specific 
implementation (albeit not too different in essence) for each problem.
3. Constraint: each problem has its own type of constraint defined
4. CSP: implementation of CSP for each problem. All classes extends from the CSP abstract class
5. Domains: determine the domain values for each problem
6. Solutions: contains the solution for each problem 
7. Variables: define how variables in each problem is represented.

Our program contains careful instructions along the way. 

In the beginning, press 1,2,3,4,5 to see the problem statement as well as the solution to each problem. If you wish to try another problem, press y. Else
press n. 









### Collaborators: Anh Nguyen, Phuong Vu

# Project - Constraint Satisfaction Problems (CSP)

## I/ How to run the project:
1. Compiling instruction: assume you're in the directory of "src", compile: javac *.java
2. Running instruction: java Main
3. Testing intruction: Press 1,2,3,4,5 to see the problem statement as well as the solution to each problem. If you wish to try another problem, press y. Else press n. 

## II/ Contraint Satisfaction Problems description:
This Project builds a general engine to solve different Constraint Satisfaction Problems. Read more about CSP in this Wikipedia link: [Constraint Satisfaction Problems](https://en.wikipedia.org/wiki/Constraint_satisfaction)

The problems used for the testing are described below:
Citation: Russell & Norvig, Artificial Intelligence: A Modern Approach, 3rd ed.

1. Australia Map Coloring: We are looking at a map of Australia showing each of its states and territories. Image: Australia Map.png. We are given the task of coloring each region either red, green, or blue in such a way that no neighboring regions have the same color.

![Australian Map Problem](https://media.cheggcdn.com/study/c82/c82fd142-abed-4624-8259-65c3832e0b24/7445-6-1EEI1.png)

2. Job Shop Scheduling Problem: Factories have the problem of scheduling a day’s worth of jobs, subject to various constraints.Consider the problem of scheduling the assembly of a car. The whole job is composed of tasks, and we can model each task as a variable, where the value of each variable is the time that the task starts, expressed as an integer number of minutes. Constraints can assert that one task must occur before another—for example, a wheel must be installed before the hubcap is put on—and that only so many tasks can go on at once. Constraints can also specify that a task takes a certain amount of time to complete.

3. n-Queens Problem: The goal of the n-Queens problem is to place n number of Queens on a chessboard such that no queen attacks any other. (A queen attacks any piece in the same row, column or diagonal.)
![N Queens Problem](https://miro.medium.com/max/878/1*419mKEAl_KQej239rT72eg.png)

4. Problem 2: Y = X^2, solve this using AC-3 algorithm

5. Mackworth (1977) Problem: There are five variables, X1, X2, X3, X4, X5. The domains of D1 and D2 are {a, b, c} and the domains of D3, D4, D5 are {a, b}. The constraints are that X1 < X3, X2 < X3, X4 < X3, X5 < X3, and X4 < X5, where “<” means lexicographic (alphabetical) ordering. Detect that this problem is inconsistent.

## III/ Folders and files included:
1. Arc: each problem has its own implementation of arc - this is used for implementing the AC-3 algorithm.
2. Backtracking Search: contains the abstract implementation of backtrack search and AC-3 algorithm. This is the engine to solve every CSP. We have abstract AC-3 method but do specific implementation (albeit not too different in essence) for each problem.
3. Constraint: each problem has its own type of constraint defined
4. CSP: implementation of CSP for each problem. All classes extends from the CSP abstract class
5. Domains: determine the domain values for each problem
6. Solutions: contains the solution for each problem 
7. Variables: define how variables in each problem is represented.

## IV/ CSP Solver explained:
I used backtracking search (link to read in Wikipedia: [Back Tracking Search](https://en.wikipedia.org/wiki/Backtracking), and AC-3 algorithm (link to read in Wikipedia: [AC-3 Algorithm](https://en.wikipedia.org/wiki/AC-3_algorithm) as an approach to solve CSP.
More information on how I solve the problem, read the image: "CSP Explained.jpg" in the same directory.









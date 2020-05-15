package Solutions;

import BacktrackingSearch.Problem4Search;
import CSP.Problem4CSP;
import Domains.Problem4Value;
import Variables.Problem4Var;

import java.util.HashMap;
public class Problem4Solution {
    /**
     * Represent a solution to the Problem 4
     */
    public Problem4Solution(int num) {
        Problem4CSP problem4CSP = new Problem4CSP(num);
        Problem4Search problem4Search = new Problem4Search();
        HashMap<Problem4Var, Problem4Value> problem4assignment = new HashMap<>();
        if (problem4Search.AC_3(problem4CSP)) {
            System.out.println();
            System.out.println("The domain for each variable after AC-3 is:");
            for (int i=0; i<problem4CSP.variables.size(); i++){
                System.out.print(problem4CSP.variables.get(i).name + ": { ");
                for (int j=0; j<problem4CSP.domains.get(problem4CSP.variables.get(i)).size(); j++){
                    if (j != problem4CSP.domains.get(problem4CSP.variables.get(i)).size() - 1){
                        System.out.print(problem4CSP.domains.get(problem4CSP.variables.get(i)).get(j).integer + ", ");
                    }
                    else{
                        System.out.print(problem4CSP.domains.get(problem4CSP.variables.get(i)).get(j).integer);
                    }
                }
                System.out.println("}");
                System.out.println();
            }
            problem4assignment = problem4Search.BT(problem4CSP);
            printProblem4Solution(problem4assignment, problem4CSP);
        }
        else{
            System.out.println("The problem 4 is unsolvable!");
        }
    }

    //print out the solution for Australia Map Problem
    static void printProblem4Solution(HashMap<Problem4Var, Problem4Value> problem4assignment, Problem4CSP Problem4CSP) {
        System.out.println();
        System.out.print("The solution is: ");
        System.out.print("{");

        System.out.print(Problem4CSP.variables.get(0).name + " : " + problem4assignment.get(Problem4CSP.variables.get(0)).integer);
        System.out.print(", " + Problem4CSP.variables.get(1).name + " : "+ problem4assignment.get(Problem4CSP.variables.get(1)).integer);
        System.out.print("}");
    }
}


package Solutions;

import BacktrackingSearch.MackworthSearch;
import CSP.MackworthCSP;
import Domains.MackworthValue;
import Variables.MackworthVar;

import java.util.HashMap;

public class MackworthSolution {
    /**
     * Represent a solution to the Mackworth Problem
     */
    public MackworthSolution() {
        MackworthCSP mackworthCSP = new MackworthCSP();
        MackworthSearch mackworthSearch = new MackworthSearch();
        HashMap<MackworthVar, MackworthValue> mackworthAssignment = new HashMap<>();
        if (mackworthSearch.AC_3(mackworthCSP)) {
            mackworthAssignment = mackworthSearch.BT(mackworthCSP);
            printProblem4Solution(mackworthAssignment, mackworthCSP);
        }
        else {
            System.out.println();
            System.out.println("The domain for each variable after AC-3 is:");
            for (int i=0; i<mackworthCSP.variables.size(); i++){
                System.out.print(mackworthCSP.variables.get(i).name + ": { ");
                for (int j=0; j<mackworthCSP.domains.get(mackworthCSP.variables.get(i)).size(); j++){
                    System.out.print(mackworthCSP.domains.get(mackworthCSP.variables.get(i)).get(j).val + ", ");
                }
                System.out.println("}");
                System.out.println();
            }
            System.out.println("The Macworth problem is unsolvable!");
        }
    }

    //print out the solution for Australia Map Problem
    static void printProblem4Solution(HashMap<MackworthVar, MackworthValue> mackworthAssignment, MackworthCSP mackworthCSP) {
        System.out.println();
        System.out.println("This is the size of assignment " + mackworthAssignment.size());

        System.out.print("The solution is: ");
        System.out.print("{");

        System.out.print(mackworthCSP.variables.get(0).name + " : " + mackworthAssignment.get(mackworthCSP.variables.get(0)).val);
        for (int i = 1; i < mackworthCSP.variables.size(); i++){
            System.out.print(", " + mackworthCSP.variables.get(i).name + " : "+ mackworthAssignment.get(mackworthCSP.variables.get(1)).val);
        }
        System.out.print("}");
    }
}



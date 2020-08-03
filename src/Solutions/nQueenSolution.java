package Solutions;

import BacktrackingSearch.nQueenSearch;
import CSP.nQueensCSP;
import Domains.nQueensValue;
import Variables.JobShopVar;
import Variables.nQueensVar;

import java.util.HashMap;

public class nQueenSolution {
    int num;
    /**
     * Represent a solution to the n-Queens Problem
     */
    public nQueenSolution(int num){
        nQueensCSP nQueensCSP = new nQueensCSP(num);
        nQueenSearch nQueenSearch = new nQueenSearch();
        HashMap<nQueensVar, nQueensValue> nQueenAssign = new HashMap<>();

        if (nQueenSearch.AC_3(nQueensCSP)){
//            System.out.println();
//            System.out.println("The domain for each variable after AC-3 is:");
//            for (int i=0; i< nQueensCSP.variables.size(); i++){
//                System.out.print(nQueensCSP.variables.get(i).name + ": { ");
//                for (int j=0; j<nQueensCSP.domains.get(nQueensCSP.variables.get(i)).size(); j++){
//                    System.out.print(nQueensCSP.domains.get(nQueensCSP.variables.get(i)).get(j).row + ", ");
//                }
//                System.out.println("}");
//                System.out.println();
//            }
            nQueenAssign = nQueenSearch.BT(nQueensCSP);
            printnQueenAssignment(nQueenAssign, nQueensCSP);
        }
        else{
            System.out.println("The nQueen problem is unsolvable!");
        }
    }

    //print out the solution for N-Queen Problems
    static void printnQueenAssignment(HashMap<nQueensVar, nQueensValue> nQueenAssign, nQueensCSP nQueensCSP) {
        System.out.println();
        System.out.println("One solution is: ");
        //System.out.print("{");
        //System.out.print(nQueensCSP.variables.get(0).name + ":" + "(" + nQueenAssign.get(nQueensCSP.variables.get(0)).row + "," + nQueensCSP.variables.get(0).index + ")");
        for (int i = 0; i < nQueensCSP.variables.size(); i++) {
            System.out.println(nQueensCSP.variables.get(i).name + ": " + "(" + nQueenAssign.get(nQueensCSP.variables.get(i)).row + "," + nQueensCSP.variables.get(i).index + ")");
        }
        //System.out.print("}");
    }
}


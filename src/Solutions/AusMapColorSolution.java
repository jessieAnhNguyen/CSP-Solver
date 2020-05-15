package Solutions;

import BacktrackingSearch.AustraliaMapSearch;
import CSP.AusMapColorCSP;
import Domains.AusMapColorValue;
import Variables.AusMapColorVar;

import java.util.HashMap;
public class AusMapColorSolution {
    /**
     * Represent a solution to the Australian Map Problem
     */
    public AusMapColorSolution() {
        AusMapColorCSP ausMapColorCSP = new AusMapColorCSP();
        AustraliaMapSearch australiaMapSearch = new AustraliaMapSearch();
        HashMap<AusMapColorVar, AusMapColorValue> ausMapAssignment = new HashMap<>();
        if (australiaMapSearch.AC_3(ausMapColorCSP)) {
            System.out.println();
            System.out.println("The domain for each variable after AC-3 is:");
            for (int i=0; i<ausMapColorCSP.variables.size(); i++){
                System.out.print(ausMapColorCSP.variables.get(i).name + ": { ");
                for (int j=0; j<ausMapColorCSP.domains.get(ausMapColorCSP.variables.get(i)).size(); j++){
                    System.out.print(ausMapColorCSP.domains.get(ausMapColorCSP.variables.get(i)).get(j) + ", ");
                }
                System.out.println("}");
                System.out.println();
            }
            ausMapAssignment = australiaMapSearch.BT(ausMapColorCSP);
            printAusMapSolution(ausMapAssignment, ausMapColorCSP);
        }
        else{
            System.out.println("The Australian Map Coloring problem is unsolvable!");
        }
    }

    //print out the solution for Australia Map Problem
    static void printAusMapSolution(HashMap<AusMapColorVar, AusMapColorValue> ausMapAssignment, AusMapColorCSP AusMapColorCSP) {
        System.out.println();
        System.out.print("The solution is: ");
        System.out.print("{");
        System.out.print(AusMapColorCSP.variables.get(0).name + " : " + colorToString(ausMapAssignment.get(AusMapColorCSP.variables.get(0))));
        for (int i = 1; i < AusMapColorCSP.variables.size(); i++) {
            System.out.print(", " + AusMapColorCSP.variables.get(i).name + " : " + colorToString(ausMapAssignment.get(AusMapColorCSP.variables.get(i))));
        }
        System.out.print("}");
    }

    //convert the Color to string
    static String colorToString(AusMapColorValue val){
        switch (val) {
            case BLUE:
                return "Blue";
            case RED:
                return "Red";
            case GREEN:
                return "Green";
        }
        return null;
    }
}


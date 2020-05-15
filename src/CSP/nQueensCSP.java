package CSP;

import Constraint.nQueensConstraints;
import Domains.nQueensValue;
import Variables.nQueensVar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class nQueensCSP extends CSP<nQueensVar,nQueensValue,nQueensConstraints> {
    /**
     * Abstract class to represent n-Queens CSP problem
     */
    public int numOfQueens;

    public nQueensCSP(int numOfQueens) {
        this.numOfQueens = numOfQueens;

        variables = new ArrayList<>();
        domains = new HashMap<>();
        constraints = new ArrayList<>();

        // initialize variables
        // Q1 to Qn, n being the number of queens
        for (int i = 1; i <= numOfQueens; i++) {
            variables.add(new nQueensVar("Q" + i,i));
        }

        // initialize domains
        for (nQueensVar variable : variables) {
            List<nQueensValue> domain = new ArrayList<>();
            for (int col = 1; col <= numOfQueens; col++) {
                domain.add(new nQueensValue(col));
            }
            domains.put(variable,domain);
        }

        // initialize constraints
        // the constraints state that all n queens does not attack each other pairwise
        for (int i = 0; i < numOfQueens; i++) {
            for (int j = i+1; j < numOfQueens; j++) {
                constraints.add(new nQueensConstraints(variables.get(i), variables.get(j)));
            }
        }

        printProblem();
    }

    // print the variables, domains and constraints of nQueens
    @Override
    public void printProblem() {
        System.out.printf("The index on the board start from 1 to %d\n", numOfQueens);
        System.out.print("There are " + this.variables.size() + " variables: ");
        System.out.print("{");
        System.out.print(variables.get(0).name);
        for (int i = 1; i < variables.size(); i++) {
            System.out.print(", " + variables.get(i).name);
        }
        System.out.print("}");
        System.out.println();
        System.out.print("The domain values for each variable is: {1");
        for (int i = 2; i <= numOfQueens; i++) {
            System.out.print("," + i);
        }
        System.out.println("}");
        System.out.print("There are " + this.constraints.size() + " constraints");
        if (constraints.size() > 0) {
            System.out.print(":{");
            System.out.print(constraints.get(0).var1.name + " X " + constraints.get(0).var2.name);
            for (int i = 1; i < constraints.size(); i++) {
                System.out.print(", " + constraints.get(i).var1.name + " X " + constraints.get(i).var2.name);
            }
            System.out.println("}");
            System.out.println("Note: The symbol \"X\" means \"does not attack\"");
            System.out.println("For example: \"Q1 X Q2\" means Q1 does not attack Q2");
        }
    }
}

package CSP;

import Constraint.Problem4Constraints;
import Domains.Problem4Value;
import Variables.Problem4Var;

import java.util.*;

public class Problem4CSP extends CSP<Problem4Var, Problem4Value, Problem4Constraints> {
    /**
     * Abstract class to represent problem 4 CSP
     */
    int num;
    public Problem4CSP(int num) {
        this.num = num;
        variables = new ArrayList<Problem4Var>();
        domains = new HashMap<>();
        constraints = new ArrayList<>();

        // initialize the variables X and Y
        variables.add(new Problem4Var("X"));
        variables.add(new Problem4Var("Y"));

        //initialize the domain values
        for (int i = 0; i < variables.size(); i++) {
            ArrayList<Problem4Value> domain = new ArrayList<>();
            for (int j = 0; j <= num; j++) {
                domain.add(new Problem4Value(j));
            }
            // set the domain values of each variable to be list of numbers
            domains.put(variables.get(i), domain);
        }
        //initialize constraints
        constraints.add(new Problem4Constraints(variables.get(0), variables.get(1)));
        printProblem();
    }


    @Override
    public void printProblem() {
        System.out.print("There are " + this.variables.size() + " variables: ");
        System.out.print("{");
        System.out.print(variables.get(0).name);
        for (int i = 1; i < variables.size(); i++) {
            System.out.print(", " + variables.get(i).name);
        }
        System.out.print("}");
        System.out.println();
        System.out.println("The domain values for each variable is: ");
        System.out.print("{");
        for (int i = 0; i < num; i++) {
            System.out.print(i + ", ");
        }
        System.out.print(num);
        System.out.println("}");
        System.out.print("There are " + this.constraints.size() + " constraint: ");
        System.out.print(constraints.get(0).var1.name + " = " + constraints.get(0).var2.name + "^2");
    }
}

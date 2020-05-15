package CSP;

import Constraint.MackworthConstraint;
import Domains.MackworthValue;
import Variables.MackworthVar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MackworthCSP extends CSP<MackworthVar, MackworthValue, MackworthConstraint> {
    /**
     * Abstract class to represent Mackworth CSP problem
     */
    public MackworthCSP() {
        variables = new ArrayList<MackworthVar>();
        domains = new HashMap<>();
        constraints = new ArrayList<>();

        //initialize the variables
        variables.add(new MackworthVar("X1"));
        variables.add(new MackworthVar("X2"));
        variables.add(new MackworthVar("X3"));
        variables.add(new MackworthVar("X4"));
        variables.add(new MackworthVar("X5"));

        //initialize the domain values
        for (int i = 0; i < variables.size(); i++) {
            List<MackworthValue> domain = new ArrayList<>();
            if ((i == 0) || (i == 1)) {
                domain.add(new MackworthValue('a'));
                domain.add(new MackworthValue('b'));
                domain.add(new MackworthValue('c'));
                domains.put(variables.get(i), domain);
            } else {
                domain.add(new MackworthValue('a'));
                domain.add(new MackworthValue('b'));
                domains.put(variables.get(i), domain);
            }
        }

        //initialize constraints
        constraints.add(new MackworthConstraint(variables.get(0), variables.get(2)));
        constraints.add(new MackworthConstraint(variables.get(1), variables.get(2)));
        constraints.add(new MackworthConstraint(variables.get(3), variables.get(2)));
        constraints.add(new MackworthConstraint(variables.get(4), variables.get(2)));
        constraints.add(new MackworthConstraint(variables.get(3), variables.get(4)));
        printProblem();
    }

    // print the variables, domain values as well as the constraints
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

        System.out.println("The domain values for the first two variable is: {a, b, c}");
        System.out.println("The domain values for next three variable is: {a, b}");

        System.out.print("There are " + this.constraints.size() + " constraints:");
        System.out.print("{");
        System.out.print(constraints.get(0).var1.name + " < " + constraints.get(0).var2.name);
        for (int i = 1; i < constraints.size(); i++) {
            System.out.print(", " + constraints.get(i).var1.name + " < " + constraints.get(i).var2.name);
        }
        System.out.print("}");
    }
}


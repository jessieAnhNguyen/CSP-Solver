package CSP;

import Constraint.AusMapColorConstraints;
import Domains.AusMapColorValue;
import Variables.AusMapColorVar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AusMapColorCSP extends CSP<AusMapColorVar, AusMapColorValue, AusMapColorConstraints> {
    /**
     * Abstract class to represent Australian Map CSP problem
     */
    public AusMapColorCSP() {
        variables = new ArrayList<AusMapColorVar>();
        domains = new HashMap<>();
        constraints = new ArrayList<>();

        //initialize the variables corresponding to Australian states
        variables.add(new AusMapColorVar("SA"));
        variables.add(new AusMapColorVar("WA"));
        variables.add(new AusMapColorVar("NT"));
        variables.add(new AusMapColorVar("Q"));
        variables.add(new AusMapColorVar("NSW"));
        variables.add(new AusMapColorVar("V"));
        variables.add(new AusMapColorVar("T"));

        //initialize the domain values
        for (int i = 0; i < variables.size(); i++){
            List<AusMapColorValue> domain = new ArrayList<>();
            domain.add(AusMapColorValue.RED);
            domain.add(AusMapColorValue.BLUE);
            domain.add(AusMapColorValue.GREEN);
            // set the domain values of each variable to be RED, GREEN and BLUE
            domains.put(variables.get(i),domain);
        }


        //initialize constraints
        // SA is adjacent to all states but T, so there need to be constraints that color of SA does not match all those adjacent states
        AusMapColorConstraints c = new AusMapColorConstraints(variables.get(0), variables.get(1));
        //variables.get(0).addConstraint(c);
        //variables.get(1).addConstraint(c);
        constraints.add(c);

        constraints.add(new AusMapColorConstraints(variables.get(0), variables.get(2)));
        constraints.add(new AusMapColorConstraints(variables.get(0), variables.get(3)));
        constraints.add(new AusMapColorConstraints(variables.get(0), variables.get(4)));
        constraints.add(new AusMapColorConstraints(variables.get(0), variables.get(5)));
        // WA is adjacent to NT, so they can't have the same color
        constraints.add(new AusMapColorConstraints(variables.get(1), variables.get(2)));
        // NT is adjacent to Q, so they can't have the same color
        constraints.add(new AusMapColorConstraints(variables.get(2), variables.get(3)));
        // Q is adjacent to NSW so they can't have the same color
        constraints.add(new AusMapColorConstraints(variables.get(3), variables.get(4)));
        // NSW is adjacent to V so they can't have the same color
        constraints.add(new AusMapColorConstraints(variables.get(4), variables.get(5)));

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
        System.out.println("The domain values for each variable is {RED,GREEN,BLUE}");
        System.out.print("There are " + this.constraints.size() + " constraints:");
        System.out.print("{");
        System.out.print(constraints.get(0).var1.name + " != " + constraints.get(0).var2.name);
        for (int i = 1; i < constraints.size(); i++) {
            System.out.print(", " + constraints.get(i).var1.name + " != " + constraints.get(i).var2.name);
        }
        System.out.print("}");
    }
}

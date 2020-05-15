package CSP;

import java.util.HashMap;
import java.util.List;

// general abstract class for other specific problems to implement
public abstract class CSP<Variables, Domains, Constraint> {
    /**
     * Abstract class to represent a CSP problem
     */

    // T for a csp problem are stored in a list of T type
    public List<Variables> variables;

    // domains for a csp problem are stored in a HashMap
    // this indicates the assignment of domain values to T
    public HashMap<Variables, List<Domains>> domains;

    // constraints for a csp problem are stored in a list of Constraints type
    public List<Constraint> constraints;

    //print the domain values and constraints of a csp
    public abstract void printProblem();
}


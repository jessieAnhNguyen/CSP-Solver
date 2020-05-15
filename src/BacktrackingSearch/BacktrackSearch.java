package BacktrackingSearch;

import CSP.CSP;

import java.util.*;

public abstract class BacktrackSearch<Problem extends CSP<Variable, DomainValue, Constraint>, Variable, DomainValue, Constraint> {
    /**
     * The general implementation for Back Track Search
     **/

    /*
    Backtracking method: work for all problems. Return the Assignment for Problem if possible
     */
    public HashMap<Variable, DomainValue> BT(Problem csp) {
        HashMap<Variable, DomainValue> assignments = new HashMap<>();
        return backtrack(assignments, csp);
    }

    //return null = return failure
    public HashMap<Variable, DomainValue> backtrack(HashMap<Variable, DomainValue> assignments, Problem csp) {
        if (isComplete(assignments, csp)) return assignments;

        Variable var = selectUnassignedVariable(assignments, csp);
        for (DomainValue value : csp.domains.get(var)){
            if (value != null) {
                if (isConsistent(var, value, assignments, csp)) {
                    assignments.put(var, value);
                    HashMap<Variable, DomainValue> result = backtrack(assignments, csp);
                    if (result != null) {
                        return result;
                    } else {
                        assignments.remove(var);
                    }
                }
            }
        }
        return null;
    }

    //AC_3 method for inference
    public abstract boolean AC_3(Problem csp);

    //check if the assignment have completed
    public abstract boolean isComplete(HashMap<Variable, DomainValue> assignments, Problem csp);

    //select the Unassigned Variable
    public abstract Variable selectUnassignedVariable(HashMap<Variable, DomainValue> assignments, Problem csp);

    //check the Constraints to see if the Assignment satisfies
    public abstract boolean isConsistent(Variable variable, DomainValue valueAssigning, HashMap<Variable, DomainValue> assignments, Problem csp);
}


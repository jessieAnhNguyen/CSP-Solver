package BacktrackingSearch;

import CSP.nQueensCSP;
import Constraint.nQueensConstraints;
import Domains.AusMapColorValue;
import Domains.nQueensValue;
import Variables.nQueensVar;
import Arc.nQueensArc;

import java.util.*;

public class nQueenSearch extends BacktrackSearch<nQueensCSP, nQueensVar, nQueensValue, nQueensConstraints> {
    /**
     * The implementation for n-Queen Problem (problem 3)
     **/
    @Override
    public boolean isComplete(HashMap<nQueensVar, nQueensValue> assignments, nQueensCSP csp) {
        return (assignments.size() == csp.variables.size());
    }

    @Override
    public nQueensVar selectUnassignedVariable(HashMap<nQueensVar, nQueensValue> assignments, nQueensCSP csp) {
        for (nQueensVar variable : csp.variables)
            if (!assignments.containsKey(variable))
                return variable;
        return null;
    }

    @Override
    public boolean isConsistent(nQueensVar nQueensVar, nQueensValue valueAssigning, HashMap<nQueensVar, nQueensValue> assignments, nQueensCSP csp) {
        for (nQueensConstraints constraint : csp.constraints) {
            int col1 = nQueensVar.index;
            int row1 = valueAssigning.row;
            if (constraint.var1 == nQueensVar) {
                if (assignments.get(constraint.var2) == null) continue;
                else {
                    int col2 = constraint.var2.index;
                    int row2 = assignments.get(constraint.var2).row;
                    if (checkAttacking(col1, row1, col2, row2)) return false;
                }
            } else if (constraint.var2 == nQueensVar) {
                if (assignments.get(constraint.var1) == null) continue;
                else {
                    int col2 = constraint.var1.index;
                    int row2 = assignments.get(constraint.var1).row;
                    if (checkAttacking(col1, row1, col2, row2)) return false;
                }
            }
        }
        return true;
    }

    public boolean checkAttacking(int col1, int row1, int col2, int row2){
        if (col1 == col2) return true;
        if (row1 == row2) return true;
        if (Math.abs(row1 - row2) == Math.abs(col1 - col2)) return true;
        return false;
    }

    /*
   Implement AC_3 method
    */
    @Override
    public boolean AC_3(nQueensCSP csp) {
        if(csp.numOfQueens == 2) {
            return false;
        }
        ArrayDeque<nQueensArc> queue = new ArrayDeque<>();
        List<nQueensArc> arcs = new ArrayList<>();

        for (nQueensConstraints constraint: csp.constraints){
            nQueensArc arc1 = new nQueensArc(constraint.var1, constraint.var2, true);
            nQueensArc arc2 = new nQueensArc(constraint.var2, constraint.var1, false);
            arcs.add(arc1);
            arcs.add(arc2);
            queue.add(arc1);
            queue.add(arc2);
        }
        while (!queue.isEmpty()){
            nQueensArc currArc = queue.removeFirst();
            if (revise(csp, currArc.varX, currArc.varY)){
                if (csp.domains.get(currArc.varX).isEmpty()){
                    return false;
                }
                for (nQueensArc arc: arcs){
                    if ((arc.varY.equals(currArc.varX)) && (!arc.varX.equals(currArc.varY))){
                        queue.add(arc);
                    }
                }
            }
        }
        return true;
    }

    public boolean revise(nQueensCSP csp, nQueensVar var1, nQueensVar var2) {
        boolean revised = false;
        Iterator iter = csp.domains.get(var1).iterator();
        while(iter.hasNext()){
            boolean ok = false;
            nQueensValue value1 = (nQueensValue) iter.next();
            for (nQueensValue value2: csp.domains.get(var2)){
                if(satisfy(csp, var1, var2, value1, value2)){
                    ok = true;
                }
            }
            if (!ok){
                iter.remove();
                revised = true;
            }
        }
        return revised;
    }

    public boolean satisfy(nQueensCSP csp, nQueensVar var1, nQueensVar var2, nQueensValue col1, nQueensValue col2) {
        if (checkAttacking(var1.index, col1.row ,var2.index, col2.row) == true) {
            return false;
        }
        return true;
    }

}


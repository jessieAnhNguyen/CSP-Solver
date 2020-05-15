package BacktrackingSearch;

import CSP.Problem4CSP;
import Constraint.Problem4Constraints;
import Domains.Problem4Value;
import Variables.Problem4Var;
import Arc.Problem4Arc;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Problem4Search extends BacktrackSearch<Problem4CSP, Problem4Var, Problem4Value, Problem4Constraints>{
    /**
     * The implementation for Problem 4 (Y = X^2)
     **/
    @Override
    public boolean isComplete(HashMap<Problem4Var, Problem4Value> assignments, Problem4CSP csp) {
        return assignments.size() == csp.variables.size();
    }

    @Override
    public Problem4Var selectUnassignedVariable(HashMap<Problem4Var, Problem4Value> assignments, Problem4CSP csp) {
        for (Problem4Var variable : csp.variables)
            if (!assignments.containsKey(variable))
                return variable;
        return null;
    }

    @Override
    public boolean isConsistent(Problem4Var problem4Var, Problem4Value valueAssigning, HashMap<Problem4Var, Problem4Value> assignments, Problem4CSP csp) {
        for (Problem4Constraints constraint: csp.constraints){
            if (problem4Var.name.equals("Y")){
                if (assignments.get(constraint.var2) == null) continue;
                else{
                    if (assignments.get(constraint.var2).integer * assignments.get(constraint.var2).integer == valueAssigning.integer){
                        return true;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /*
   Implement AC_3 method
    */
    @Override
    public boolean AC_3(Problem4CSP csp) {
        ArrayDeque<Problem4Arc> queue = new ArrayDeque<>();
        //List<Problem4Arc> arcs = new ArrayList<>();

        for (Problem4Constraints constraint: csp.constraints){
            Problem4Arc arc1 = new Problem4Arc(constraint.var1, constraint.var2, true);
            Problem4Arc arc2 = new Problem4Arc(constraint.var2, constraint.var1, false);
            //arcs.add(arc1);
            //arcs.add(arc2);
            queue.add(arc1);
            queue.add(arc2);
        }
        while (!queue.isEmpty()){
            Problem4Arc currArc = queue.removeFirst();
            boolean direction;
            if (currArc.var1.name.equals("X")){
                direction = true;
            }
            else direction = false;
            if (revise(csp, currArc.var1, currArc.var2, direction)){
                if (csp.domains.get(currArc.var1).isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean revise(Problem4CSP csp, Problem4Var var1, Problem4Var var2, boolean direction) {
        boolean revised = false;
        //(x,y)
        if (direction){
            Iterator iter = csp.domains.get(var1).iterator();
            while(iter.hasNext()){
                boolean ok = false;
                Problem4Value valueX = (Problem4Value) iter.next();
                for (Problem4Value valueY: csp.domains.get(var2)){
                    if(satisfy(valueX, valueY)){
                        ok = true;
                    }
                }
                if (!ok){
                    iter.remove();
                    revised = true;
                }
            }
        }
        else{
            Iterator iter2 = csp.domains.get(var1).iterator();
            while(iter2.hasNext()){
                boolean ok = false;
                Problem4Value valueY = (Problem4Value) iter2.next();
                for (Problem4Value valueX: csp.domains.get(var2)){
                    if(satisfy(valueX, valueY)){
                        ok = true;
                    }
                }
                if (!ok){
                    iter2.remove();
                    revised = true;
                }
            }
        }
        return revised;
    }

    public boolean satisfy(Problem4Value valueX, Problem4Value valueY) {
        if (valueY.integer == valueX.integer * valueX.integer){
            return true;
        }
        return false;
    }
}


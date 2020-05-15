package BacktrackingSearch;


import CSP.MackworthCSP;
import Constraint.MackworthConstraint;
import Domains.MackworthValue;
import Variables.MackworthVar;
import Arc.MackworthArc;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class MackworthSearch extends BacktrackSearch<MackworthCSP, MackworthVar, MackworthValue, MackworthConstraint>{
    /**
     * The implementation for Macworth Problem (Problem 5)
     **/
    @Override
    public boolean isComplete(HashMap<MackworthVar, MackworthValue> assignments, MackworthCSP csp) {
        return assignments.size() == csp.variables.size();
    }

    @Override
    public MackworthVar selectUnassignedVariable(HashMap<MackworthVar, MackworthValue> assignments, MackworthCSP csp) {
        for (MackworthVar variable : csp.variables)
            if (!assignments.containsKey(variable))
                return variable;
        return null;
    }

    @Override
    public boolean isConsistent(MackworthVar mackworthVar, MackworthValue valueAssigning, HashMap<MackworthVar, MackworthValue> assignments, MackworthCSP csp) {
        for (MackworthConstraint constraint : csp.constraints)
            if (constraint.var1 == mackworthVar) {
                if (assignments.get(constraint.var2) == null) continue;
                else {
                    if (assignments.get(constraint.var2).val <= valueAssigning.val) return false;
                }

            } else if (constraint.var2 == mackworthVar) {
                if (assignments.get(constraint.var1) == null) continue;
                else {
                    if (assignments.get(constraint.var1).val >= valueAssigning.val) return false;
                }
            }
        return true;

    }

    /*
   Implement AC_3 method
    */
    @Override
    public boolean AC_3(MackworthCSP csp) {
        ArrayDeque<MackworthArc> queue = new ArrayDeque<>();
        List<MackworthArc> arcs = new ArrayList<>();

        for (MackworthConstraint constraint: csp.constraints){
            MackworthArc arc1 = new MackworthArc(constraint.var1, constraint.var2, true);
            MackworthArc arc2 = new MackworthArc(constraint.var2, constraint.var1, false);
            arcs.add(arc1);
            arcs.add(arc2);
            queue.add(arc1);
            queue.add(arc2);
        }

        while (!queue.isEmpty()){
            MackworthArc currArc = queue.removeFirst();
            if (revise(csp, currArc.var1, currArc.var2, currArc.direction)){
                if (csp.domains.get(currArc.var1).isEmpty()){
                    return false;
                }
                for (MackworthArc arc: arcs){
                    if ((arc.var2.equals(currArc.var1)) && (!arc.var1.equals(currArc.var2))){
                        queue.add(arc);
                    }
                }
            }
        }
        return true;
    }

    public boolean revise(MackworthCSP csp, MackworthVar var1, MackworthVar var2, boolean direction) {
        boolean revised = false;

        Iterator iter = csp.domains.get(var1).iterator();
        while(iter.hasNext()){
            boolean ok = false;
            MackworthValue value1 = (MackworthValue) iter.next();
            for (MackworthValue value2: csp.domains.get(var2)){
                if(satisfy(value1, value2, direction)){
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

    public boolean satisfy(MackworthValue value1, MackworthValue value2, boolean direction) {
        //value1 < value2
        if (direction){
            if (value1.val < value2.val) return true;
        }
        //value2 < value1
        else{
            if (value2.val < value1.val) return true;
        }
        return false;
    }
}


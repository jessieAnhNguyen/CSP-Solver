package BacktrackingSearch;

import CSP.AusMapColorCSP;
import Constraint.AusMapColorConstraints;
import Arc.AusMapArc;
import Domains.AusMapColorValue;
import Domains.MackworthValue;
import Variables.AusMapColorVar;

import java.util.*;

public class AustraliaMapSearch extends BacktrackSearch<AusMapColorCSP, AusMapColorVar, AusMapColorValue, AusMapColorConstraints>{
    /**
     * The implementation for Australian Map Problem (problem 1)
     **/
    @Override
    public boolean isComplete(HashMap<AusMapColorVar, AusMapColorValue> assignments, AusMapColorCSP csp) {
        return assignments.size() == csp.variables.size();
    }

    @Override
    public AusMapColorVar selectUnassignedVariable(HashMap<AusMapColorVar, AusMapColorValue> assignments, AusMapColorCSP csp) {
        for (AusMapColorVar variable : csp.variables)
            if (!assignments.containsKey(variable))
                return variable;
        return null;
    }

    @Override
    public boolean isConsistent(AusMapColorVar ausMapColorVar, AusMapColorValue valueAssigning, HashMap<AusMapColorVar, AusMapColorValue> assignments, AusMapColorCSP csp) {
        for (AusMapColorConstraints constraint : csp.constraints)
            if (constraint.var1 == ausMapColorVar) {
                if (assignments.get(constraint.var2) == null) continue;
                else {
                    if (assignments.get(constraint.var2) == valueAssigning) return false;
                }

            } else if (constraint.var2 == ausMapColorVar) {
                if (assignments.get(constraint.var1) == null) continue;
                else {
                    if (assignments.get(constraint.var1) == valueAssigning) return false;
                }
            }
        return true;
    }

    /*
    Implement AC_3 method
     */
    @Override
    public boolean AC_3(AusMapColorCSP csp) {
        ArrayDeque<AusMapArc> queue = new ArrayDeque<>();
        List<AusMapArc> arcs = new ArrayList<>();

        for (AusMapColorConstraints constraint: csp.constraints){
            AusMapArc arc1 = new AusMapArc(constraint.var1, constraint.var2, true);
            AusMapArc arc2 = new AusMapArc(constraint.var2, constraint.var1, false);
            arcs.add(arc1);
            arcs.add(arc2);
            queue.add(arc1);
            queue.add(arc2);
        }
        while (!queue.isEmpty()){
            AusMapArc currArc = queue.removeFirst();
            if (revise(csp, currArc.varX, currArc.varY)){
                if (csp.domains.get(currArc.varX).isEmpty()){
                    return false;
                }
                for (AusMapArc arc: arcs){
                    if ((arc.varY.equals(currArc.varX)) && (!arc.varX.equals(currArc.varY))){
                        queue.add(arc);
                    }
                }
            }
        }
        return true;
    }

    public boolean revise(AusMapColorCSP csp, AusMapColorVar var1, AusMapColorVar var2) {
        boolean revised = false;
        Iterator iter = csp.domains.get(var1).iterator();
        while(iter.hasNext()){
            boolean ok = false;
            AusMapColorValue value1 = (AusMapColorValue) iter.next();
            for (AusMapColorValue value2: csp.domains.get(var2)){
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

    public boolean satisfy(AusMapColorCSP csp, AusMapColorVar var1, AusMapColorVar var2, AusMapColorValue value1, AusMapColorValue value2) {
        for (AusMapColorConstraints constraint: csp.constraints){
            if (constraint.var1.equals(var1) && (constraint.var2.equals(var2))){
                if (value1.equals(value2)){
                    return false;
                }
            }
        }
        return true;
    }


}

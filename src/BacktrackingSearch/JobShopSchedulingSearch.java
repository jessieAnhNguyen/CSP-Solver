package BacktrackingSearch;

import CSP.JobShopCSP;
import Arc.JobShopArc;
import Constraint.JobShopConstraints;
import Variables.JobShopVar;

import java.util.*;

public class JobShopSchedulingSearch extends BacktrackSearch<JobShopCSP, JobShopVar, Integer, JobShopConstraints> {
    /**
     * The implementation for Job Shop Problem (problem 2)
     **/
    @Override
    public boolean isComplete(HashMap<JobShopVar, Integer> assignments, JobShopCSP csp) {
        return (assignments.size() == csp.variables.size());
    }

    @Override
    public JobShopVar selectUnassignedVariable(HashMap<JobShopVar, Integer> assignments, JobShopCSP csp) {
        for (JobShopVar variable : csp.variables)
            if (!assignments.containsKey(variable))
                return variable;
        return null;
    }

    @Override
    public boolean isConsistent(JobShopVar variable, Integer valueAssigning, HashMap<JobShopVar, Integer> assignments, JobShopCSP csp) {
        for (JobShopConstraints constraint : csp.constraints){
            if (constraint.var1 == variable) {
                if (assignments.get(constraint.var2) == null) continue;
                if (constraint.taskConstraint == constraint.taskConstraint.PRECEDENCE
                        && valueAssigning + variable.duration > assignments.get(constraint.var2)) return false;
                if (constraint.taskConstraint == constraint.taskConstraint.DISJUNCTIVE
                        && valueAssigning + variable.duration > assignments.get(constraint.var2)
                        && assignments.get(constraint.var2) + constraint.var2.duration > valueAssigning) return false;
            } else if (constraint.var2 == variable) {
                if (assignments.get(constraint.var1) == null) continue;
                if (constraint.taskConstraint == constraint.taskConstraint.PRECEDENCE
                        && assignments.get(constraint.var1) + constraint.var1.duration > valueAssigning) return false;
                if (constraint.taskConstraint == constraint.taskConstraint.DISJUNCTIVE
                        && valueAssigning + variable.duration > assignments.get(constraint.var1)
                        && assignments.get(constraint.var1) + constraint.var1.duration > valueAssigning) return false;
            }
        }
        return true;
    }

    /*
   Implement AC_3 method
    */
    @Override
    public boolean AC_3(JobShopCSP csp) {
        ArrayDeque<JobShopArc> queue = new ArrayDeque<>();
        List<JobShopArc> arcs = new ArrayList<>();

        for (JobShopConstraints constraint: csp.constraints){
            JobShopArc arc1 = new JobShopArc(null, null, true, 0);
            JobShopArc arc2 = new JobShopArc(null, null, true, 0);

            if (constraint.taskConstraint == constraint.taskConstraint.PRECEDENCE){
                arc1 = new JobShopArc(constraint.var1, constraint.var2, true, 1);
                arc2 = new JobShopArc(constraint.var2, constraint.var1, false, 1);
            }
            else if (constraint.taskConstraint == constraint.taskConstraint.DISJUNCTIVE){
                arc1 = new JobShopArc(constraint.var1, constraint.var2, true, 2);
                arc2 = new JobShopArc(constraint.var2, constraint.var1, false, 2);
            }
            arcs.add(arc1);
            arcs.add(arc2);
            queue.add(arc1);
            queue.add(arc2);
        }

        while (!queue.isEmpty()){
            JobShopArc currArc = queue.removeFirst();
            if (revise(csp, currArc.var1, currArc.var2, currArc.direction, currArc.typeConstraint)){
                if (csp.domains.get(currArc.var1).isEmpty()){
                    return false;
                }
                for (JobShopArc arc: arcs){
                    if ((arc.var2.equals(currArc.var1)) && (!arc.var1.equals(currArc.var2))){
                        queue.add(arc);
                    }
                }
            }
        }
        return true;
    }

    public boolean revise(JobShopCSP csp, JobShopVar var1, JobShopVar var2, boolean direction, int typeConstraint) {
        boolean revised = false;
        Iterator iter = csp.domains.get(var1).iterator();
        while(iter.hasNext()){
            boolean ok = false;
            Integer value1 = (Integer) iter.next();
            for (Integer value2: csp.domains.get(var2)){
                if(satisfy(var1, var2, value1, value2, direction, typeConstraint)){
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

    public boolean satisfy(JobShopVar var1, JobShopVar var2, Integer value1, Integer value2, boolean direction, int typeConstraint) {
        //value1 < value2
        if (direction){
            if (typeConstraint == 1){
                if (value1 + var1.duration <= value2) return true;
            }
            else if (typeConstraint == 2){
                if ((value1 + var1.duration <= value2) || (value2 + var2.duration <= value1)) return true;
            }
            return false;
        }
        //value2 < value1
        else{
            if (typeConstraint == 1){
                if (value2 + var2.duration <= value1) return true;
            }
            else if (typeConstraint == 2){
                if ((value2 + var2.duration <= value1) || (value1 + var1.duration <= value2)) return true;
            }
            return false;
        }
    }
}


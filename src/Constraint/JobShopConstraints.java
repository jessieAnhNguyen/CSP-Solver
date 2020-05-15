package Constraint;

import Variables.JobShopVar;

// precedence constraint means a certain task must happen before other task
// disjunctive constraint means 2 task sharing the same tool must not happen at the same time

public class JobShopConstraints{

    static public taskConstraint taskConstraint;
    public JobShopVar var1, var2;

    public JobShopConstraints(taskConstraint taskConstraint, JobShopVar var1, JobShopVar var2) {
        this.taskConstraint = taskConstraint;
        this.var1 = var1;
        this.var2 = var2;
    }

    public enum taskConstraint {
        PRECEDENCE,
        DISJUNCTIVE
    }
}


package CSP;

import Constraint.Constraints;
import Constraint.JobShopConstraints;
import Variables.JobShopVar;
import Variables.Variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JobShopCSP extends CSP<JobShopVar, Integer, JobShopConstraints> {
    /**
     * Abstract class to represent Job Shop CSP problem
     */
    public JobShopCSP() {
        this.variables = new ArrayList<>();
        this.domains = new HashMap<>();
        this.constraints = new ArrayList<>();

        // initialize variables
        // axle installation takes 10 mins
        this.variables.add(new JobShopVar("AxleF", 10));
        this.variables.add(new JobShopVar("AxleB", 10));

        // affix wheels takes 1 min
        this.variables.add(new JobShopVar("WheelRF", 1));
        this.variables.add(new JobShopVar("WheelLF", 1));
        this.variables.add(new JobShopVar("WheelRB", 1));
        this.variables.add(new JobShopVar("WheelLB", 1));

        // tighten the nuts takes 2 mins
        this.variables.add(new JobShopVar("NutsRF", 2));
        this.variables.add(new JobShopVar("NutsLF", 2));
        this.variables.add(new JobShopVar("NutsRB", 2));
        this.variables.add(new JobShopVar("NutsLB", 2));

        // attach the hubcap takes 1 min
        this.variables.add(new JobShopVar("CapRF", 1));
        this.variables.add(new JobShopVar("CapLF", 1));
        this.variables.add(new JobShopVar("CapRB", 1));
        this.variables.add(new JobShopVar("CapLB", 1));

        // inspect takes 3 mins
        this.variables.add(new JobShopVar("Inspect", 3));

        //init domains
        // TODO: Limiting domains of all variables to just 1-27
        for (JobShopVar variable : this.variables) {
            List<Integer> domain = new ArrayList<>();
            if (!variable.taskName.equals("Inspect")) {
                for (int i = 1; i <= 30; i++) {
                    domain.add(i);
                }
            } else {
                for (int i = 1; i <= 27; i++) {
                    domain.add(i);
                }
            }
            this.domains.put(variable, domain);
        }

        //initialize the constraints
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(0), this.variables.get(2)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(0), this.variables.get(3)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(1), this.variables.get(4)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(1), this.variables.get(5)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(2), this.variables.get(6)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(3), this.variables.get(7)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(4), this.variables.get(8)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(5), this.variables.get(9)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(6), this.variables.get(10)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(7), this.variables.get(11)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(8), this.variables.get(12)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(9), this.variables.get(13)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.DISJUNCTIVE, this.variables.get(0), this.variables.get(1)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(0), this.variables.get(14)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(1), this.variables.get(14)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(2), this.variables.get(14)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(3), this.variables.get(14)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(4), this.variables.get(14)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(5), this.variables.get(14)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(6), this.variables.get(14)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(7), this.variables.get(14)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(8), this.variables.get(14)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(9), this.variables.get(14)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(10), this.variables.get(14)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(11), this.variables.get(14)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(12), this.variables.get(14)));
        this.constraints.add(new JobShopConstraints(JobShopConstraints.taskConstraint.PRECEDENCE, this.variables.get(13), this.variables.get(14)));

        printProblem();
    }

    // print variables, domains and constraints of the Job Shop Scheduling problem
    @Override
    public void printProblem() {
        System.out.println("There are " + this.variables.size() + " variables:");
        for (JobShopVar variable : this.variables)
            System.out.printf("    %-10s duration: %-3d Domain: %d-%d\n", variable.taskName, variable.duration, this.domains.get(variable).get(0), this.domains.get(variable).get(this.domains.get(variable).size() - 1));
        System.out.println();
        System.out.println("There are " + this.constraints.size() + " constraints:");
        for (JobShopConstraints constraint : this.constraints)
            System.out.printf("    %-10s %-10s %-10s\n", constraint.var1.taskName, ((constraint.taskConstraint == JobShopConstraints.taskConstraint.PRECEDENCE) ? "PRECEDENCE" : "DISJUNCTIVE"), constraint.var2.taskName);
    }


}

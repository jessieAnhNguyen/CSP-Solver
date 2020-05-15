package Solutions;

import BacktrackingSearch.JobShopSchedulingSearch;
import CSP.JobShopCSP;
import Variables.JobShopVar;

import java.util.HashMap;

public class JobShopSchedulingSolution {
    /**
     * Represent a solution to the Job Shop Problem
     */
    public JobShopSchedulingSolution(){
        JobShopCSP jobShopCSP = new JobShopCSP();
        JobShopSchedulingSearch jobShopSchedulingSearch = new JobShopSchedulingSearch();
        HashMap<JobShopVar, Integer> assignments = new HashMap<>();
        if (jobShopSchedulingSearch.AC_3(jobShopCSP)){
            assignments = jobShopSchedulingSearch.BT(jobShopCSP);
            printJobShopSchedulingAssignment(assignments, jobShopCSP);
        }
        else{
            System.out.println("The JobShop problem is unsolvable!");
        }
    }

    //print out the solution for Job Scheduling Problem
    static void printJobShopSchedulingAssignment(HashMap<JobShopVar, Integer> assignments, JobShopCSP JobShopCSP) {
        System.out.println();
        System.out.println("Solution is:");
        for (JobShopVar variable: JobShopCSP.variables)
            System.out.printf("    %-10s%d\n", variable.taskName, assignments.get(variable));
    }
}


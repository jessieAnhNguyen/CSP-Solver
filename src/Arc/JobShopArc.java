package Arc;

import Variables.JobShopVar;

public class JobShopArc {
    public JobShopVar var1;
    public JobShopVar var2;
    public boolean direction; //true if => and false if <=
    public int typeConstraint;

    public JobShopArc(JobShopVar var1, JobShopVar var2, boolean direction, int typeConstraint){
        this.var1 = var1;
        this.var2 = var2;
        this.direction = direction;
        this.typeConstraint = typeConstraint;
    }
}

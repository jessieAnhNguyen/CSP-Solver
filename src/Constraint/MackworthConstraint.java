package Constraint;
import Variables.MackworthVar;

public class MackworthConstraint extends Constraints {
    public MackworthVar var1, var2;

    public MackworthConstraint(MackworthVar var1, MackworthVar var2){
        this.var1 = var1;
        this.var2 = var2;
    }
}

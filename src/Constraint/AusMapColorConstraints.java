package Constraint;

import Variables.AusMapColorVar;

public class AusMapColorConstraints extends Constraints{

    public adjConstraint constraint ;
    public AusMapColorVar var1, var2;

    // a constraint means state i and state j does not have equal value if they are adjacent
    public AusMapColorConstraints(AusMapColorVar var1, AusMapColorVar var2){
        this.var1 = var1;
        this.var2 = var2;
        this.constraint = adjConstraint.NotEqual;
    }
    public enum adjConstraint{
        NotEqual
    }

}
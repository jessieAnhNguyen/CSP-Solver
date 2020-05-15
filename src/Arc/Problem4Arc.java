package Arc;

import Variables.Problem4Var;

public class Problem4Arc {
    public Problem4Var var1;
    public Problem4Var var2;
    Boolean direction; //true if => and false if <=

    public Problem4Arc(Problem4Var var1, Problem4Var var2, boolean direction){
        this.var1 = var1;
        this.var2 = var2;
        this.direction = direction;
    }
}

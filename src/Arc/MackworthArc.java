package Arc;

import Variables.MackworthVar;

public class MackworthArc {
    public MackworthVar var1;
    public MackworthVar var2;
    public boolean direction; //true if => and false if <=

    public MackworthArc(MackworthVar var1, MackworthVar var2, boolean direction){
        this.var1 = var1;
        this.var2 = var2;
        this.direction = direction;
    }
}

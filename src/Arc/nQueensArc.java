package Arc;

import Variables.nQueensVar;

public class nQueensArc {
    public nQueensVar varX;
    public nQueensVar varY;
    Boolean direction; //true if => and false if <=

    public nQueensArc(nQueensVar varX, nQueensVar varY, boolean direction){
        this.varX = varX;
        this.varY = varY;
        this.direction = direction;
    }
}


package Constraint;

import Variables.nQueensVar;

// for all queens on the board, they must not pairwise attacking each other
public class nQueensConstraints {

    public queenConstraint constraints;
    public nQueensVar var1, var2;

    public nQueensConstraints(nQueensVar var1, nQueensVar var2) {
        this.var1 = var1;
        this.var2 = var2;
        this.constraints = queenConstraint.NOT_ATTACK;
    }

    public enum queenConstraint {
        NOT_ATTACK
    }


}


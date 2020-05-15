package Arc;

import Variables.AusMapColorVar;

public class AusMapArc {
    public AusMapColorVar varX;
    public AusMapColorVar varY;
    Boolean direction; //true if => and false if <=

    public AusMapArc(AusMapColorVar varX, AusMapColorVar varY, boolean direction){
        this.varX = varX;
        this.varY = varY;
        this.direction = direction;
    }
}

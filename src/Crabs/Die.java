package Crabs;
public class Die {

    private int sides;
    private int faceValue;


    public Die() {
        this(6);
    }
    public Die(int sides) {
        this.sides = sides;
        this.faceValue = 1;
    }


    public void roll() {
        faceValue = (int) ((Math.random() * sides) + 1);
    }



    public int getFaceValue() {
        return faceValue;
    }
}

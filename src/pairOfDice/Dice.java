package pairOfDice;

public class Dice {
    private int sides;
    private int faceValue;


    public Dice() {
        this.sides = 6;
    }


    //public Dice(int sides) {
      //  this.sides = sides;
        //this.faceValue = 1;
    //}




    public void roll() {
        this.faceValue = (int) ((Math.random() * sides) + 1);
    }


    /*
    public void setFaceValue(int value) {
        if (value > 0 && value <= sides) {
            faceValue = value;
        }
    }
    */


    public int getFaceValue() {
        return this.faceValue;
    }
}

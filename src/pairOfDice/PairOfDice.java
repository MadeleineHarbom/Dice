package pairOfDice;

public class PairOfDice {
    private int rolls;
    private int ones;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    private int rolldouble;
    private int highestRoll;


    Dice die1 = new Dice();
    Dice die2 = new Dice();


    /*
    public PairOfDice(int sides) {
        Die die1 = new Die(sides);
        Die die2 = new Die(sides);
    }
    */




    public String RollBothDice() {
        die1.roll();
        die2.roll();
        this.rolls ++;
        if (die1.getFaceValue() == die2.getFaceValue()) {
            this.rolldouble ++;
            if (die1.getFaceValue() == 1) {
                this.ones += 2;
            }
            else if (die1.getFaceValue() == 2) {
                this.twos += 2;
            }

            else if (die1.getFaceValue() == 3) {
                this.threes += 2;
            }

            else if (die1.getFaceValue() == 4) {
                this.fours += 2;
            }

            else if (die1.getFaceValue() == 5) {
                this.fives += 2;
            }
            else if (die1.getFaceValue() == 6) {
                this.sixes += 2;
            }
            }

            else {
            if (die1.getFaceValue() == 1 || die2.getFaceValue() == 1) {
                this.ones++;
            }
            if (die1.getFaceValue() == 2 || die2.getFaceValue() == 2) {
                this.twos++;
            }
            if (die1.getFaceValue() == 3 || die2.getFaceValue() == 3) {
                this.threes++;
            }
            if (die1.getFaceValue() == 4 || die2.getFaceValue() == 4) {
                this.fours++;
            }
            if (die1.getFaceValue() == 5 || die2.getFaceValue() == 5) {
                this.fives++;
            }
            if (die1.getFaceValue() == 6 || die2.getFaceValue() == 6) {
                this.sixes++;
            }
        }
        int sum = this.getSumOfDice();
        this.findHighest(sum);
        return "Du slået " + die1.getFaceValue() + " og " + die2.getFaceValue() + "!";
    }

    public int getDoubles () {
        return this.rolldouble;
    }

    private void findHighest (int sum) {
        if (sum > this.highestRoll) {
            this.highestRoll = sum;
        }
    }

    public int getHighestRoll() {
        return this.highestRoll;
    }

    public int getSumOfDice() {
        int sum = die1.getFaceValue() + die2.getFaceValue();
        return sum;

    }

    public int getRolls() {
        return this.rolls;
    }

    public void printRollInfo() {
        System.out.println("Du har slået " + this.ones + " 1'ere");
        System.out.println("Du har slået " + this.twos + " 2'ere");
        System.out.println("Du har slået " + this.threes + " 3'ere");
        System.out.println("Du har slået " + this.fours + " 4'ere");
        System.out.println("Du har slået " + this.fives + " 5'ere");
        System.out.println("Du har slået " + this.sixes + " 6'ere");
        System.out.println("Du har slået dobbelt " + this.rolldouble + " gange");
    }

    public void resetPairOfDice() {
        this.rolls = 0;
        this.ones = 0;
        this.twos = 0;
        this.threes = 0;
        this.fours = 0;
        this.fives = 0;
        this.sixes = 0;
        this.rolldouble = 0;
        this.highestRoll = 0;
        die1.setFaceValue(0);
        die2.setFaceValue(0);
    }


}

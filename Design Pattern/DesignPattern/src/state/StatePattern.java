package state;

import java.util.Random;

// Create the State Interface which will be implemented by new upcomming state.
interface State {
    void insertQuarter();

    void ejectQuarter();

    void dispense();

    void turncrank();
}

// Creating the Main State Machine
class GumballMachine {
    // Declaring all the state the machine gonna have
    private final State soldOutState;
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    private final State winnerState;

    private State currState;
    private int count = 0;

    public GumballMachine(int numberofGumballs) {
        this.soldState = new SoldState(this);
        this.soldOutState = new SoldOutState(this);
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.winnerState = new WinnerState(this);
        this.count = numberofGumballs;

        if (numberofGumballs > 0) {
            this.currState = noQuarterState;
        } else {
            this.currState = soldOutState;
        }
    }

    public void setState(State newstate) {
        this.currState = newstate;
    }

    public int getCount() {
        return this.count;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count--;
        }
    }

    public void insertQuarter() {
        this.currState.insertQuarter();
    }

    public void ejectQuarter() {
        this.currState.ejectQuarter();
    }

    public void turnCrank() {
        this.currState.turncrank();
        this.currState.dispense();
    }

    @Override
    public String toString() {
        return String.format("GumballMachine(balls=%d)", this.count);
    }
}

// Sold Out State class
class SoldOutState implements State {
    private final GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public void turncrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    @Override
    public String toString() {
        return "SoldOutState";
    }
}

// creating class for each state
class NoQuarterState implements State {
    private final GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a Quarter");
        this.gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }

    @Override
    public void turncrank() {
        System.out.println("You turned, but there is no Quarter");
    }

    @Override
    public String toString() {
        return "NoQuarterState";
    }
}

class HasQuarterState implements State {
    private final GumballMachine gumballMachine;
    private final Random randomWinner = new Random(System.currentTimeMillis());

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another Quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        this.gumballMachine.setState(this.gumballMachine.getNoQuarterState());
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public void turncrank() {
        System.out.println("You turned");
        int winner = randomWinner.nextInt();
        if ((winner == 0) && (gumballMachine.getCount() > 1)) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            this.gumballMachine.setState(this.gumballMachine.getSoldState());
        }
    }

    @Override
    public String toString() {
        return "HasQuarterState";
    }
}

class SoldState implements State {
    private final GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please Wait,we are already giving you the gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, You Already turned the Crank");
    }

    @Override
    public void dispense() {
        this.gumballMachine.releaseBall();
        if (this.gumballMachine.getCount() > 0) {
            this.gumballMachine.setState(this.gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumball");
            this.gumballMachine.setState(this.gumballMachine.getSoldOutState());
        }
    }

    @Override
    public void turncrank() {
        System.out.println("Turning twice doesn't get you another gumball");
    }

    @Override
    public String toString() {
        return "SoldState";
    }
}

class WinnerState implements State {
    private final GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please Wait,we are already giving you the gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, You Already turned the Crank");
    }

    @Override
    public void dispense() {
        this.gumballMachine.releaseBall();
        if (this.gumballMachine.getCount() == 0) {
            this.gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            this.gumballMachine.releaseBall();
            System.out.println("You are winner you got two gumballs for your quarter");
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("oops out of gumball");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }

    @Override
    public void turncrank() {
        System.out.println("Turning twice doesn't get you another gumball");
    }

    @Override
    public String toString() {
        return "WinnerState";
    }
}

public class StatePattern {
    public static void main(String[] args) {
        // Testing the gumball Machine
        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        gumballMachine.insertQuarter();
        gumballMachine.insertQuarter();
        System.out.println(gumballMachine);
        gumballMachine.ejectQuarter();

        System.out.println(gumballMachine);
    }
}

/**
 * Output:
 * You inserted a Quarter
 * You turned
 * A gumball comes rolling out the slot...
 * GumballMachine(balls=4)
 * You inserted a Quarter
 * You turned
 * A gumball comes rolling out the slot...
 * You inserted a Quarter
 * You turned
 * A gumball comes rolling out the slot...
 * GumballMachine(balls=2)
 * You inserted a Quarter
 * You can't insert another Quarter
 * GumballMachine(balls=2)
 * Quarter returned
 * GumballMachine(balls=2)
 */

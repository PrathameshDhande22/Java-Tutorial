package proxy.state;

import proxy.ProxyRemote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

// Creating the Main State Machine
public class GumballMachine extends UnicastRemoteObject implements ProxyRemote {
    // Declaring all the state the machine gonna have

    private static final long serialVersionUID = 2L;
    private final State soldOutState;
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    private final State winnerState;

    private State currState;
    private int count = 0;
    private String location = "";

    public GumballMachine(String location, int numberofGumballs) throws RemoteException {
        this.soldState = new SoldState(this);
        this.soldOutState = new SoldOutState(this);
        this.noQuarterState = new NoQuarterState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.winnerState = new WinnerState(this);
        this.count = numberofGumballs;
        this.location = location;

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

    @Override
    public String getLocation() throws RemoteException {
        return this.location;
    }

    @Override
    public State getState() throws RemoteException {
        return this.currState;
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
    private static final long serialVersionUID = 2L;
    private final transient GumballMachine gumballMachine;

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
    private static final long serialVersionUID = 2L;
    private final transient GumballMachine gumballMachine;

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
    private static final long serialVersionUID = 2L;
    private final transient GumballMachine gumballMachine;
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
    private static final long serialVersionUID = 2L;
    private final transient GumballMachine gumballMachine;

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
    private static final long serialVersionUID = 2L;
    // Do not Serialize these field by making it transient
    private final transient GumballMachine gumballMachine;

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


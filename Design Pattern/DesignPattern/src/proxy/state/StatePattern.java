package proxy.state;

import java.rmi.RemoteException;

public class StatePattern {
    public static void main(String[] args) throws RemoteException {
        // Testing the gumball Machine
        GumballMachine gumballMachine = new GumballMachine("localhost", 5);

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

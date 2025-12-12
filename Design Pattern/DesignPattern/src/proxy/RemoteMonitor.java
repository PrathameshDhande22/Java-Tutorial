package proxy;
import java.rmi.RemoteException;

// Monitoring the Gumball Machine Remotely
public class RemoteMonitor {
    private final ProxyRemote gumballMachine;

    public RemoteMonitor(ProxyRemote machine) {
        this.gumballMachine = machine;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine: " + gumballMachine.getLocation());
            System.out.println("Gumball Machine Inventory: " + gumballMachine.getCount() + " gumballs");
            System.out.println("Current State: " + gumballMachine.getState());
        } catch (RemoteException re) {
            re.printStackTrace();
        }
    }
}


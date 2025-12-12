package proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

// Testing the Remote Method where we created
public class RemoteTest {
    public static void main(String[] args) {

        String location = "rmi://localhost/gumballmachine";
        RemoteMonitor monitor = null;
        try {
            ProxyRemote remote = (ProxyRemote) Naming.lookup(location);
            monitor = new RemoteMonitor(remote);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        System.out.println(monitor);
        monitor.report();
    }
}

package proxy;

import proxy.state.GumballMachine;
import java.rmi.Naming;
import java.rmi.Remote;

// Creates the server for the rmi with remote interface as expose.
public class RemoteServer {
    public static void main(String[] args) {
        Remote remote = null;
        int count = 5;
        String location = "localhost";
        try {
            remote = new GumballMachine(location, count);
            Naming.rebind("//" + location + "/gumballmachine", remote);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

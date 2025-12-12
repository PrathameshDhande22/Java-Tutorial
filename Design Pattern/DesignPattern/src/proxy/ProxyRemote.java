package proxy;

import proxy.state.State;
import java.rmi.Remote;
import java.rmi.RemoteException;

// Creating the interface as Remote also its all return must be serializable.
public interface ProxyRemote extends Remote {
    public int getCount() throws RemoteException;
    public String getLocation() throws RemoteException;
    public State getState() throws  RemoteException;
}

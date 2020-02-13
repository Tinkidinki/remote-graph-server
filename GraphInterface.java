import java.util.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

// First doing it with a single value
public interface GraphInterface extends Remote{
    void add_graph(String id, int n) throws RemoteException;
    void add_edge(String id, int s, int d, int w) throws RemoteException;
    int get_mst(String id) throws RemoteException;
}
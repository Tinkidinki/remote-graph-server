import java.rmi.Remote;
import java.rmi.RemoteException;

// First doing it with a single value
public interface GraphInterface extends Remote{
    int getValue(int index) throws RemoteException;
    void updateValue(int index) throws RemoteException;
    void addValue(int value) throws RemoteException;
}
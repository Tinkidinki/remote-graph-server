import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;

public class Client{
    public Client() {}

    public static void main( String args[]){
        try{
            Registry registry = LocateRegistry.getRegistry(null);
            GraphInterface stub = (GraphInterface) registry.lookup("GraphInterface");
            
        }
    }
}
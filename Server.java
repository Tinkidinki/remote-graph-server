import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends GraphImplementation{
    public Server(){}

    public static void main(String args[]){
        try{
            GraphImplementation graph_obj = new GraphImplementation();

            GraphInterface stub = (GraphInterface) UnicastRemoteObject.exportObject(graph_obj, 0);
            Registry registry = LocateRegistry.getRegistry(Integer.parseInt(args[0]));
            registry.bind("GraphInterface", stub);

        } catch (Exception e){
            System.err.println("Server exception: "+ e.toString());
            e.printStackTrace();
        }
    }
}
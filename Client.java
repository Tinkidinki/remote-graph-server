import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client{
    public Client() {}

    public static void main( String args[]){
        try{
            Registry registry = LocateRegistry.getRegistry(args[0], Integer.parseInt(args[1]));
            GraphInterface stub = (GraphInterface) registry.lookup("GraphInterface");

            String input_option = new String("start");
            String exit = new String("e");

            Scanner input_obj = new Scanner(System.in);
            do  {
                input_option = input_obj.next();
                if (input_option.equals("add_graph")){
                    String id = input_obj.next();
                    int num_vert = Integer.parseInt(input_obj.next());
                    stub.add_graph(id, num_vert);
                }
                else if (input_option.equals("add_edge")){
                    String id = input_obj.next();
                    int s = Integer.parseInt(input_obj.next());
                    int d = Integer.parseInt(input_obj.next());
                    int w = Integer.parseInt(input_obj.next());
                    stub.add_edge(id, s, d, w);
                }
                else if (input_option.equals("get_mst")){
                    String id = input_obj.next();
                    System.out.println(stub.get_mst(id));
                }
            } while (! input_option.equals("e"));

        } catch (Exception e){
            System.err.println("Client Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
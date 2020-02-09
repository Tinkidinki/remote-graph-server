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
                if (input_option.equals("add")){
                    int value = Integer.parseInt(input_obj.next());
                    stub.addValue(value);
                }
                else if (input_option.equals("update")){
                    int index = Integer.parseInt(input_obj.next());
                    stub.updateValue(index);
                }
                else if (input_option.equals("get")){
                    int index = Integer.parseInt(input_obj.next());
                    System.out.println(index);
                    System.out.println(stub.getValue(index));
                }
            } while (! input_option.equals("e"));

        } catch (Exception e){
            System.err.println("Client Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.io.*;

public class Client{
    public Client() {}

    public static void main( String args[]){
        try{
            Registry registry = LocateRegistry.getRegistry(args[0], Integer.parseInt(args[1]));
            GraphInterface stub = (GraphInterface) registry.lookup("GraphInterface");

            String input_option = new String("start");
            String exit = new String("e");

            
            String line;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            while ((line = br.readLine()) != null) {
                String[] splitstr = line.trim().split("\\s+");

                if (splitstr[0].equals("add_graph")){
                    String id = splitstr[1];
                    int num_vert = Integer.parseInt(splitstr[2]);
                    stub.add_graph(id, num_vert);
                }
                else if (splitstr[0].equals("add_edge")){
                    String id = splitstr[1];
                    int s = Integer.parseInt(splitstr[2]);
                    int d = Integer.parseInt(splitstr[3]);
                    int w = Integer.parseInt(splitstr[4]);
                    stub.add_edge(id, s, d, w);
                }
                else if (splitstr[0].equals("get_mst")){
                    String id = splitstr[1];
                    System.out.println(stub.get_mst(id));
                }
            }

        } catch (Exception e){
            System.err.println("Client Exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
import java.util.*;
public class GraphImplementation implements GraphInterface {

    Map <String, WeightedGraph.Graph> all_graphs = new HashMap <String, WeightedGraph.Graph>();
    public void add_graph(String id, int n){
        all_graphs.put(id, new WeightedGraph.Graph(n));
    }

    public void add_edge(String id, int s, int d, int w){
        WeightedGraph.Graph g = all_graphs.get(id);
        g.addEdge(s, d, w);
    }

    public int get_mst(String id){
        WeightedGraph.Graph g = all_graphs.get(id);
        return g.mst();
    }
}
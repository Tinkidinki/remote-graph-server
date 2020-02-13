import java.util.*;

public class WeightedGraph {
    public static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static class Graph {
        int vertices;
        LinkedList<Edge>[] adjacencyList;
        int distance[];

        // Constructor
        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices+1];

            for (int i = 1; i < vertices+1; i++){
                adjacencyList[i] = new LinkedList<Edge>();
            }
        }

        // Every graph instance will have one comparator class
        class comparator implements Comparator<Integer> {
            @Override
            public int compare(Integer n, Integer m){
                return distance[n] - distance[m];
            }
        }

        public void addEdge(int source, int destination, int weight){
            Edge f_edge = new Edge(source, destination, weight);
            Edge b_edge = new Edge(destination, source, weight);

            adjacencyList[source].addFirst(f_edge);
            adjacencyList[destination].addFirst(b_edge);
        }

        public void printGraph() {
            for (int i = 1; i < vertices+1; i++) {
                LinkedList<Edge> list = adjacencyList[i];
                for (int j = 0; j < list.size(); j++) {
                    System.out.println(i+"->"+list.get(j).destination + " Weight: " + list.get(j).weight);
                }
            }
        }

        public int mst() {
            distance = new int[vertices+1]; 
            Boolean[] mstset = new Boolean[vertices + 1];
            int mst_weight = 0;

            for (int i = 1; i < vertices+1; i++) {
                mstset[i] = false;
                distance[i] = Integer.MAX_VALUE;
            }

            mstset[1] = true;
            distance[1] = 0;

            PriorityQueue<Integer> queue = new PriorityQueue <Integer> (new comparator());

            for (int i = 1; i < vertices+1; i++){
                queue.add(i);
            }

            while (!queue.isEmpty()){
                int first = queue.poll();
                if (distance[first]==Integer.MAX_VALUE) return -1;
                mst_weight += distance[first];
                mstset[first] = true;

                for (Edge iterator : adjacencyList[first]) {
                    if (mstset[iterator.destination] == false) {
                        if (distance[iterator.destination] > iterator.weight) {
                            queue.remove(iterator.destination);
                            distance[iterator.destination] = iterator.weight;
                            queue.add(iterator.destination);
                        }
                    }
                }
            } 
            

            return mst_weight; 
        }
    }

    public static void main(String args[]) {
        int vertices = 4;
        Graph graph = new Graph(vertices);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 1);
        System.out.println(graph.mst());
    }
}
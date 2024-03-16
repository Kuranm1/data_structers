import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private HashMap<String, ArrayList<String>> adjList;

    Graph(){
        adjList = new HashMap<>();
    }

    public void addVertex(String vertex){
        if (!this.adjList.containsKey(vertex)) this.adjList.put(vertex, new ArrayList<>());
    }

    public void addEdge(String fromVertex, String toVertex){
        if (!this.adjList.containsKey(fromVertex)) addVertex(fromVertex);
        if (!this.adjList.containsKey(toVertex)) addVertex(toVertex);
        this.adjList.get(fromVertex).add(toVertex);
        this.adjList.get(toVertex).add(fromVertex);
    }

    public boolean removeVertex(String vertex){
        if (this.adjList.containsKey(vertex)){
            if (!this.adjList.get(vertex).isEmpty()) {
                for(String v: this.adjList.keySet()) this.adjList.get(v).remove(vertex);
            }
            this.adjList.remove(vertex);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String fromVertex, String toVertex){
        if (!this.adjList.containsKey(fromVertex) && this.adjList.containsKey(toVertex)) return false;
        this.adjList.get(fromVertex).remove(toVertex);
        this.adjList.get(toVertex).remove(fromVertex);
        return true;
    }

    @Override
    public String toString() {
        return adjList.toString();
    }
}

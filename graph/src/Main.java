import javax.jws.soap.SOAPBinding;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        System.out.println("#### Empty string");
        System.out.println(graph);
        System.out.println("#### Add vertex");
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        System.out.println(graph);
        System.out.println("#### Add edge");
        graph.addEdge("A","B");
        graph.addEdge("A","C");
        graph.addEdge("B","C");
        graph.addEdge("D","E");
        graph.addVertex("B");
        System.out.println(graph);
        System.out.println("#### remove vertex");
        graph.removeVertex("A");
        System.out.println(graph);
        System.out.println("#### remove Edge");
        graph.removeEdge("C","B");
        System.out.println(graph);

    }
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class GraphOps {

    class Vertex {
        private int label;

        Vertex(int label) {
            this.label = label;
        }

        @Override
        public boolean equals(Object o) {
            Vertex v = (Vertex) o;
            return label == v.label;
        }

        @Override
        public int hashCode() {
            return label;
        }
    }

    class Graph {
        private Map<Vertex, List<Vertex>> vertices;

        public Map<Vertex, List<Vertex>> getVertices() {
            return vertices;
        }

        public void setVertices(Map<Vertex, List<Vertex>> vertices) {
            this.vertices = vertices;
        }
    }

    Graph graph = new Graph();

    public void addVertex(int label) {
        graph.getVertices().putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(int label) {
        Vertex v = new Vertex(label);
        graph.getVertices().values().stream().forEach(vertices -> vertices.remove(v));
        graph.getVertices().remove(v);
    }

    public void addEdge(int label1, int label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        graph.getVertices().get(v1).add(v2);
        graph.getVertices().get(v2).add(v1);
    }

    public void removeEdge(int label1, int label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> v1List = graph.getVertices().get(v1);
        List<Vertex> v2List = graph.getVertices().get(v2);
        if(v1List != null) {
            v1List.remove(v2);
        }
        if(v2List != null) {
            v2List.remove(v1);
        }
    }

    public List<Vertex> getAdjacentVertices(int label) {
        return graph.getVertices().get(new Vertex(label));
    }

    public List<Integer> breadthFirstTraversal(int root) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(root);
        queue.add(root);
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            for(Vertex v : getAdjacentVertices(vertex)) {
                if(!visited.contains(v.label)) {
                    queue.add(v.label);
                    visited.add(v.label);
                }
            }
        }
        return visited;
    }

    public List<Integer> depthFirstTraversal(int root) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            int label = stack.pop();
            if(!visited.contains(label)) {
                visited.add(label);
                for(Vertex v : getAdjacentVertices(label)) {
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }

    public int findCyclesWithDisjointSet() {   //Kruskal's Algorithm
        int[] parent = new int[graph.getVertices().size()];
        for(int i = 0; i < parent.length; i++)
            parent[i] = -1;
        for(Map.Entry<Vertex, List<Vertex>> vertex : graph.getVertices().entrySet()) {
            Vertex startingVertex = vertex.getKey();
            //for()
        }
        return 0;
    }

    public int findParent(int[] parent, int node) {
        int value = parent[node - 1];
        if(value < 0)
            return node;
        else
            return value;
    }

}

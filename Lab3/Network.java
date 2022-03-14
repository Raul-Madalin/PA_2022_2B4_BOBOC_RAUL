package com.company;

import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void printIdentifiables() {
        List<Node> identfiables = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) instanceof Identifiable) {
                identfiables.add(nodes.get(i));
            }
        }
        Collections.sort(identfiables,
                Comparator.comparing(Node::getIpAddress));
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) instanceof Identifiable) {
                System.out.println(nodes.get(i).getName() + " " + ((Identifiable) nodes.get(i)).getIpAddress());
            }
        }
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }

    int minDistance(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < nodes.size(); v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed distance array
    void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) instanceof Identifiable) {
                System.out.println(nodes.get(i).getName() + " \t\t " + dist[i]);
            }
        }

    }

    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int graph[][], int src) {
        int dist[] = new int[nodes.size()]; // The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[nodes.size()];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < nodes.size(); i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < nodes.size() - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);
            if (nodes.get(u) instanceof Identifiable) {
                sptSet[u] = true;


                // Mark the picked vertex as processed

                // Update dist value of the adjacent vertices of the
                // picked vertex.
                for (int v = 0; v < nodes.size(); v++)

                    // Update dist[v] only if is not in sptSet, there is an
                    // edge from u to v, and total weight of path from src to
                    // v through u is smaller than current value of dist[v]
                    if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                        dist[v] = dist[u] + graph[u][v];
            }
        }

        // print the constructed distance array
        printSolution(dist);
    }
}

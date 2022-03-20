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
        List<Node> identifiables = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) instanceof Identifiable) {
                identifiables.add(nodes.get(i));
            }
        }
        identifiables.sort(new IdentifiablesComparator());

        for (int i = 0; i < identifiables.size(); i++) {
            if (identifiables.get(i) instanceof Identifiable) {
                System.out.println(identifiables.get(i).getName() + " " + ((Identifiable) identifiables.get(i)).getIpAddress());
            }
        }
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }

    int minDistance(int distance[], Boolean use[]) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int v = 0; v < nodes.size(); v++)
            if (use[v] == false && distance[v] <= min) {
                min = distance[v];
                min_index = v;
            }
        return min_index;
    }

    void printSolution(int distance[]) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) instanceof Identifiable) {
                System.out.println(nodes.get(i).getName() + " \t " + distance[i]);
            }
        }

    }

    void dijkstra(int graph[][], int src) {
        int distance[] = new int[nodes.size()];
        Boolean use[] = new Boolean[nodes.size()];

        for (int i = 0; i < nodes.size(); i++) {
            distance[i] = Integer.MAX_VALUE;
            use[i] = false;
        }

        distance[src] = 0;

        for (int count = 0; count < nodes.size() - 1; count++) {
            int u = minDistance(distance, use);
            if (nodes.get(u) instanceof Identifiable) {
                use[u] = true;

                for (int v = 0; v < nodes.size(); v++) {
                    if (!use[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]) {
                        distance[v] = distance[u] + graph[u][v];
                    }
                }
            }
        }

        printSolution(distance);
    }
}

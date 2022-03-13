package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        Collections.sort(nodes, Node::compareTo);
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) instanceof Identifiable) {
                System.out.println(nodes.get(i).getName());
            }
        }
    }

    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }
}

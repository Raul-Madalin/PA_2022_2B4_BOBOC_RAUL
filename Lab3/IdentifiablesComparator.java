package com.company;

import java.util.Comparator;

public class IdentifiablesComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.getIpAddress().compareTo(o2.getIpAddress());
    }
}

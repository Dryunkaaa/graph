package app;

import entity.Graph;
import entity.Route;
import strategy.GraphRouteStrategy;
import strategy.RelationLengthStrategy;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertices(6);
//        graph.addRelation(graph.getPeakById(0), graph.getPeakById(1), 15);
//        graph.addRelation(graph.getPeakById(0), graph.getPeakById(2), 15);
//        graph.addRelation(graph.getPeakById(0), graph.getPeakById(3), 10);
//        graph.addRelation(graph.getPeakById(1), graph.getPeakById(2), 15);
//        graph.addRelation(graph.getPeakById(1), graph.getPeakById(4), 10);
//        graph.addRelation(graph.getPeakById(2), graph.getPeakById(5), 10);
//        graph.addRelation(graph.getPeakById(3), graph.getPeakById(4), 5);
//        graph.addRelation(graph.getPeakById(3), graph.getPeakById(5), 5);
//        graph.addRelation(graph.getPeakById(4), graph.getPeakById(5), 5);

        graph.addRelation(graph.getVertexById(0), graph.getVertexById(1), 15);
        graph.addRelation(graph.getVertexById(1), graph.getVertexById(2), 15);
        graph.addRelation(graph.getVertexById(1), graph.getVertexById(3), 10);
        graph.addRelation(graph.getVertexById(1), graph.getVertexById(4), 15);
        graph.addRelation(graph.getVertexById(2), graph.getVertexById(3), 10);
        graph.addRelation(graph.getVertexById(3), graph.getVertexById(4), 10);
        graph.addRelation(graph.getVertexById(4), graph.getVertexById(5), 5);

//        entity.Route route = graph.findBestRoute(graph.getPeakById(3), graph.getPeakById(1));
//        entity.Route route = graph.findBestRoute(graph.getVertexById(0), graph.getVertexById(5));

        GraphRouteStrategy strategy = new RelationLengthStrategy();
        Route route = strategy.findBestRoute(graph, graph.getVertexById(0), graph.getVertexById(5));
        route.show();
    }
}

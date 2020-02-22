package app;

import entity.Graph;
import entity.Route;
import strategy.GraphRouteStrategy;
import strategy.RelationLengthStrategy;
import strategy.VertexCountStrategy;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertices(6);
        graph.addRelation(graph.getVertexById(0), graph.getVertexById(1), 15);
        graph.addRelation(graph.getVertexById(0), graph.getVertexById(2), 15);
        graph.addRelation(graph.getVertexById(0), graph.getVertexById(3), 10);
        graph.addRelation(graph.getVertexById(1), graph.getVertexById(2), 15);
        graph.addRelation(graph.getVertexById(1), graph.getVertexById(4), 10);
        graph.addRelation(graph.getVertexById(2), graph.getVertexById(5), 10);
        graph.addRelation(graph.getVertexById(3), graph.getVertexById(4), 5);
        graph.addRelation(graph.getVertexById(3), graph.getVertexById(5), 5);
        graph.addRelation(graph.getVertexById(4), graph.getVertexById(5), 5);

        Graph graph1 = new Graph();
        graph1.addVertices(6);
        graph1.addRelation(graph1.getVertexById(0), graph1.getVertexById(1), 15);
        graph1.addRelation(graph1.getVertexById(1), graph1.getVertexById(2), 3);
        graph1.addRelation(graph1.getVertexById(1), graph1.getVertexById(3), 10);
        graph1.addRelation(graph1.getVertexById(1), graph1.getVertexById(4), 15);
        graph1.addRelation(graph1.getVertexById(2), graph1.getVertexById(3), 3);
        graph1.addRelation(graph1.getVertexById(3), graph1.getVertexById(4), 10);
        graph1.addRelation(graph1.getVertexById(4), graph1.getVertexById(5), 5);

        GraphRouteStrategy strategy = new RelationLengthStrategy();

        Route graphRoute = strategy.findBestRoute(graph, graph.getVertexById(0), graph.getVertexById(5));
        graphRoute.show();
        System.out.println("-----------------------------------------------");
        Route graph1Route = strategy.findBestRoute(graph1, graph1.getVertexById(0), graph1.getVertexById(3));
        graph1Route.show();

    }
}

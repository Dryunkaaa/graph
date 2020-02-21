package strategy;

import entity.Graph;
import entity.Route;
import entity.Vertex;

public interface GraphRouteStrategy {

    Route findBestRoute(Graph graph, Vertex firstVertex, Vertex secondVertex);
}

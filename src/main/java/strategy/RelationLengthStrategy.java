package strategy;

import entity.Graph;
import entity.Route;
import entity.Vertex;

import java.util.List;

public class RelationLengthStrategy implements GraphRouteStrategy {

    @Override
    public Route findBestRoute(Graph graph, Vertex firstVertex, Vertex secondVertex) {
        Route route = new Route(firstVertex, secondVertex);
        graph.initRoutes(route, firstVertex);

        List<Route> routes = graph.getRoutes();

        if (routes.size() > 0) {
            Route minRoute = routes.get(0);
            int minLength = minRoute.getLength();

            for (Route route1 : routes) {
                if (route1.getLength() < minLength) {
                    minLength = route1.getLength();
                    minRoute = route1;
                }
            }

            return minRoute;
        }

        return new Route();
    }
}

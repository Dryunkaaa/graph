package strategy;

import entity.Graph;
import entity.Route;
import entity.Vertex;

import java.util.List;

public class VertexCountStrategy implements GraphRouteStrategy {

    @Override
    public Route findBestRoute(Graph graph, Vertex firstVertex, Vertex secondVertex) {
        Route route = new Route(firstVertex, secondVertex);
        graph.initRoutes(route, firstVertex);

        List<Route> routes = graph.getRoutes();

        if (routes.size() > 0) {
            Route minRoute = routes.get(0);
            int minRelationSize = routes.get(0).getRelations().size();

            for (int i = 1; i < routes.size(); i++) {
                Route currentRoute = routes.get(i);

                if (currentRoute.getRelations().size() < minRelationSize) {
                    minRelationSize = currentRoute.getRelations().size();
                    minRoute = currentRoute;
                }
            }

            return minRoute;
        }

        return new Route();
    }
}

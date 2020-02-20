import java.util.*;

public class Graph {

    private Set<Vertex> vertices;

    private Set<Relation> relations;

    private List<Route> routes;

    public Graph() {
        vertices = new HashSet<>();
        relations = new HashSet<>();
        routes = new ArrayList<>();
    }

    public Vertex getVertexById(int id) {
        for (Vertex vertex : vertices) {
            if (vertex.getId() == id) {
                return vertex;
            }
        }

        return new Vertex();
    }

    public void addVertices(int vertexCount) {
        for (int i = 0; i < vertexCount; i++) {
            this.vertices.add(new Vertex(i));
        }
    }

    public void addRelation(Vertex firstVertex, Vertex secondVertex, int length) {
        relations.add(new Relation(firstVertex, secondVertex, length));
    }

    public Route findBestRoute(Vertex firstVertex, Vertex secondVertex) {
        Route route = new Route(firstVertex, secondVertex);

        if (verticesGenerateRelation(firstVertex, secondVertex)) {
            Relation verticesRelation = getVerticesRelation(firstVertex, secondVertex);
            route.getRelations().add(verticesRelation);
            return route;
        }

        initRoutes(route, route.getStartVertex());

        return getMinRoute();
    }

    private boolean verticesGenerateRelation(Vertex firstVertex, Vertex secondVertex) {
        for (Relation relation : relations) {
            if (relation.containsVertex(firstVertex) && relation.containsVertex(secondVertex)) {
                return true;
            }
        }

        return false;
    }

    private void initRoutes(Route route, Vertex inputVertex) {
        Route copyRoute = route.clone();
        Set<Relation> vertexRelations = getVertexRelations(inputVertex);

        for (Relation relation : vertexRelations) {
            Vertex oppositeVertex = relation.getOppositeVertex(inputVertex);

            if (!copyRoute.containsVertex(oppositeVertex)) {
                Relation verticesRelation = getVerticesRelation(inputVertex, oppositeVertex);
                copyRoute.getRelations().add(verticesRelation);
//                initRoutes(copyRoute.clone(), oppositeVertex);
                initRoutes(copyRoute, oppositeVertex);
                copyRoute.getRelations().remove(verticesRelation);
            }
        }

        if (route.getRelations().size() > 0) {
            Relation lastRelation = route.getRelations().get(route.getRelations().size() - 1);
            if (lastRelation.containsVertex(route.getEndVertex())) {
                routes.add(route);
            }
        }
    }

    private Route getMinRoute() {
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

    private Relation getVerticesRelation(Vertex firstVertex, Vertex secondVertex) {
        for (Relation relation : relations) {
            if (relation.containsVertex(firstVertex) && relation.containsVertex(secondVertex)) {
                return relation;
            }
        }

        return null;
    }

    private Set<Relation> getVertexRelations(Vertex vertex) {
        Set<Relation> result = new HashSet<>();

        for (Relation relation : relations) {
            if (relation.containsVertex(vertex)) {
                result.add(relation);
            }
        }

        return result;
    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(Set<Vertex> vertices) {
        this.vertices = vertices;
    }

    public Set<Relation> getRelations() {
        return relations;
    }

    public void setRelations(Set<Relation> relations) {
        this.relations = relations;
    }
}

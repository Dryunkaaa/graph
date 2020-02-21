package entity;

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

    public void initRoutes(Route route, Vertex inputVertex) {
        Route copyRoute = route.clone();
        Set<Relation> vertexRelations = getVertexRelations(inputVertex);

        for (Relation relation : vertexRelations) {
            Vertex oppositeVertex = relation.getOppositeVertex(inputVertex);

            if (!copyRoute.containsVertex(oppositeVertex)) {
                Relation verticesRelation = getVerticesRelation(inputVertex, oppositeVertex);
                copyRoute.getRelations().add(verticesRelation);
                initRoutes(copyRoute, oppositeVertex);
                copyRoute.getRelations().remove(verticesRelation);
            }
        }

        if (copyRoute.getRelations().size() > 0) {
            Relation lastRelation = copyRoute.getRelations().get(route.getRelations().size() - 1);
            if (lastRelation.containsVertex(copyRoute.getEndVertex())) {
                routes.add(copyRoute);
            }
        }
    }

    private Relation getVerticesRelation(Vertex firstVertex, Vertex secondVertex) {
        for (Relation relation : relations) {
            if (relation.containsVertex(firstVertex) && relation.containsVertex(secondVertex)) {
                return relation;
            }
        }

        return new Relation();
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

    public Set<Relation> getRelations() {
        return relations;
    }

    public List<Route> getRoutes() {
        return routes;
    }
}

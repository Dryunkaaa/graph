package entity;

import java.util.ArrayList;
import java.util.List;

public class Route implements Cloneable {

    private Vertex startVertex;

    private Vertex endVertex;

    private List<Relation> relations;

    public Route(Vertex startVertex, Vertex endVertex) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        relations = new ArrayList<>();
    }

    public Route() {
        relations = new ArrayList<>();
    }

    public boolean containsVertex(Vertex vertex) {
        for (Relation relation : relations) {
            if (relation.containsVertex(vertex)) {
                return true;
            }
        }

        return false;
    }

    public void show() {
        Vertex tempVertex = null;

        for (int i = 0; i < relations.size(); i++) {
            if (i == 0) {
                Vertex oppositeVertex = relations.get(0).getOppositeVertex(startVertex);
                relations.get(0).show(startVertex, oppositeVertex);
                tempVertex = oppositeVertex;

            } else {
                Vertex oppositeVertex = relations.get(i).getOppositeVertex(tempVertex);
                relations.get(i).show(tempVertex, oppositeVertex);
                tempVertex = oppositeVertex;
            }
        }
    }

    @Override
    protected Route clone() {
        Route route = new Route();
        route.setStartVertex(this.getStartVertex());
        route.setEndVertex(this.getEndVertex());
        route.setRelations(new ArrayList<>(this.getRelations()));
        return route;
    }

    public int getLength() {
        int sum = 0;
        for (Relation relation : relations) {
            sum += relation.getLength();
        }

        return sum;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(Vertex endVertex) {
        this.endVertex = endVertex;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }
}

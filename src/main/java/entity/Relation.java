package entity;

import java.util.Objects;

public class Relation {

    private Vertex firstVertex;

    private Vertex secondVertex;

    private int length;

    public Relation(Vertex firstVertex, Vertex secondVertex, int length){
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.length = length;
    }

    public Relation() {
    }

    public void show(Vertex vertex1, Vertex vertex2) {
        StringBuilder builder = new StringBuilder();
        builder.append(vertex1.getId())
                .append(" ---> ").append(vertex2.getId())
                .append(" (Length - ")
                .append(length)
                .append(")");
        System.out.println(builder.toString());
    }

    public boolean containsVertex(Vertex vertex){
        if (firstVertex.equals(vertex) || secondVertex.equals(vertex)){
            return true;
        }

        return false;
    }

    public Vertex getOppositeVertex(Vertex vertex){
        if (firstVertex.equals(vertex)){
            return secondVertex;
        }

        return firstVertex;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relation relation = (Relation) o;

        return length == relation.length &&
                Objects.equals(firstVertex, relation.firstVertex) &&
                Objects.equals(secondVertex, relation.secondVertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstVertex, secondVertex, length);
    }
}

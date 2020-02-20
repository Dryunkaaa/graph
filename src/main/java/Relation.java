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

    public void show() {
        StringBuilder builder = new StringBuilder();
        builder.append(firstVertex.getId())
                .append(" ---> ").append(secondVertex.getId())
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

    public Vertex getFirstVertex() {
        return firstVertex;
    }

    public void setFirstVertex(Vertex firstVertex) {
        this.firstVertex = firstVertex;
    }

    public Vertex getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(Vertex secondVertex) {
        this.secondVertex = secondVertex;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

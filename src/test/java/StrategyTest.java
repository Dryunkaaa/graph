import entity.Graph;
import entity.Relation;
import entity.Route;
import entity.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import strategy.GraphRouteStrategy;
import strategy.RelationLengthStrategy;
import strategy.VertexCountStrategy;

public class StrategyTest {

    private Graph graph;
    private GraphRouteStrategy strategy;
    private Route route;
    private Vertex startVertex;
    private Vertex endVertex;

    @Before
    public void prepare() {
        graph = new Graph();
        graph.addVertices(6);
        graph.addRelation(graph.getVertexById(0), graph.getVertexById(1), 15);
        graph.addRelation(graph.getVertexById(1), graph.getVertexById(2), 3);
        graph.addRelation(graph.getVertexById(1), graph.getVertexById(3), 10);
        graph.addRelation(graph.getVertexById(1), graph.getVertexById(4), 15);
        graph.addRelation(graph.getVertexById(2), graph.getVertexById(3), 3);
        graph.addRelation(graph.getVertexById(3), graph.getVertexById(4), 10);
        graph.addRelation(graph.getVertexById(4), graph.getVertexById(5), 5);

        strategy = new VertexCountStrategy();

        startVertex = graph.getVertexById(0);
        endVertex = graph.getVertexById(3);
        route = new Route(startVertex, endVertex);
    }

    @Test
    public void testVertexCountStrategy() {
        route.getRelations().add(new Relation(startVertex, graph.getVertexById(1), 15));
        route.getRelations().add(new Relation(graph.getVertexById(1), endVertex, 10));

        Assert.assertEquals(strategy.findBestRoute(graph, startVertex, endVertex), route);
    }

    @Test
    public void testRelationLengthStrategy() {
        strategy = new RelationLengthStrategy();
        route.getRelations().add(new Relation(startVertex, graph.getVertexById(1), 15));
        route.getRelations().add(new Relation(graph.getVertexById(1), graph.getVertexById(2), 3));
        route.getRelations().add(new Relation(graph.getVertexById(2), endVertex, 3));

        Assert.assertEquals(strategy.findBestRoute(graph, startVertex, endVertex), route);
    }
}

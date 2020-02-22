import entity.Graph;
import entity.Relation;
import entity.Route;
import entity.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphTest {

    private Graph graph = null;

    @Before
    public void prepare() {
        graph = new Graph();
    }

    @Test
    public void testIfVerticesAdded() {
        int vertexCount = 5;
        graph.addVertices(vertexCount);
        Assert.assertEquals(graph.getVertices().size(), vertexCount);
    }

    @Test
    public void testIfRelationAdded() {
        Vertex vertex = new Vertex(0);
        Vertex secondVertex = new Vertex(1);
        int relationLength = 15;
        graph.addRelation(vertex, secondVertex, relationLength);
        Assert.assertEquals(graph.getRelations().size(), 1);
    }

    @Test
    public void testIfReturnVertexById() {
        int vertexId = 2;
        int vertexNumber = 5;
        graph.addVertices(vertexNumber);
        Assert.assertEquals(graph.getVertexById(vertexId).getId(), vertexId);
    }

    @Test
    public void testIfGetRelationByVertices() {
        Vertex firstVertex = new Vertex(0);
        Vertex secondVertex = new Vertex(1);
        int relationLength = 10;

        Relation relation = new Relation(firstVertex, secondVertex, relationLength);
        graph.addRelation(firstVertex, secondVertex, relationLength);

        Assert.assertEquals(relation, graph.getVerticesRelation(firstVertex, secondVertex));
    }

    @Test
    public void testIfGetVertexRelations() {
        Vertex firstVertex = new Vertex(0);
        Vertex secondVertex = new Vertex(1);
        Vertex thirdVertex = new Vertex(2);
        int relationLength = 10;

        graph.addRelation(firstVertex, secondVertex, relationLength);
        graph.addRelation(firstVertex, thirdVertex, relationLength);

        Set<Relation> relations = new HashSet<>();
        relations.add(new Relation(firstVertex, secondVertex, relationLength));
        relations.add(new Relation(firstVertex, thirdVertex, relationLength));

        Assert.assertEquals(relations, graph.getVertexRelations(firstVertex));
    }

    @Test
    public void testFillingRoutes() {
        createGraph();

        Vertex startVertex = graph.getVertexById(0);
        Vertex endVertex = graph.getVertexById(3);
        Route route = new Route(startVertex, endVertex);

        List<Route> routes = new ArrayList<>();
        Route firstRoute = new Route(startVertex, endVertex);

        Relation firstRelation = new Relation(new Vertex(0), new Vertex(1), 1);
        Relation secondRelation = new Relation(new Vertex(1), new Vertex(4), 1);
        Relation thirdRelation = new Relation(new Vertex(3), new Vertex(4), 1);
        firstRoute.getRelations().add(firstRelation);
        firstRoute.getRelations().add(secondRelation);
        firstRoute.getRelations().add(thirdRelation);

        routes.add(firstRoute);

        Route secondRoute = new Route(startVertex, endVertex);
        firstRelation = new Relation(new Vertex(0), new Vertex(1), 1);
        secondRelation = new Relation(new Vertex(1), new Vertex(3), 1);

        secondRoute.getRelations().add(firstRelation);
        secondRoute.getRelations().add(secondRelation);

        routes.add(secondRoute);

        Route thirdRoute = new Route(startVertex, endVertex);

        firstRelation = new Relation(new Vertex(0), new Vertex(1), 1);
        secondRelation = new Relation(new Vertex(1), new Vertex(2), 1);
        thirdRelation = new Relation(new Vertex(2), new Vertex(3), 1);
        thirdRoute.getRelations().add(firstRelation);
        thirdRoute.getRelations().add(secondRelation);
        thirdRoute.getRelations().add(thirdRelation);

        routes.add(thirdRoute);

        graph.initRoutes(route, startVertex);
        Assert.assertEquals(graph.getRoutes(), routes);

    }

    private void createGraph() {
        graph.addVertices(6);
        graph.addRelation(graph.getVertexById(0), graph.getVertexById(1), 1);
        graph.addRelation(graph.getVertexById(1), graph.getVertexById(2), 1);
        graph.addRelation(graph.getVertexById(1), graph.getVertexById(3), 1);
        graph.addRelation(graph.getVertexById(1), graph.getVertexById(4), 1);
        graph.addRelation(graph.getVertexById(2), graph.getVertexById(3), 1);
        graph.addRelation(graph.getVertexById(3), graph.getVertexById(4), 1);
        graph.addRelation(graph.getVertexById(4), graph.getVertexById(5), 1);
    }

}

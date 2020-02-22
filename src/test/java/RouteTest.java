import entity.Relation;
import entity.Route;
import entity.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RouteTest {

    private Route route;
    private Vertex firstVertex;
    private int routeLength = 10;

    @Before
    public void prepare(){
        firstVertex = new Vertex(0);
        Vertex secondVertex = new Vertex(1);
        route = new Route(firstVertex, secondVertex);
        Relation relation = new Relation(firstVertex, secondVertex, routeLength);
        route.getRelations().add(relation);
    }

    @Test
    public void testIfContainsVertex() {
        Assert.assertTrue(route.containsVertex(firstVertex));
    }

    @Test
    public void testIfNotContainsVertex(){
        Assert.assertFalse(route.containsVertex(new Vertex(5)));
    }

    @Test
    public void testCloneRoute(){
        Assert.assertEquals(route, route.clone());
    }

    @Test
    public void testLength(){
        Assert.assertEquals(route.getLength(), routeLength);
    }

    @Test
    public void testIfEndsWithEndVertex(){
        Assert.assertTrue(route.endsWithEndVertex());
    }

    @Test
    public void testIfNotEndsWithEndVertex(){
        route.getRelations().add(new Relation(new Vertex(3), new Vertex(10), 10));
        Assert.assertFalse(route.endsWithEndVertex());
    }
}

import entity.Relation;
import entity.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RelationTest {

    private Vertex firstVertex;
    private Vertex secondVertex;
    private Relation relation;

    @Before
    public void prepare() {
        firstVertex = new Vertex(0);
        secondVertex = new Vertex(1);
        relation = new Relation(firstVertex, secondVertex, 10);
    }

    @Test
    public void testIfContainsVertex() {
        Assert.assertTrue(relation.containsVertex(firstVertex));
    }

    @Test
    public void testIfNotContainsVertex() {
        Assert.assertFalse(relation.containsVertex(new Vertex(5)));
    }

    @Test
    public void testFindingOppositeVertex() {
        Assert.assertEquals(relation.getOppositeVertex(firstVertex), secondVertex);
    }
}

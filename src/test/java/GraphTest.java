import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {

    private Graph graph = null;

    @Before
    public void prepare() {
        graph = new Graph();
    }

    @Test
    public void testIfPeaksAdded() {
        int peaksCount = 5;
        graph.addVertices(peaksCount);
        Assert.assertEquals(graph.getVertices().size(), peaksCount);
    }

    @Test
    public void testIfRelationAdded(){
        Vertex peak = new Vertex(0);
        Vertex secondPeak = new Vertex(1);
        int relationLength = 15;
        graph.addRelation(peak, secondPeak, relationLength);
        Assert.assertEquals(graph.getRelations().size(), 1);
    }

    @Test
    public void testIfReturnPeakById(){
        int peakId = 2;
        int peaksNumber = 5;
        graph.addVertices(peaksNumber);
        Assert.assertEquals(graph.getVertexById(peakId).getId(), peakId);
    }

}

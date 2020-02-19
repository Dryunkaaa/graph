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
        graph.addPeaks(peaksCount);
        Assert.assertEquals(graph.getPeaks().size(), peaksCount);
    }

}

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addPeaks(6);
//        graph.addRelation(graph.getPeakById(0), graph.getPeakById(1), 15);
//        graph.addRelation(graph.getPeakById(0), graph.getPeakById(2), 15);
//        graph.addRelation(graph.getPeakById(0), graph.getPeakById(3), 10);
//        graph.addRelation(graph.getPeakById(1), graph.getPeakById(2), 15);
//        graph.addRelation(graph.getPeakById(1), graph.getPeakById(4), 10);
//        graph.addRelation(graph.getPeakById(2), graph.getPeakById(5), 10);
//        graph.addRelation(graph.getPeakById(3), graph.getPeakById(4), 5);
//        graph.addRelation(graph.getPeakById(3), graph.getPeakById(5), 5);
//        graph.addRelation(graph.getPeakById(4), graph.getPeakById(5), 5);

        graph.addRelation(graph.getPeakById(0), graph.getPeakById(1), 15);
        graph.addRelation(graph.getPeakById(1), graph.getPeakById(2), 15);
        graph.addRelation(graph.getPeakById(1), graph.getPeakById(3), 10);
        graph.addRelation(graph.getPeakById(1), graph.getPeakById(4), 15);
        graph.addRelation(graph.getPeakById(2), graph.getPeakById(3), 10);
        graph.addRelation(graph.getPeakById(3), graph.getPeakById(4), 10);
        graph.addRelation(graph.getPeakById(4), graph.getPeakById(5), 5);

//        Route route = graph.findBestRoute(graph.getPeakById(3), graph.getPeakById(1));
        Route route = graph.findBestRoute(graph.getPeakById(0), graph.getPeakById(5));
        route.show();


    }
}

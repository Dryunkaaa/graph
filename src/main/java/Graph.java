import java.util.*;

public class Graph {

    private Set<Peak> peaks;

    private Set<Relation> relations;

    private List<Route> routes = new ArrayList<>();

    public Graph() {
        peaks = new HashSet<>();
        relations = new HashSet<>();
    }

    public Route findBestRoute(Peak firstPeak, Peak secondPeak) {
        Route route = new Route(firstPeak, secondPeak);

        if (checkIfRelationContains(firstPeak, secondPeak)) {
            route.getRelations().add(getRelationByPeaks(firstPeak, secondPeak));
            return route;
        }

        getAllWays(route, route.getStartPeak());

        clear();

        Route minRoute = routes.get(0);
        int min = routes.get(0).getRelations().size();
        for (int i = 1; i<routes.size(); i++){
            Route currentRoute = routes.get(i);
            if (currentRoute.getRelations().size() < min){
                min = currentRoute.getRelations().size();
                minRoute = currentRoute;
            }
        }

        return minRoute;
    }

    private void clear() {
        Iterator iterator = routes.iterator();
        while (iterator.hasNext()){
            Route route = (Route) iterator.next();
            boolean lastRelationContainsGoalPeak = route.getRelations().get(route.getRelations().size()-1).containsPeak(route.getGoalPeak());
            if (!lastRelationContainsGoalPeak){
                iterator.remove();
            }

        }
    }

    public void getAllWays(Route route, Peak inputPeak) {
        Route copyRoute = new Route();
        copyRoute.setStartPeak(route.getStartPeak());
        copyRoute.setGoalPeak(route.getGoalPeak());
        copyRoute.getRelations().addAll(route.getRelations());

        Set<Relation> peakRelations = getRelationsByPeak(inputPeak);

        for (Relation relation : peakRelations) {
            Peak anotherPeak = relation.getAnotherPeak(inputPeak);
            if (!copyRoute.containsPeak(anotherPeak)) {
                Relation peaksRelation = getRelationByPeaks(inputPeak, anotherPeak);
                copyRoute.getRelations().add(peaksRelation);
                getAllWays(copyRoute, anotherPeak);
                copyRoute.getRelations().remove(peaksRelation);
            }

        }

        if (route.getRelations().size()>0){

            Relation lastRelation = route.getRelations().get(route.getRelations().size() - 1);
            if (lastRelation.containsPeak(route.getGoalPeak())) {
                routes.add(route);
            }
        }
    }

    private boolean checkIfRelationContains(Peak firstPeak, Peak secondPeak) {
        for (Relation relation : relations) {
            if (relation.containsPeak(firstPeak) && relation.containsPeak(secondPeak)) {
                return true;
            }
        }

        return false;
    }

    private Relation getRelationByPeaks(Peak firstPeak, Peak secondPeak) {
        for (Relation relation : relations) {
            if (relation.containsPeak(firstPeak) && relation.containsPeak(secondPeak)) {
                return relation;
            }
        }

        return null;
    }

    private Set<Relation> getRelationsByPeak(Peak inputPeak) {
        Set<Relation> result = new HashSet<>();

        for (Relation relation : relations) {
            if (relation.containsPeak(inputPeak)) {
                result.add(relation);
            }
        }

        return result;
    }

    public Peak getPeakById(int id) {
        for (Peak peak : peaks) {
            if (peak.getId() == id) {
                return peak;
            }
        }
        return new Peak();
    }

    public void addPeaks(int peaksNumber) {
        for (int i = 0; i < peaksNumber; i++) {
            this.peaks.add(new Peak(i));
        }
    }

    public void addRelation(Peak firstPeak, Peak secondPeak, int length) {
        relations.add(new Relation(firstPeak, secondPeak, length));
    }

    public Set<Peak> getPeaks() {
        return peaks;
    }

    public void setPeaks(Set<Peak> peaks) {
        this.peaks = peaks;
    }

    public Set<Relation> getRelations() {
        return relations;
    }

    public void setRelations(Set<Relation> relations) {
        this.relations = relations;
    }
}

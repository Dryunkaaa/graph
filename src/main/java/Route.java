import java.util.ArrayList;
import java.util.List;

public class Route implements Cloneable {

    private Peak startPeak;

    private Peak goalPeak;

    private List<Relation> relations;

    public Route(Peak startPeak, Peak goalPeak) {
        this.startPeak = startPeak;
        this.goalPeak = goalPeak;
        relations = new ArrayList<>();
    }

    public Route() {
        relations = new ArrayList<>();
    }

    public boolean containsPeak(Peak peak) {
        for (Relation relation : relations) {
            if (relation.containsPeak(peak)) {
                return true;
            }
        }

        return false;
    }

    public void show() {
        for (Relation relation : relations) {
            relation.show();
        }
    }

    @Override
    protected Route clone() {
        Route route = new Route();
        route.setStartPeak(this.getStartPeak());
        route.setGoalPeak(this.getGoalPeak());
        route.getRelations().addAll(this.getRelations());

        return route;
    }

    public Peak getStartPeak() {
        return startPeak;
    }

    public void setStartPeak(Peak startPeak) {
        this.startPeak = startPeak;
    }

    public Peak getGoalPeak() {
        return goalPeak;
    }

    public void setGoalPeak(Peak goalPeak) {
        this.goalPeak = goalPeak;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }
}

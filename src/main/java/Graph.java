import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Peak> peaks;

    private List<Relation> relations;

    public Graph() {
        peaks = new ArrayList<>();
        relations = new ArrayList<>();
    }

    public void addPeaks(int peaksNumber) {
        for (int i = 0; i < peaksNumber; i++) {
            this.peaks.add(new Peak(i));
        }
    }

    public List<Peak> getPeaks() {
        return peaks;
    }

    public void setPeaks(List<Peak> peaks) {
        this.peaks = peaks;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }
}

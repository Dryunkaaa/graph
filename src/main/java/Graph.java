import java.util.HashSet;
import java.util.Set;

public class Graph {

    private Set<Peak> peaks;

    private Set<Relation> relations;

    public Graph() {
        peaks = new HashSet<>();
        relations = new HashSet<>();
    }

    public void addPeaks(int peaksNumber) {
        for (int i = 0; i < peaksNumber; i++) {
            this.peaks.add(new Peak(i));
        }
    }

    public void addRelation(Peak firstPeak, Peak secondPeak, int length) {
        relations.add(new Relation(firstPeak, secondPeak, length));
    }

    public Peak getPeakById(int id){
        for(Peak peak : peaks){
            if (peak.getId() == id){
                return peak;
            }
        }

        return new Peak();
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

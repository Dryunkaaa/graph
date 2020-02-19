import java.util.Objects;

public class Relation {

    private Peak firstPeak;

    private Peak secondPeak;

    private int length;

    public Relation(Peak firstPeak, Peak secondPeak, int length){
        this.firstPeak = firstPeak;
        this.secondPeak = secondPeak;
        this.length = length;
    }

    public void show() {
        StringBuilder builder = new StringBuilder();
        builder.append(firstPeak.getId())
                .append(" ---> ").append(secondPeak.getId())
                .append(" (Length - ")
                .append(length)
                .append(")");
        System.out.println(builder.toString());
    }

    public boolean containsPeak(Peak peak){
        if (firstPeak.equals(peak) || secondPeak.equals(peak)) return true;
        return false;
    }

    public Peak getAnotherPeak(Peak inputPeak){
        if (firstPeak.equals(inputPeak)){
            return secondPeak;
        }

        return firstPeak;
    }

    public Peak getFirstPeak() {
        return firstPeak;
    }

    public void setFirstPeak(Peak firstPeak) {
        this.firstPeak = firstPeak;
    }

    public Peak getSecondPeak() {
        return secondPeak;
    }

    public void setSecondPeak(Peak secondPeak) {
        this.secondPeak = secondPeak;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relation relation = (Relation) o;

        return length == relation.length &&
                Objects.equals(firstPeak, relation.firstPeak) &&
                Objects.equals(secondPeak, relation.secondPeak);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPeak, secondPeak, length);
    }
}

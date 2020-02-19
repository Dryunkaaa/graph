public class Relation {

    private Peak firstPeak;

    private Peak secondPeak;

    private int length;

    public void show() {
        StringBuilder builder = new StringBuilder();
        builder.append(firstPeak.getId())
                .append(" ---> ").append(secondPeak.getId())
                .append(" (Length - ")
                .append(length)
                .append(")");
        System.out.println(builder.toString());
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
}

import java.util.Objects;

public class Peak {

    private int id;

    public Peak(int id) {
        this.id = id;
    }

    public Peak() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peak peak = (Peak) o;
        return id == peak.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

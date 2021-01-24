package models;

import java.util.List;

public class Gen {
    public String name;
    public List<Sequence> sequences;

    public Gen(String name, List<Sequence> sequences) {
        this.name = name;
        this.sequences = sequences;
    }

    @Override
    public String toString() {
        return "Gen{" +
                "name='" + name + '\'' +
                ", sequences=" + sequences +
                '}';
    }
}

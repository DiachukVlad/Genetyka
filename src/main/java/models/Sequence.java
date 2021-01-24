package models;

public class Sequence {
    private int kodon;
    private String sequence;
    private String mutation;

    public Sequence() {
    }

    public int getKodon() {
        return kodon;
    }

    public void setKodon(int kodon) {
        this.kodon = kodon;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getMutation() {
        return mutation;
    }

    public void setMutation(String mutation) {
        this.mutation = mutation;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "kodon=" + kodon +
                ", sequence='" + sequence + '\'' +
                ", mutation='" + mutation + '\'' +
                '}';
    }
}

package domain.model;

public class CD extends Product {
    public CD(String title, String type, String id) {
        super(title, type, id);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

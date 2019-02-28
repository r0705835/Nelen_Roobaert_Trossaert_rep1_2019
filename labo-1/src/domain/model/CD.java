package domain.model;

public class CD extends Product {
    public CD(String title, String type, String id) {
        super(title, type, id);
    }

    @Override
    public String getPrice() {
        return null;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

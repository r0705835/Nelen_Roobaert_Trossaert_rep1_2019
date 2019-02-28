package domain.model;

public class Movie extends Product {

    public Movie(String title, String type, String id) {
        super(title, type, id);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
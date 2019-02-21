public class Movie extends Product {

    public Movie(String title, String type, String id) {
        super(title, type, id);
    }

    @Override
    public String getPrice() {
        return "$20";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
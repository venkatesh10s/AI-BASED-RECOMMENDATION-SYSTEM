public class Book {
    String name;
    double score;

    public Book(String name, double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name + " (Score: " + Utils.formatDouble(score) + ")";
    }
}

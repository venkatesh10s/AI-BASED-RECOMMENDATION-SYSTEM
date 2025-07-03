import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecommendationEngine engine = new RecommendationEngine();
        engine.loadData("data/books.csv");

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter User ID (1-5): ");
            int userId = sc.nextInt();

            System.out.println("\nRecommended Books for User " + userId + ":");
            for (Book b : engine.recommendForUser(userId)) {
                System.out.println(" - " + b);
            }
        }
    }
}

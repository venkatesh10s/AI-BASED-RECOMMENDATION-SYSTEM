import java.util.*;

public class RecommendationEngine {
    private Map<Integer, Map<String, Integer>> userRatings = new HashMap<>();

    public void loadData(String filepath) {
        userRatings = DataLoader.loadCSV(filepath);
    }

    public List<Book> recommendForUser(int userId) {
        Map<String, Double> scoreMap = new HashMap<>();
        Map<String, Integer> targetUserRatings = userRatings.getOrDefault(userId, new HashMap<>());

        for (Map.Entry<Integer, Map<String, Integer>> entry : userRatings.entrySet()) {
            int otherUser = entry.getKey();
            if (otherUser == userId) continue;

            for (Map.Entry<String, Integer> bookRating : entry.getValue().entrySet()) {
                String book = bookRating.getKey();
                if (!targetUserRatings.containsKey(book)) {
                    scoreMap.put(book, scoreMap.getOrDefault(book, 0.0) + bookRating.getValue());
                }
            }
        }

        if (scoreMap.isEmpty()) {
            // fallback: recommend most popular books
            return getPopularBooks();
        }

        return scoreMap.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .map(e -> new Book(e.getKey(), e.getValue()))
                .toList();
    }

    private List<Book> getPopularBooks() {
        Map<String, List<Integer>> allRatings = new HashMap<>();
        for (Map<String, Integer> ratings : userRatings.values()) {
            for (Map.Entry<String, Integer> entry : ratings.entrySet()) {
                allRatings.putIfAbsent(entry.getKey(), new ArrayList<>());
                allRatings.get(entry.getKey()).add(entry.getValue());
            }
        }

        List<Book> books = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : allRatings.entrySet()) {
            double avg = entry.getValue().stream().mapToInt(i -> i).average().orElse(0.0);
            books.add(new Book(entry.getKey(), avg));
        }

        books.sort((b1, b2) -> Double.compare(b2.score, b1.score));
        return books.subList(0, Math.min(3, books.size()));
    }
}

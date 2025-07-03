import java.io.*;
import java.util.*;

public class DataLoader {
    public static Map<Integer, Map<String, Integer>> loadCSV(String filepath) {
        Map<Integer, Map<String, Integer>> data = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int user = Integer.parseInt(parts[0].trim());
                String item = parts[1].trim();
                int rating = Integer.parseInt(parts[2].trim());

                data.putIfAbsent(user, new HashMap<>());
                data.get(user).put(item, rating);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}

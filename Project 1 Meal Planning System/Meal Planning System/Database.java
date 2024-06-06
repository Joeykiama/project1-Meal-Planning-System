import java.util.*;

public class Database {
    private Map<String, List<Meal>> mealDatabase;

    public Database() {
        mealDatabase = new HashMap<>();
    }

    public void addMeal(String cuisineType, Meal meal) {
        mealDatabase.computeIfAbsent(cuisineType, k -> new ArrayList<>()).add(meal);
    }

    public List<Meal> getMealsByCuisine(String cuisineType) {
        return mealDatabase.getOrDefault(cuisineType, new ArrayList<>());
    }
}

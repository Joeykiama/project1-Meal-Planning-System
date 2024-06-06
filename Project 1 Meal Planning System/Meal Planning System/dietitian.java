import java.util.List;

public class Dietitian extends User {
    private List<Meal> meals;

    public Dietitian(String username, List<Meal> meals) {
        super(username, UserType.DIETITIAN);
        this.meals = meals;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void publishMeal(Meal meal) {
        meals.add(meal);
    }
}

import java.util.*;

// Enumerations for meal types and days of the week
enum MealType {
    BREAKFAST, LUNCH, DINNER
}

enum DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// User class representing both Dietitians/Nutritionists and Customers
class User {
    private String username;
    private UserType type;

    public User(String username, UserType type) {
        this.username = username;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public UserType getType() {
        return type;
    }
}

// Enumeration for user types
enum UserType {
    DIETITIAN, CUSTOMER
}

// Class representing a meal
class Meal {
    private String name;
    private String cuisineType;
    private String cookTime;
    private MealType mealType;
    private DayOfWeek dayOfWeek;

    public Meal(String name, String cuisineType, String cookTime, MealType mealType, DayOfWeek dayOfWeek) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.cookTime = cookTime;
        this.mealType = mealType;
        this.dayOfWeek = dayOfWeek;
    }

    public String getName() {
        return name;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public String getCookTime() {
        return cookTime;
    }

    public MealType getMealType() {
        return mealType;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}

// Class representing the Message Broker
class MessageBroker {
    private Map<UserType, Set<User>> subscribers;

    public MessageBroker() {
        subscribers = new HashMap<>();
        subscribers.put(UserType.DIETITIAN, new HashSet<>());
        subscribers.put(UserType.CUSTOMER, new HashSet<>());
    }

    public void subscribe(User user) {
        subscribers.get(user.getType()).add(user);
    }

    public void unsubscribe(User user) {
        subscribers.get(user.getType()).remove(user);
    }

    public void sendNotification(Meal meal) {
        // Simulate sending notification to subscribed users
        Set<User> subscribedUsers = subscribers.get(UserType.CUSTOMER);
        for (User user : subscribedUsers) {
            System.out.println("Notification sent to: " + user.getUsername() + " - Meal: " + meal.getName());
        }
    }
}

public class MealPlanner {
    public static void main(String[] args) {
        // Create instances of Dietitian/Nutritionist, Customer, Meal, and MessageBroker
        User dietitian = new User("dietitian1", UserType.DIETITIAN);
        User customer1 = new User("customer1", UserType.CUSTOMER);
        Meal meal = new Meal("Fried Rice", "Chinese", "15 minutes", MealType.DINNER, DayOfWeek.MONDAY);
        MessageBroker messageBroker = new MessageBroker();

        // Subscribe customer to receive notifications
        messageBroker.subscribe(customer1);

        // Publish meal and send notifications
        messageBroker.sendNotification(meal);
    }
}

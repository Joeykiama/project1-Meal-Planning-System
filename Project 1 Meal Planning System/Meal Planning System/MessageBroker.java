import java.util.*;

public class MessageBroker {
    private Map<String, Set<Customer>> subscriptions;

    public MessageBroker() {
        subscriptions = new HashMap<>();
    }

    public void subscribe(Customer customer, String mealPlanType) {
        subscriptions.computeIfAbsent(mealPlanType, k -> new HashSet<>()).add(customer);
    }

    public void unsubscribe(Customer customer, String mealPlanType) {
        Set<Customer> customers = subscriptions.get(mealPlanType);
        if (customers != null) {
            customers.remove(customer);
        }
    }

    public void notifySubscribers(Meal meal) {
        Set<Customer> customers = subscriptions.get(meal.getCuisineType());
        if (customers != null) {
            for (Customer customer : customers) {
                System.out.println("Notification sent to: " + customer.getUsername() + " - Meal: " + meal.getName());
            }
        }
    }
}

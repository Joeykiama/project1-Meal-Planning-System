import java.util.Set;

public class Customer extends User {
    private Set<String> subscriptions;

    public Customer(String username) {
        super(username, UserType.CUSTOMER);
        subscriptions = new HashSet<>();
    }

    public Set<String> getSubscriptions() {
        return subscriptions;
    }

    public void subscribe(String mealPlanType) {
        subscriptions.add(mealPlanType);
    }

    public void unsubscribe(String mealPlanType) {
        subscriptions.remove(mealPlanType);
    }
}

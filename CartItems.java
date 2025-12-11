import java.util.LinkedHashMap;
import java.util.Map;
public class CartItems {

        private static CartItems instance = null;
        private LinkedHashMap<MenuItem, Integer> items;

        private CartItems() {
            items = new LinkedHashMap<>();
        }

        public static CartItems getInstance() {
            if (instance == null) {
                instance = new CartItems();
            }
            return instance;
        }

    public void addItem(MenuItem item) {
        items.put(item, items.getOrDefault(item, 0) + 1);
    }

    public void increaseQuantity(MenuItem item) {
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + 1);
        }
    }

    public void decreaseQuantity(MenuItem item) {
        if (items.containsKey(item)) {
            int qty = items.get(item);
            if (qty > 1) {
                items.put(item, qty - 1);
            } else {
                items.remove(item);
            }
        }
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    public Map<MenuItem, Integer> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }
}
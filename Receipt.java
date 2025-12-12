import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class Receipt {

    private LinkedHashMap<MenuItem, Integer> items;
    private double subtotal;
    private double tax;
    private double tip;
    private double total;
    private LocalDateTime createdAt;

    public Receipt(Map<MenuItem, Integer> items,
                   double subtotal,
                   double tax,
                   double tip) {

        this.items = new LinkedHashMap<>(items);
        this.subtotal = subtotal;
        this.tax = tax;
        this.tip = tip;
        this.total = subtotal + tax + tip;
        this.createdAt = LocalDateTime.now();
    }

    public Map<MenuItem, Integer> getItems() {
        return items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getTax() {
        return tax;
    }

    public double getTip() {
        return tip;
    }

    public double getTotal() {
        return total;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Receipt generated at: ").append(createdAt).append("\n\n");
        for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
            MenuItem item = entry.getKey();
            int qty = entry.getValue();
            double lineTotal = item.getPrice() * qty;
            sb.append(qty)
              .append(" x ")
              .append(item.getName())
              .append("  $")
              .append(String.format("%.2f", lineTotal))
              .append("\n");
        }
        sb.append("\nSubtotal: $").append(String.format("%.2f", subtotal));
        sb.append("\nTax:      $").append(String.format("%.2f", tax));
        sb.append("\nTip:      $").append(String.format("%.2f", tip));
        sb.append("\n---------------------------");
        sb.append("\nTotal:    $").append(String.format("%.2f", total));
        return sb.toString();
    }
}


import java.awt.*;
import java.util.Map;
import javax.swing.*;

public class CartGUI extends JFrame {
    private JPanel itemsPanel;

    public CartGUI() {
        setTitle("Shopping Cart");
        setSize(500, 400);
        setLocationRelativeTo(null);

        itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        add(scrollPane, BorderLayout.CENTER);

        CartItems cart = CartItems.getInstance();
        for (Map.Entry<MenuItem, Integer> entry : cart.getItems().entrySet()) {
            MenuItem item = entry.getKey();
            int qty = entry.getValue();

            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel nameLabel = new JLabel(item.getName() + " - $" + item.getPrice() + " x " + qty);

            JButton plusBtn = new JButton("+");
            plusBtn.addActionListener(e -> {
                cart.increaseQuantity(item);
                refresh();
            });

            JButton minusBtn = new JButton("-");
            minusBtn.addActionListener(e -> {
                cart.decreaseQuantity(item);
                refresh();
            });

            JButton removeBtn = new JButton("Remove");
            removeBtn.addActionListener(e -> {
                cart.removeItem(item);
                refresh();
            });

            itemPanel.add(nameLabel);
            itemPanel.add(plusBtn);
            itemPanel.add(minusBtn);
            itemPanel.add(removeBtn);

            itemsPanel.add(itemPanel);
        }

        JLabel totalLabel = new JLabel("Total: $" + String.format("%.2f", cart.getTotal()));
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        itemsPanel.add(totalLabel);

        JButton sendBtn = new JButton("Send to Kitchen");
        itemsPanel.add(sendBtn);
        sendBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Your Food Will Soon Arrive!"));

        JButton btnCheckout = new JButton("Checkout");

        itemsPanel.add(btnCheckout);
        btnCheckout.addActionListener(e -> JOptionPane.showMessageDialog(this, "Checkout coming soon"));
        setVisible(true);
    }

    private void refresh() {
        getContentPane().removeAll();
        itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        CartItems cart = CartItems.getInstance();
        for (Map.Entry<MenuItem, Integer> entry : cart.getItems().entrySet()) {
            MenuItem item = entry.getKey();
            int qty = entry.getValue();
            JPanel itemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel nameLabel = new JLabel(item.getName() + " - $" + item.getPrice() + " x " + qty);
            JButton plusBtn = new JButton("+");
            plusBtn.addActionListener(e -> {
                cart.increaseQuantity(item);
                refresh();
            });
            JButton minusBtn = new JButton("-");
            minusBtn.addActionListener(e -> {
                cart.decreaseQuantity(item);
                refresh();
            });
            JButton removeBtn = new JButton("Remove");
            removeBtn.addActionListener(e -> {
                cart.removeItem(item);
                refresh();
            });

            itemPanel.add(nameLabel);
            itemPanel.add(plusBtn);
            itemPanel.add(minusBtn);
            itemPanel.add(removeBtn);
            itemsPanel.add(itemPanel);
        }
        JLabel totalLabel = new JLabel("Total: $" + String.format("%.2f", cart.getTotal()));
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        itemsPanel.add(totalLabel);
        JButton sendBtn = new JButton("Send to Kitchen");
        itemsPanel.add(sendBtn);
        add(new JScrollPane(itemsPanel), BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
}

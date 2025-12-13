import java.awt.*;
import javax.swing.*;

public class ItemDetailGUI extends JFrame {

    public ItemDetailGUI(MenuItem item) {
        setTitle("Item Details");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));

        JLabel name = new JLabel(item.getName() + " (ID: " + item.getID() + ")", SwingConstants.CENTER);
        name.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel price = new JLabel("Price: $" + item.getPrice(), SwingConstants.CENTER);
        JLabel desc = new JLabel("<html><center>" + item.getDescription() + "</center></html>", SwingConstants.CENTER);

        JButton addBtn = new JButton("Add to Cart");
        addBtn.addActionListener(e -> {
            CartItems.getInstance().addItem(item);
            JOptionPane.showMessageDialog(this, item.getName() + " added to cart!");
            dispose();
        });

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(e -> {
            dispose();
        });

        panel.add(name);
        panel.add(price);
        panel.add(desc);
        panel.add(addBtn);
        panel.add(backBtn);

        add(panel);
        setVisible(true);
    }
}

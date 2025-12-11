import java.awt.*;
import javax.swing.*;

public class ItemDetailGUI extends JFrame {

    public ItemDetailGUI(MenuItem item) {
        setTitle("Item Details");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        JLabel name = new JLabel(item.getName(), SwingConstants.CENTER);
        name.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel price = new JLabel("Price: $" + item.getPrice(), SwingConstants.CENTER);
        JLabel desc = new JLabel("<html><center>" + item.getDescription() + "</center></html>", SwingConstants.CENTER);

        JButton addBtn = new JButton("Add to Cart");
        addBtn.addActionListener(e -> {
            CartItems.getInstance().addItem(item);
            JOptionPane.showMessageDialog(this, item.getName() + " added to cart!");
        });

        panel.add(name);
        panel.add(price);
        panel.add(desc);
        panel.add(addBtn);

        add(panel);
        setVisible(true);
    }
}

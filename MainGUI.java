import java.awt.*;
import javax.swing.*;

public class MainGUI extends JFrame {
    
    private JButton btnBrowseMenu;
    private JButton btnViewCart;
    private JButton btnCheckout;

    public MainGUI() {
        setTitle("Restaurant POS System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel title = new JLabel("Restaurant POS", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        btnBrowseMenu = new JButton("Browse Menu");
        btnViewCart = new JButton("View Cart");
        btnCheckout = new JButton("Checkout");

        btnBrowseMenu.addActionListener(e -> new MenuGUI());
        btnViewCart.addActionListener(e -> new CartGUI());
        btnCheckout.addActionListener(e -> JOptionPane.showMessageDialog(this, "Checkout coming soon"));

        panel.add(title);
        panel.add(btnBrowseMenu);
        panel.add(btnViewCart);
        panel.add(btnCheckout);

        add(panel);
        setVisible(true);
    }
}

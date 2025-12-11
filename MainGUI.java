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

        btnBrowseMenu.addActionListener(e -> new MenuGUI());
        btnViewCart.addActionListener(e -> new CartGUI());

        panel.add(title);
        panel.add(btnBrowseMenu);
        panel.add(btnViewCart);

        add(panel);
        setVisible(true);
    }
}

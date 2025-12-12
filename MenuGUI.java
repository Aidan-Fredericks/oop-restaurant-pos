import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuGUI extends JFrame {

    private JPanel menuPanel;

    public MenuGUI() {
        setTitle("Menu");
        setSize(500, 600);
        setLocationRelativeTo(null);

        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(menuPanel);
        add(scrollPane, BorderLayout.CENTER);

        loadMenuItems();

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(e -> {
            dispose();
            new MainGUI();
        });

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottom.add(backBtn);

        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void loadMenuItems() {
        ArrayList<MenuItem> menu = MenuData.getMenuItems();

        for (MenuItem item : menu) {
            JPanel itemPanel = new JPanel(new BorderLayout());
            itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel name = new JLabel(item.getName() + " - $" + item.getPrice());
            name.setFont(new Font("Arial", Font.BOLD, 16));

            JButton viewBtn = new JButton("View Details");
            viewBtn.addActionListener(e -> {
                dispose();
                new ItemDetailGUI(item);
            });

            itemPanel.add(name, BorderLayout.WEST);
            itemPanel.add(viewBtn, BorderLayout.EAST);

            menuPanel.add(itemPanel);
        }
    }
}

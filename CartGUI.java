
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CartGUI extends JFrame {
    private JTextArea items;

    public CartGUI() {
        setTitle("Shopping Cart");
        setSize(400, 300);
        setLocationRelativeTo(null);

        items = new JTextArea();
        items.setEditable(false);
        add(items);
        StringBuilder itemList = new StringBuilder("Items in Cart:\n");
        for (MenuItem item : new CartItems().getItems()) {
            itemList.append(item.getName()).append(" - $").append(item.getPrice()).append("\n");
        }

        items.setText(itemList.toString());

        setVisible(true);
    }
    
}

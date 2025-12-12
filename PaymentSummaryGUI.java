import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PaymentSummaryGUI extends JFrame{
    private static final double TAXRATE = 0.08;

    private JLabel subtotalLabel;
    private JLabel taxLabel;
    private JLabel grandTotalLabel;
    private JTextField tipField;
    private JButton tip15Btn;
    private JButton tip18Btn;
    private JButton tip20Btn;

    private double subtotal;
    private double tax;

    public PaymentSummaryGUI(){
        subtotal = 0;
        setTitle("Order Summary");
        setSize(500, 400);
        setLocationRelativeTo(null);

        CartItems cart = CartItems.getInstance();
        Map<MenuItem, Integer> items = cart.getItems();

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));

        if(items.isEmpty()){
            itemsPanel.add(new JLabel("No Items in Your Cart"));
        }
        else{
            for (Map.Entry<MenuItem, Integer> entry : items.entrySet()) {
                MenuItem item = entry.getKey();
                int qty = entry.getValue();
                double lineTotal = item.getPrice()*qty;
                subtotal += lineTotal;
                JLabel line = new JLabel(
                        qty + " x " + item.getName() +
                                " - $" + String.format("%.2f", lineTotal)
                );
                line.setFont(new Font("Arial", Font.PLAIN, 14));
                itemsPanel.add(line);
            }
        }

        JScrollPane scrolPane = new JScrollPane(itemsPanel);
        mainPanel.add(scrolPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        tax = subtotal * TAXRATE;
        //tax
        subtotalLabel = new JLabel("Subtotal: $" + String.format("%.2f", subtotal));
        taxLabel = new JLabel("Tax: $" + String.format("%.2f", tax));

        //tip
        JPanel tipPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        tipPanel.add(new JLabel("Tip: "));

        tip15Btn = new JButton("15%");
        tip18Btn = new JButton("18%");
        tip20Btn = new JButton("20%");

        tipField = new JTextField("0.00", 8);

        tipPanel.add(tip15Btn);
        tipPanel.add(tip18Btn);
        tipPanel.add(tip20Btn);
        tipPanel.add(new JLabel("$"));
        tipPanel.add(tipField);
        double initialTip = 0;
        double initialGrandTotal = subtotal + tax + initialTip;
        grandTotalLabel = new JLabel("Total (including tax & tip: $" + String.format("%.2f", initialGrandTotal));


        bottomPanel.add(subtotalLabel);
        bottomPanel.add(taxLabel);
        bottomPanel.add(tipPanel);
        bottomPanel.add(grandTotalLabel);

        //Buttons: Update total + Next page
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton updateBtn = new JButton("Update Total");
        JButton nextBtn = new JButton("Next: Payment");
        buttonsPanel.add(updateBtn);
        buttonsPanel.add(nextBtn);
        bottomPanel.add(buttonsPanel);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        setContentPane(mainPanel);
        tip15Btn.addActionListener(e -> setTipByPercentage(0.15));
        tip18Btn.addActionListener(e -> setTipByPercentage(0.18));
        tip20Btn.addActionListener(e -> setTipByPercentage(0.20));
        updateBtn.addActionListener(e -> updateGrandTotal());
        nextBtn.addActionListener(e -> {
            double tipAmount = getTipAmount();
            double grandTotal = subtotal + tax + tipAmount;

            Receipt receipt = new Receipt(
                    CartItems.getInstance().getItems(),
                    subtotal,
                    tax,
                    tipAmount
            );

            CartItems.getInstance().clear();
            dispose();
            new ReceiptGUI(receipt);
        });


        setVisible(true);

    }
    private void updateGrandTotal(){
        double tipAmount = getTipAmount();
        double grandTotal = subtotal + tax + tipAmount;
        grandTotalLabel.setText("Total (with tax & tip): $" + String.format("%.2f", grandTotal));
    }

    private void setTipByPercentage(double percent) {
        double tipAmount = subtotal * percent;
        tipField.setText(String.format("%.2f", tipAmount));
        updateGrandTotal();
    }
    private double getTipAmount() {
        String text = tipField.getText().trim();

        if (text.isEmpty()) {
            return 0;
        }

        try {
            double value = Double.parseDouble(text);
            if (value < 0) {
                return 0;
            }
            return value;
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}

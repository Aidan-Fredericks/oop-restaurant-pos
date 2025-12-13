import javax.swing.*;
import java.awt.*;

public class ReceiptGUI extends JFrame {

    public ReceiptGUI(Receipt receipt) {
        setTitle("Receipt");
        setSize(400, 520);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel paymentLabel = new JLabel(
                "<html><center>Please tap / insert / swipe your card<br/>" +
                "<b>Thank you</b></center></html>",
                SwingConstants.CENTER
        );
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 14));
        paymentLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextArea textArea = new JTextArea(receipt.toString());
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dispose());

        JPanel bottom = new JPanel();
        bottom.add(closeBtn);

        mainPanel.add(paymentLabel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottom, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
}

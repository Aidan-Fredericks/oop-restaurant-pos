import javax.swing.*;
import java.awt.*;

public class ReceiptGUI extends JFrame {

    public ReceiptGUI(Receipt receipt) {
        setTitle("Receipt");
        setSize(400, 500);
        setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea(receipt.toString());
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> {
            dispose();
            new MainGUI();
        });

        JPanel bottom = new JPanel();
        bottom.add(closeBtn);

        add(scrollPane, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setVisible(true);
    }
}

package Views;

import javax.swing.*;
import java.awt.*;

/**
 * CalculateWindow - A view for displaying statistics.
 * The design is consistent with ConnectionView (The "Papaj" Theme).
 */
public class CalculateWindow extends javax.swing.JFrame {
    
    // Constant colors for consistency
    private final Color GOLD_COLOR = new Color(255, 204, 0);
    private final Color ACCENT_GREEN = new Color(40, 167, 69);

    public CalculateWindow() {
        initComponents();
        setLocationRelativeTo(null); // Center on screen
    }

    private void initComponents() {
        // Main window settings
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Close only this window
        setTitle("Vatican Statistics & Analytics");
        setResizable(false);

        // Custom Background Panel (Scaling the image to 500x500)
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    // Using the same background for consistency
                    ImageIcon icon = new ImageIcon(getClass().getResource("/Papaj.jpg"));
                    g.drawImage(icon.getImage(), 0, 0, 500, 500, null);
                    
                    // Add a semi-transparent dark overlay to make text more readable
                    g.setColor(new Color(0, 0, 0, 150)); 
                    g.fillRect(0, 0, 500, 500);
                } catch (Exception e) {
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(0, 0, 500, 500);
                }
            }
        };
        
        backgroundPanel.setPreferredSize(new Dimension(500, 500));
        backgroundPanel.setLayout(null);

        // --- TITLE ---
        JLabel titleLabel = new JLabel("DIVINE STATISTICS", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(GOLD_COLOR);
        titleLabel.setBounds(0, 25, 500, 40);
        backgroundPanel.add(titleLabel);

        // --- LABELS AND FIELDS ---
        // We place labels and fields in a loop-like layout for cleanliness
        
        // 1. Total Clients
        jLabel1 = createCustomLabel("Total Registered Souls:", 100);
        backgroundPanel.add(jLabel1);
        jTextField1 = createCustomField(130);
        backgroundPanel.add(jTextField1);

        // 2. Average Age
        jLabel2 = createCustomLabel("Average Age of Believers:", 180);
        backgroundPanel.add(jLabel2);
        jTextField2 = createCustomField(210);
        backgroundPanel.add(jTextField2);

        // 3. Top Category
        jLabel3 = createCustomLabel("Most Blessed Category:", 260);
        backgroundPanel.add(jLabel3);
        jTextField3 = createCustomField(290);
        backgroundPanel.add(jTextField3);

        // 4. Revenue
        jLabel4 = createCustomLabel("Total Monthly Tithe (Revenue):", 340);
        backgroundPanel.add(jLabel4);
        jTextField4 = createCustomField(370);
        backgroundPanel.add(jTextField4);

        // --- CLOSE BUTTON ---
        JButton closeButton = new JButton("AMEN (CLOSE)");
        closeButton.setBounds(175, 430, 150, 40);
        closeButton.setBackground(ACCENT_GREEN);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.addActionListener(e -> this.dispose());
        backgroundPanel.add(closeButton);

        setContentPane(backgroundPanel);
        pack();
    }

    /**
     * Helper to create labels with consistent style
     */
    private JLabel createCustomLabel(String text, int yPos) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(Color.WHITE);
        label.setBounds(100, yPos, 300, 25);
        return label;
    }

    /**
     * Helper to create text fields with consistent style
     */
    private JTextField createCustomField(int yPos) {
        JTextField field = new JTextField();
        field.setBounds(100, yPos, 300, 30);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        field.setBackground(new Color(255, 255, 255, 200)); // Semi-transparent white
        field.setEditable(false);
        field.setHorizontalAlignment(JTextField.CENTER);
        field.setBorder(BorderFactory.createLineBorder(GOLD_COLOR, 1));
        return field;
    }

    /**
     * Updates the data in the view.
     * Translation: English (consistent with the theme)
     */
    public void setResults(int totalClients, double avgAge, String topCategory, double revenue) {
        jTextField1.setText(String.valueOf(totalClients) + " Users");
        jTextField2.setText(String.format("%.2f years", avgAge));
        jTextField3.setText(topCategory != null ? topCategory : "None");
        jTextField4.setText(String.format("%.2f PLN", revenue));
        
        // Smaczek: If revenue is very high, change color to gold
        if (revenue > 2137) {
            jTextField4.setForeground(new Color(184, 134, 11)); // Dark Gold
            jTextField4.setFont(new Font("Segoe UI", Font.BOLD, 16));
        }
    }

    public static void main(String args[]) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch (Exception e) {}
        java.awt.EventQueue.invokeLater(() -> new CalculateWindow().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
}
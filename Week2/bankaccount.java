import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bankaccount {

    static double balance = 0.0;
    static boolean balanceSet = false;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bank Balance Application");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblStartingBalance = new JLabel("Starting Balance:");

        JTextField txtStartingBalance = new JTextField(12);

        JLabel lblAmount = new JLabel("Amount:");

        JTextField txtAmount = new JTextField(12);

        JButton btnSetBalance = new JButton("Set Balance");

        JButton btnDeposit = new JButton("Deposit");

        JButton btnWithdraw = new JButton("Withdraw");

        JButton btnExit = new JButton("Exit");

        JLabel lblBalance = new JLabel("Current Balance: $0.00");
        lblBalance.setHorizontalAlignment(SwingConstants.CENTER);

        btnSetBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    balance = Double.parseDouble(txtStartingBalance.getText());
                    balanceSet = true;
                    lblBalance.setText(String.format("Current Balance: $%.2f", balance));
                    JOptionPane.showMessageDialog(frame, "Starting balance saved.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid starting balance.");
                }
            }
        });

        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!balanceSet) {
                    JOptionPane.showMessageDialog(frame, "Please set the starting balance first.");
                    return;
                }

                try {
                    double amount = Double.parseDouble(txtAmount.getText());

                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(frame, "Please enter an amount greater than zero.");
                        return;
                    }

                    balance += amount;
                    lblBalance.setText(String.format("Current Balance: $%.2f", balance));
                    txtAmount.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid deposit amount.");
                }
            }
        });

        btnWithdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!balanceSet) {
                    JOptionPane.showMessageDialog(frame, "Please set the starting balance first.");
                    return;
                }

                try {
                    double amount = Double.parseDouble(txtAmount.getText());

                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(frame, "Please enter an amount greater than zero.");
                        return;
                    }

                    if (amount > balance) {
                        JOptionPane.showMessageDialog(frame, "Insufficient funds.");
                        return;
                    }

                    balance -= amount;
                    lblBalance.setText(String.format("Current Balance: $%.2f", balance));
                    txtAmount.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid withdrawal amount.");
                }
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        String.format("Remaining Balance: $%.2f", balance));
                System.exit(0);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblStartingBalance, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(txtStartingBalance, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblAmount, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(txtAmount, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(btnSetBalance, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(btnDeposit, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(btnWithdraw, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(btnExit, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(lblBalance, gbc);

        frame.add(panel);
        frame.setSize(350, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

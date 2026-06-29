import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Menu {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Week 3 Note App");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea textBox = new JTextArea();
        textBox.setLineWrap(true);
        textBox.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textBox);
        frame.add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem dateTimeItem = new JMenuItem("Print Date and Time");
        JMenuItem logItem = new JMenuItem("Write to log.txt");
        JMenuItem greenItem = new JMenuItem("Change Background to Green Hue");
        JMenuItem exitItem = new JMenuItem("Exit");

        menu.add(dateTimeItem);
        menu.add(logItem);
        menu.add(greenItem);
        menu.add(exitItem);

        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        dateTimeItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
                textBox.setText(now.format(formatter));
            }
        });

        logItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter writer = new FileWriter("log.txt");
                    writer.write(textBox.getText());
                    writer.close();
                    JOptionPane.showMessageDialog(frame, "Text box contents written to log.txt.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Unable to write to log.txt.");
                }
            }
        });

        greenItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int red = random.nextInt(100);
                int green = 150 + random.nextInt(106);
                int blue = random.nextInt(100);

                Color greenHue = new Color(red, green, blue);
                frame.getContentPane().setBackground(greenHue);
                textBox.setBackground(greenHue);

                String hexColor = String.format("#%02X%02X%02X", red, green, blue);
                greenItem.setText("Green Hue: " + hexColor);
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}

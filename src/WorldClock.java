import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WorldClock extends JFrame {
    private JTextField timeZoneField;
    private JButton addButton;

    public WorldClock() {
        setTitle("World Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        timeZoneField = new JTextField("Enter GMT", 15);
        addButton = new JButton("Add Clock");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timeZoneId = timeZoneField.getText();
                addNewClock(timeZoneId);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        topPanel.add(timeZoneField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        topPanel.add(addButton, gbc);

        add(topPanel, BorderLayout.NORTH);
    }

    private void addNewClock(String timeZoneId) {
        JFrame frame = new JFrame("Clock - GMT" + timeZoneId);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 150);
        frame.setLocationRelativeTo(null);

        ClockPanel clockPanel = new ClockPanel(timeZoneId);
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerPanel.add(clockPanel);
        frame.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel label = new JLabel("Enter GMT:");
        JTextField inputField = new JTextField(10);
        JButton openButton = new JButton("Open");

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newTimeZoneId = inputField.getText();
                addNewClock(newTimeZoneId);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        bottomPanel.add(label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        bottomPanel.add(inputField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        bottomPanel.add(openButton, gbc);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}



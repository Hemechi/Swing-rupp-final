import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField textField1, textField2, resultField;

    public Calculator() {
        setTitle("Calculator");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel label1 = new JLabel("First Number:");
        textField1 = new JTextField();

        JLabel label2 = new JLabel("Second Number:");
        textField2 = new JTextField();

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);

        JButton addButton = new JButton("+");
        JButton subButton = new JButton("-");
        JButton mulButton = new JButton("*");
        JButton divButton = new JButton("/");
        JButton modButton = new JButton("%");
        JButton clearButton = new JButton("Clear");

        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        modButton.addActionListener(this);
        clearButton.addActionListener(this);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        add(label1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(textField1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(label2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(textField2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(resultLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(resultField, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(addButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(subButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(mulButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        add(divButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(modButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(clearButton, gbc);

        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        try {
            double num1 = Double.parseDouble(textField1.getText());
            double num2 = Double.parseDouble(textField2.getText());
            double result = 0;

            switch (command) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                case "%":
                    result = num1 % num2;
                    break;
                case "Clear":
                    textField1.setText("");
                    textField2.setText("");
                    resultField.setText("");
                    return;
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }
}

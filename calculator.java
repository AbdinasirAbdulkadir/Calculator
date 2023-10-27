import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator {

    private JFrame frame;
    private JTextField textField;

    double firstNumber;
    double secondNumber;
    double result;
    String operation;
    String answer;

    public calculator() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Simple Calculator");
        frame.setBounds(100, 100, 250, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textField = new JTextField();
        textField.setBounds(10, 11, 210, 36);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        // Number buttons
        JButton btn1 = createNumberButton("1", 10, 260, 50, 50);
        JButton btn2 = createNumberButton("2", 70, 260, 50, 50);
        JButton btn3 = createNumberButton("3", 130, 260, 50, 50);
        JButton btn4 = createNumberButton("4", 10, 200, 50, 50);
        JButton btn5 = createNumberButton("5", 70, 200, 50, 50);
        JButton btn6 = createNumberButton("6", 130, 200, 50, 50);
        JButton btn7 = createNumberButton("7", 10, 140, 50, 50);
        JButton btn8 = createNumberButton("8", 70, 140, 50, 50);
        JButton btn9 = createNumberButton("9", 130, 140, 50, 50);
        JButton btn0 = createNumberButton("0", 10, 320, 50, 50);

        // Decimal button
        JButton btnDot = createNumberButton(".", 70, 320, 50, 50);

        // Operation buttons
        JButton btnPlus = createOperationButton("+", 190, 260, 50, 50);
        JButton btnMinus = createOperationButton("-", 190, 200, 50, 50);
        JButton btnMul = createOperationButton("*", 190, 140, 50, 50);
        JButton btnDiv = createOperationButton("/", 190, 80, 50, 50);

        // Equals button
        JButton btnEquals = new JButton("=");
        btnEquals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secondNumber = Double.parseDouble(textField.getText());
                if (operation.equals("+")) {
                    result = firstNumber + secondNumber;
                    answer = String.format("%.2f", result);
                    textField.setText(answer);
                } else if (operation.equals("-")) {
                    result = firstNumber - secondNumber;
                    answer = String.format("%.2f", result);
                    textField.setText(answer);
                } else if (operation.equals("*")) {
                    result = firstNumber * secondNumber;
                    answer = String.format("%.2f", result);
                    textField.setText(answer);
                } else if (operation.equals("/")) {
                    result = firstNumber / secondNumber;
                    answer = String.format("%.2f", result);
                    textField.setText(answer);
                }
            }
        });
        btnEquals.setBounds(130, 320, 50, 50);
        frame.getContentPane().add(btnEquals);

        // Clear button
        JButton btnClear = new JButton("C");
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });
        btnClear.setBounds(190, 320, 50, 50);
        frame.getContentPane().add(btnClear);

        frame.setVisible(true);
    }

    private JButton createNumberButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String EnterNumber = textField.getText() + button.getText();
                textField.setText(EnterNumber);  // Append the number
            }
        });
        button.setBounds(x, y, width, height);
        frame.getContentPane().add(button);
        return button;
    }

    private JButton createOperationButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                firstNumber = Double.parseDouble(textField.getText());
                textField.setText("");
                operation = text;
            }
        });
        button.setBounds(x, y, width, height);
        frame.getContentPane().add(button);
        return button;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new calculator();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

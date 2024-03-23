package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame {

    private Mode m_mode;

    public CalculatorGUI() {
        m_mode = Mode.ADDITION;
        setTitle("Matrix Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel to hold grids and controls
        JPanel mainPanel = new JPanel();


        JTextArea matrix1 = new JTextArea(10, 20);
        matrix1.setLineWrap(true);
        matrix1.setWrapStyleWord(true);

        JScrollPane matrix1ScrollPane = new JScrollPane(matrix1);
        matrix1ScrollPane.setPreferredSize(new Dimension(250, 200));
        matrix1ScrollPane.setBounds(50, 50, 250, 200);

        JRadioButton addButton = new JRadioButton("Add");
        JRadioButton subtractButton = new JRadioButton("Subtract");
        JRadioButton multiplyButton = new JRadioButton("Multiply");
        JRadioButton dotProductButton = new JRadioButton("Dot Product");
        JRadioButton inverseButton = new JRadioButton("Inverse");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(addButton);
        buttonGroup.add(subtractButton);
        buttonGroup.add(multiplyButton);
        buttonGroup.add(dotProductButton);
        buttonGroup.add(inverseButton);

        addButton.setSelected(true);

        JPanel radioPanel = new JPanel();
        radioPanel.add(addButton);
        radioPanel.add(subtractButton);
        radioPanel.add(multiplyButton);
        radioPanel.add(dotProductButton);
        radioPanel.add(inverseButton);

        radioPanel.setBounds(300, 50, 100, 200);

        JTextArea matrix2 = new JTextArea(10, 20);
        matrix2.setLineWrap(true);
        matrix2.setWrapStyleWord(true);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(400, 275, 250, 40);

        JScrollPane matrix2ScrollPane = new JScrollPane(matrix2);
        matrix2ScrollPane.setPreferredSize(new Dimension(250, 200));
        matrix2ScrollPane.setBounds(400, 50, 250, 200); // Set bounds (x, y, width, height)

        JLabel equalsLabel = new JLabel(" = ");
        equalsLabel.setBounds(665, 50, 50, 200);
        equalsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        JTextArea resultMatrix = new JTextArea(10, 20);
        resultMatrix.setLineWrap(true);
        resultMatrix.setWrapStyleWord(true);
        
        JScrollPane resultMatrixScrollPane = new JScrollPane(resultMatrix);
        resultMatrixScrollPane.setPreferredSize(new Dimension(250, 200));
        resultMatrixScrollPane.setBounds(700, 50, 250, 200);

        ActionListener radioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton radioButton = (JRadioButton) e.getSource();
                if (radioButton.getText().equals("Inverse")) {
                    matrix2ScrollPane.setVisible(false);
                    m_mode = Mode.INVERSE;
                } else {
                    if (radioButton.getText().equals("Add")) {
                        m_mode = Mode.ADDITION;
                    } else if (radioButton.getText().equals("Subtract")) {
                        m_mode = Mode.SUBTRACTION;
                    } else if (radioButton.getText().equals("Multiply")) {
                        m_mode = Mode.MULTIPLICATION;
                    } else if (radioButton.getText().equals("Dot Product")) {
                        m_mode = Mode.DOT_PRODUCT;
                    }
                }
            }
        };

        addButton.addActionListener(radioListener);
        subtractButton.addActionListener(radioListener);
        multiplyButton.addActionListener(radioListener);
        dotProductButton.addActionListener(radioListener);
        inverseButton.addActionListener(radioListener);

        getContentPane().setLayout(null);
        getContentPane().add(matrix1ScrollPane);
        getContentPane().add(radioPanel);
        getContentPane().add(matrix2ScrollPane);
        getContentPane().add(calculateButton);
        getContentPane().add(equalsLabel);
        getContentPane().add(resultMatrixScrollPane);

        setSize(1000, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorGUI().setVisible(true);
            }
        });
    }
}

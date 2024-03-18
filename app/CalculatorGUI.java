package app;

import javax.swing.*;

public class CalculatorGUI extends JFrame {
    MatrixCalculator matrixCalculator;

    public CalculatorGUI() {
        setTitle("Matrix Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,1000);
        setLocationRelativeTo(null);

        matrixCalculator = new MatrixCalculator();

        setVisible(true);
        
        /********************************************************************
                                    START OF GUI                            
        ********************************************************************/
    
        JLabel outputLabel = new JLabel(matrixCalculator.test());
        outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(outputLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalculatorGUI::new);
    }
}
 
    


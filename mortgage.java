import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.awt.font.*;

public class mortgage implements  ActionListener{

    JPanel textPanel, panelForTextFields, yesPanel;
    JLabel titleLabel, mortgageLabel, yearsLabel, rateLabel, exLabel, paymentLabel;
    JTextField mortgageField, yearsField, rateField, paymentField;
    JButton calculateButton;
    private double loan, years, rate, monthlyPayment;

    public JPanel createContentPane (){

        JPanel calculatorGUI = new JPanel();
        calculatorGUI.setLayout(null);

        titleLabel = new JLabel("Mortgage Calculator");
        titleLabel.setLocation(110,0);
        titleLabel.setSize(180, 30);
        titleLabel.setHorizontalAlignment(0);
        calculatorGUI.add(titleLabel);

        textPanel = new JPanel();
        textPanel.setLayout(null);
        textPanel.setLocation(10, 35);
        textPanel.setSize(180, 190);
        calculatorGUI.add(textPanel);

        
        mortgageLabel = new JLabel("Mortgage Amount");
        mortgageLabel.setLocation(0, 10);
        mortgageLabel.setSize(130, 30);
        mortgageLabel.setHorizontalAlignment(4);
        textPanel.add(mortgageLabel);

        
        yearsLabel = new JLabel("Years");
        yearsLabel.setLocation(0, 50);
        yearsLabel.setSize(100, 30);
        yearsLabel.setHorizontalAlignment(4);
        textPanel.add(yearsLabel);
        
        rateLabel = new JLabel("Interest Rate");
        rateLabel.setLocation(0,90);
        rateLabel.setSize(100, 30);
        rateLabel.setHorizontalAlignment(4);
        textPanel.add(rateLabel);
        
        exLabel = new JLabel("Format: 8.0, 6.0 etc.");
        exLabel.setLocation(0,110);
        exLabel.setSize(100,30);
        exLabel.setHorizontalAlignment(4);
        textPanel.add(exLabel);
        
        paymentLabel = new JLabel("Monthly Payment");
        paymentLabel.setLocation(0,160);
        paymentLabel.setSize(150,30);
        paymentLabel.setHorizontalAlignment(4);
        textPanel.add(paymentLabel);

        panelForTextFields = new JPanel();
        panelForTextFields.setLayout(null);
        panelForTextFields.setLocation(250, 40);
        panelForTextFields.setSize(100, 180);
        calculatorGUI.add(panelForTextFields);

        
        mortgageField = new JTextField(8);
        mortgageField.setLocation(0, 0);
        mortgageField.setSize(100, 30);
        panelForTextFields.add(mortgageField);
        mortgageField.addActionListener(this);

        
        yearsField = new JTextField(8);
        yearsField.setLocation(0, 40);
        yearsField.setSize(100, 30);
        panelForTextFields.add(yearsField);
        yearsField.addActionListener(this);
        
        
        rateField = new JTextField(8);
        rateField.setLocation(0, 80);
        rateField.setSize(100, 30);
        panelForTextFields.add(rateField);
        rateField.addActionListener(this);
        
        
        
        paymentField = new JTextField(8);
        paymentField.setEditable(false);
        paymentField.setLocation(0,150);
        paymentField.setSize(100,30);
        panelForTextFields.add(paymentField);
        paymentField.addActionListener(this);

        
        yesPanel = new JPanel();
        yesPanel.setLayout(null);
        yesPanel.setLocation(40, 35);
        yesPanel.setSize(170, 180);
        calculatorGUI.add(yesPanel);

    
        //calculator go brrr
        calculateButton = new JButton("Calculate");
        calculateButton.setLocation(130, 250);
        calculateButton.setSize(150, 30);
        calculateButton.addActionListener(this);
        calculatorGUI.add(calculateButton);

            return calculatorGUI;
    }

  
    @Override
    public void actionPerformed(ActionEvent e) {
    	loan = (Double.parseDouble(mortgageField.getText()));
    	years = (Double.parseDouble(yearsField.getText()));
    	rate = (Double.parseDouble(rateField.getText()));
    	double mRate = (rate)/1200.0;
    	double months = (years)*12.0;
    	double mortgage = (Math.pow((1+mRate),months)-1);
    	monthlyPayment = (mRate + mRate/mortgage)*loan;
    	DecimalFormat x = new DecimalFormat("#.##");
    	monthlyPayment = Double.valueOf(x.format(monthlyPayment));
    	paymentField.setText("");
    	paymentField.setText(monthlyPayment +"");
       
            
        
    }


    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Mortgage Calculator");

        mortgage test = new mortgage();
        frame.setContentPane(test.createContentPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
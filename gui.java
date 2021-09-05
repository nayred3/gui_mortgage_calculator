import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.lang.*;
import java.text.NumberFormat;
import java.util.Locale;

public class gui implements ActionListener{

        private static final JLabel principalInt = null;
        private static final JLabel interestFloat = null;
        private static final JLabel yearsInt = null;
        private static final String paymentDouble = null;
        private static final JLabel Payment = null;




        public static void main(String[] args) {
            
            JPanel panel = new JPanel();
            JFrame frame = new JFrame();
            frame.setSize(350,200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.add(panel);
            panel.setLayout(null);




            
            JButton button = new JButton("Calculate");
            button.setBounds(10, 0, 150, 25);
            button.addActionListener(new gui());
            panel.add(button);

            frame.setVisible(true);

            //principal field beginning
            JLabel principal = new JLabel("Principal: ");
            principal.setBounds(10, 30, 80, 25);
            panel.add(principal);

            JTextField principalInt = new JTextField();
            principalInt.setBounds(100, 30, 165, 25);
            principalInt.addActionListener(new gui());
            panel.add(principalInt);

            frame.setVisible(true);
            




            //interest field beginning
            JLabel interestRate = new JLabel("Interest Rate: ");
            interestRate.setBounds(10, 60, 80, 25);
            panel.add(interestRate);
            frame.setVisible(true);

            JTextField interestFloat = new JTextField();
            interestFloat.setBounds(100, 60, 165, 25);
            panel.add(interestFloat);
            principalInt.addActionListener(new gui());
            frame.setVisible(true);
            



            //years field beginning
            JLabel years = new JLabel("Years: ");
            years.setBounds(10, 90, 80, 25);
            panel.add(years);
            frame.setVisible(true);

            JTextField yearsInt = new JTextField();
            yearsInt.setBounds(100, 90, 165, 25);
            panel.add(yearsInt);
            yearsInt.addActionListener(new gui());
            frame.setVisible(true);


           
            JLabel Payment = new JLabel("Payment: ");
            Payment.setBounds(10, 120, 80, 25);
            panel.add(Payment);
            frame.setVisible(true);
            

            


            

        }

             
        

        @Override
        public void actionPerformed(ActionEvent e) {
            String principal2 = principalInt.getText();
            String interest2 = interestFloat.getText();
            String years2 = yearsInt.getText();

            double principal = Double.parseDouble(principal2);
            double monthlyInterest = Double.parseDouble(interest2) / 12;
            double payments = Double.parseDouble(years2) * 12;
            double monthlyPayment = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, payments))
                / (Math.pow(1 + monthlyInterest, payments) - 1);
        
                Payment.setText(String.format("%.2f", monthlyPayment));

        }
}
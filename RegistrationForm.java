import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegistrationForm {
    JFrame jf;
    JDialog d;
    RegistrationForm(){
        // Components
        jf = new JFrame("Registration Form");
        JLabel userL = new JLabel("Username:");
        JLabel passL = new JLabel("Password:");
        JLabel cpassL = new JLabel("Confirm Password:");
        JLabel emailL = new JLabel("Email:");
        JLabel branchL = new JLabel("Branch:");
        JTextField username = new JTextField();
        JPasswordField pass = new JPasswordField();
        JPasswordField confirmpass = new JPasswordField();
        JTextField email = new JTextField();
        JRadioButton cse = new JRadioButton();
        JRadioButton ece = new JRadioButton();
        JRadioButton eee = new JRadioButton();
        ButtonGroup grp1 = new ButtonGroup();
        JButton submit = new JButton("Submit");
        JLabel status = new JLabel();
        JLabel cseL = new JLabel("CSE");
        JLabel eceL = new JLabel("ECE");
        JLabel eeeL = new JLabel("EEE");
        d = new JDialog(jf, "Login Status");

        // Adding and Events
        grp1.add(cse); 
        grp1.add(ece); 
        grp1.add(eee); 
        d.add(status);
        jf.add(userL);
        jf.add(username);
        jf.add(passL);
        jf.add(pass);
        jf.add(cpassL);
        jf.add(confirmpass);
        jf.add(emailL);
        jf.add(email);
        jf.add(branchL);
        jf.add(cse);
        jf.add(ece);
        jf.add(eee);
        jf.add(cseL);
        jf.add(eceL);
        jf.add(eeeL);
        jf.add(submit);


        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String passText = "" + new String(pass.getPassword());
                String confirmPassText = "" + new String(confirmpass.getPassword());
                String res = "";

                if( passText.equals(confirmPassText) ){
                    res = "Login Successful";
                }
                else{
                    res = "Login Failed";
                }
                status.setText(res);
                d.setVisible(true);
            }
        });

        jf.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                jf.dispose();
            }
        });

        // Layout
        jf.setLayout(null);
        jf.setSize(500, 500);
        userL.setBounds(50, 30, 100, 20);
        username.setBounds(250, 30, 150, 20);
        passL.setBounds(50, 80, 100, 20);
        pass.setBounds(250, 80, 150, 20);
        cpassL.setBounds(50, 130, 150, 20);
        confirmpass.setBounds(250, 130, 150, 20);
        emailL.setBounds(50, 180, 100, 20);
        email.setBounds(250, 180, 150, 20);
        branchL.setBounds(50, 230, 100, 20);
        cse.setBounds(250, 230, 20, 20);
        ece.setBounds(250, 270, 20, 20);
        eee.setBounds(250, 310, 20, 20);
        cseL.setBounds(280, 230, 100, 20);
        eceL.setBounds(280, 270, 100, 20);
        eeeL.setBounds(280, 310, 100, 20);
        submit.setBounds(50, 350, 400, 50);
        d.setSize(300, 100);
        status.setBounds(20, 20, 50, 20);
        jf.setVisible(true);
    }
    public static void main(String[] args){
        new RegistrationForm();
    }
}

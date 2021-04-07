# OOPS-Assignment-4

```java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator {
    JFrame main_frame;
    int operand_1 = 0, operand_2 = 0;
    char operator = 'N';
    Calculator(){
        // Components
        main_frame = new JFrame("Calculator");
        Label title = new Label("Calculator");
        TextField number = new TextField();
        Button add = new Button("+");
        Button sub = new Button("-");
        Button mul = new Button("x");
        Button div = new Button("/");
        Button clr = new Button("Clear");
        Button res = new Button("=");

        // Events
        main_frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                main_frame.dispose();
            }
        });
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                operand_1 = Integer.parseInt(number.getText());
                operator = '+';
                number.setText("");
            }
        });
        sub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                operand_1 = Integer.parseInt(number.getText());
                operator = '-';
                number.setText("");
            }
        });
        mul.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                operand_1 = Integer.parseInt(number.getText());
                operator = '*';
                number.setText("");
            }
        });
        div.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                operand_1 = Integer.parseInt(number.getText());
                operator = '/';
                number.setText("");
            }
        });
        res.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                operand_2 = Integer.parseInt(number.getText());
                number.setText("" + compute());
            }
        });
        clr.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                operand_1 = operand_2 = 0;
                operator = 'N';       
                number.setText("");         
            }
        });

        // Layout
        title.setBounds(105, 10, 100, 20);
        number.setBounds(20, 30, 250, 40);
        add.setBounds(40, 100, 50, 30);
        sub.setBounds(120, 100, 50, 30);
        mul.setBounds(40, 150, 50, 30);
        div.setBounds(120, 150, 50, 30);
        clr.setBounds(40, 200, 130, 30);
        res.setBounds(190, 100, 50, 130);
        main_frame.setLayout(null);
        main_frame.setSize(300,300);
        main_frame.add(number);
        main_frame.add(title);
        main_frame.add(add);
        main_frame.add(sub);
        main_frame.add(mul);
        main_frame.add(div);
        main_frame.add(clr);
        main_frame.add(res);
        main_frame.setVisible(true);
    }    
    float compute(){
        float res = 0;
        switch(operator){
            case '+': res = (float) operand_1 + operand_2; break;
            case '-': res = (float) operand_1 - operand_2; break;
            case '*': res = (float) operand_1 * operand_2; break;
            case '/': res = (float) operand_1 / operand_2; break;
            default: res = 0;
        }
        return res;
    }
    public static void main(String[] args){
        new Calculator();
    }
}


```

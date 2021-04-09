```java
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;

import javax.swing.*;

public class Notepad {
    JFrame jf;
    JLabel titleLabel, status;
    JTextArea writing_area;
    JButton submit, clear;
    String str, text;
    Notepad(){
        // Components
        try{
            File to_file = new File("demo.txt");
            if (to_file.createNewFile()) {
                System.out.println("File created: " + to_file.getName());
            } 
            else {
                System.out.println("File already exists.");
            }
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
        
        
        jf = new JFrame("Notepad");
        titleLabel = new JLabel("Enter text:");
        status = new JLabel();
        submit = new JButton("Submit");
        clear = new JButton("Clear");
        writing_area = new JTextArea();

        // Events
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                text = writing_area.getText();
                try{
                    if( text.split(" ").length < 30 )
                        throw new ArithmeticException();
                    FileOutputStream fos = new FileOutputStream("demo.txt");
                    byte[] b = text.getBytes();
                    fos.write(b);
                    fos.close();
                    str = "Successfully copied data into the file";
                }
                catch(ArithmeticException except){
                    str = "Minimum number of words should be 30";
                }
                catch(Exception except){
                    str = "Please try again!";
                }
                finally{
                    status.setText(str);
                }
            }
        });
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                writing_area.setText("");
                str = "Cleared";
                status.setText(str);
            }
        });
        jf.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                jf.dispose();
            }
        });

        // Layout
        jf.setSize(500, 300);
        titleLabel.setBounds(20, 20, 100, 20);
        writing_area.setBounds(20, 50, 440, 100);
        writing_area.setLineWrap(true);
        submit.setBounds(100, 170, 75, 40);
        clear.setBounds(300, 170, 75, 40);
        status.setBounds(100, 220, 300, 20);
        jf.add(titleLabel);
        jf.add(writing_area);
        jf.add(submit);
        jf.add(clear);
        jf.add(status);
        jf.setLayout(null);
        jf.setVisible(true);
    }
    public static void main(String[] args){
        new Notepad();
    }
}


```

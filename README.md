```java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEvents {
    JFrame jf;
    String str = "";
    MouseEvents(){
        // Components
        jf = new JFrame("Mouse Events");
        JLabel outputClicked = new JLabel();
        JLabel outputPressed = new JLabel();
        JLabel outputReleased = new JLabel();
        JLabel outputEntered = new JLabel();
        JLabel outputExited = new JLabel();

        // Adding and Layout
        jf.setSize(300, 300);
        outputEntered.setBounds(30, 0, 240, 240);
        outputPressed.setBounds(30, 20, 240, 240);
        outputReleased.setBounds(30, 40, 240, 240);
        outputClicked.setBounds(30, 60, 240, 240);
        outputExited.setBounds(30, 80, 240, 240);
        jf.add(outputClicked);
        jf.add(outputPressed);
        jf.add(outputReleased);
        jf.add(outputEntered);
        jf.add(outputExited);
        jf.setLayout(null);
        jf.setVisible(true);      

        // Event functions
        jf.addMouseListener( new MouseListener(){
            public void mouseClicked(MouseEvent e){
                outputClicked.setText("Mouse Clicked Time: " + System.currentTimeMillis());
            }
            public void mousePressed(MouseEvent e){
                outputPressed.setText("Mouse Pressed Time: " + System.currentTimeMillis());
            }
            public void mouseReleased(MouseEvent e){
                outputReleased.setText("Mouse Released Time: " + System.currentTimeMillis());
            }
            public void mouseEntered(MouseEvent e){
                outputEntered.setText("Mouse Entered Time: " + System.currentTimeMillis());
            }
            public void mouseExited(MouseEvent e){
                outputExited.setText("Mouse Exited Time: " + System.currentTimeMillis());
            }
        });
        jf.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                jf.dispose();
            }
        });
    }
        
    public static void main(String[] args){
        new MouseEvents();
    }    
}

```

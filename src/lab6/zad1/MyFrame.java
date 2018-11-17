package lab6.zad1;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(int xAxisSize, int yAxisSize, ShapeCollection collection){

        super("Hello World");

        JPanel panel = new MyPanel(xAxisSize, yAxisSize, collection);

        add(panel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50,50);

        setVisible(true);
    }
}

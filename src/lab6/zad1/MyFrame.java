package lab6.zad1;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(final int WIDTH, final int HEIGHT, ShapeCollection collection){

        super();

        MyPanel panel = new MyPanel(WIDTH, HEIGHT, collection);
        MousePanel mousePanel = new MousePanel(panel);

        add(panel);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50,50);

        setVisible(true);
    }
}

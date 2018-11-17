package lab6.zad1;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(final int WIDTH, final int HEIGHT, ShapeCollection collection){

        super("Figury");

        MyPanel panel = new MyPanel(WIDTH, HEIGHT, collection);
        MousePanel mousePanel = new MousePanel(panel);

        add(panel);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50,50);

        setVisible(true);
    }
}

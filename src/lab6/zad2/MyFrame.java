package lab6.zad2;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(final int WIDTH, final int HEIGHT, Polynomial polynomial)
    {
        super("Polynomial");

        MyPanel panel = new MyPanel(WIDTH, HEIGHT, polynomial);

        add(panel);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50,50);

        setVisible(true);

    }

}

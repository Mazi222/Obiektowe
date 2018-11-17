package lab6.zad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame{
    public static void main(String [] argv)
    {
        ShapeCollection collection = new ShapeCollection();
        collection.add(new Rectangle(10,10,50,50));
        Circle test = new Circle(10,200,300);

        Main dp = new Main();
        dp.setSize(800,500);
        dp.setVisible(true);

        dp.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }});
    }
}

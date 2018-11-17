package lab6.zad1;

import java.awt.*;

public class FrameTest {
    public static void main(String [] argv)
    {
        ShapeCollection collection = new ShapeCollection();
        collection.add(new Rectangle(100,100,500,500));
        collection.add(new Circle(100,200,300));

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame(1024, 768, collection);
            }
        });
    }
}

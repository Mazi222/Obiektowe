package lab6.zad1;

import java.awt.*;

public class FrameTest {
    public static void main(String [] argv)
    {
        int x[]={500,600,550};
        int y[]={400,400,300};


        ShapeCollection collection = new ShapeCollection();

        try
        {
            collection.add(new Triangle(x, y));
        }
        catch (badLenghtOfArrayOfVertex e)
        {
            System.out.println(e.xTableLenght + " " + e.yTableLenght);
        }

        collection.add(new Rectangle(600,100,300,500));

        collection.add(new Circle(100,700,100));
        collection.add(new Circle(100,300,100));


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyFrame(1024, 768, collection);
            }
        });
    }
}

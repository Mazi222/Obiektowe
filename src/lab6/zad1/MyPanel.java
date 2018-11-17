package lab6.zad1;

import sun.awt.image.ImageWatched;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MyPanel extends JPanel {

    ShapeCollection shapeCollection;

    final int WIDTH, HEIGHT;

    public MyPanel(final int WIDTH, final int HEIGHT, ShapeCollection shapeCollection)
    {
        super();

        this.WIDTH=WIDTH;
        this.HEIGHT=HEIGHT;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        this.shapeCollection = shapeCollection;

    }

    @Override
    public void paint(Graphics graphics)
    {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        LinkedList<Shape> toDraw = shapeCollection.getShapesList();
        for(Shape drawedShape : toDraw)
        {
            drawedShape.draw(graphics);
        }
    }

    public LinkedList<Shape> getShapeList()
    {
        return shapeCollection.getShapesList();
    }
}

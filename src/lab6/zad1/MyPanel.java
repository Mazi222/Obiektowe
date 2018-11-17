package lab6.zad1;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class MyPanel extends JPanel {
    ShapeCollection shapeCollection;
    public MyPanel(int xAxisSize, int yAxisSize, ShapeCollection shapeCollection)
    {
        super();
        setPreferredSize(new Dimension(xAxisSize,yAxisSize));
        this.shapeCollection = shapeCollection;
        repaint();
    }

    @Override
    public void paint(Graphics graphics)
    {
        LinkedList<Shape> toDraw = shapeCollection.getShapesList();
        for(Shape drawedShape : toDraw)
        {
            drawedShape.draw(graphics);
        }
    }
}

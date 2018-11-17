package lab6.zad1;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Square extends Shape {
    private static final byte numberOfEdges = 4;


    int edgeLength;

    int xAxisVal;
    int yAxisVal;

    Square(int edgeLength, int xAxisVal, int yAxisVal)
    {
        name="Rectangle";
        this.edgeLength = edgeLength;
        this.xAxisVal = xAxisVal;
        this.yAxisVal = yAxisVal;
    }

    @Override
    public void draw(Graphics graphics)
    {
        Graphics2D graphics2D = (Graphics2D)graphics;
        Rectangle2D rectangle2D = new Rectangle2D.Double(edgeLength, edgeLength, xAxisVal, yAxisVal);

        graphics2D.draw(rectangle2D);
    }

    public byte getNumberOfEdges() {
        return numberOfEdges;
    }
}

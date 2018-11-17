package lab6.zad1;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends Shape {

    private static final byte numberOfEdges = 0;

    int radius;
    int xAxisVal;
    int yAxisVal;


    Circle(int radius, int xAxisVal, int yAxisVal)
    {
        name = "Circle";
        this.radius = radius;
        this.xAxisVal = xAxisVal;
        this.yAxisVal = yAxisVal;
    }

    @Override
    public void draw(Graphics graphics)
    {
        Graphics2D g2d = (Graphics2D)graphics;
        Ellipse2D circle = new Ellipse2D.Double(xAxisVal,yAxisVal,radius,radius);
        g2d.draw(circle);
    }

    public byte getNumberOfEdges() {
        return numberOfEdges;
    }
}

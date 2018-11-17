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
        Graphics2D graphics2D = (Graphics2D)graphics;
        Ellipse2D circle = new Ellipse2D.Double(xAxisVal,yAxisVal,radius,radius);
       // GradientPaint gp = new GradientPaint(xAxisVal-radius/2, yAxisVal-radius/2, Color.red,xAxisVal+radius/2, yAxisVal+radius/2, Color.blue, false);
       // g2d.setPaint(gp);

        graphics2D.fill(circle);
        graphics2D.draw(circle);
    }

    public byte getNumberOfEdges() {
        return numberOfEdges;
    }
}

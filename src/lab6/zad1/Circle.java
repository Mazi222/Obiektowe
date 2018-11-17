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

        /* radius *2 gdyz jest on traktowany jako średnica */
        Ellipse2D circle = new Ellipse2D.Double(xAxisVal,yAxisVal,2*radius,2*radius);

        graphics2D.setColor(new Color(0,0,0));
        graphics2D.fill(circle);
        graphics2D.draw(circle);
    }

    @Override
    public byte getNumberOfEdges()
    {
        return numberOfEdges;
    }

    @Override
    public boolean mouseIn(int mouseXAxisVal, int mouseYAxisVal)
    {
        return ((mouseXAxisVal-xAxisVal-radius)*(mouseXAxisVal-xAxisVal-radius) + (mouseYAxisVal-yAxisVal-radius)*(mouseYAxisVal-yAxisVal-radius)) <= (radius*radius);
    }

    @Override
    public void setNewAxisValues(int xAxisValOfMouse, int yAxisValOfMouse)
    {
        this.xAxisVal += xAxisValOfMouse;
        this.yAxisVal += yAxisValOfMouse;
    }
}

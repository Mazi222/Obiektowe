package lab6.zad1;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle extends Shape {

    private static final byte numberOfEdges = 4;

    int width;
    int height;

    int xAxisVal;
    int yAxisVal;

    Rectangle(int width, int height, int xAxisVal, int yAxisVal)
    {
        name="Rectangle";
        this.width = width;
        this.height = height;
        this.xAxisVal = xAxisVal;
        this.yAxisVal = yAxisVal;
    }

    @Override
    public void draw(Graphics graphics)
    {
            Graphics2D graphics2D = (Graphics2D)graphics;
            Rectangle2D rectangle2D = new Rectangle2D.Double(xAxisVal, yAxisVal, width, height);

            graphics2D.setColor(new Color(0,0,0));
            graphics2D.fill(rectangle2D);
            graphics2D.draw(rectangle2D);
    }

    @Override
    public byte getNumberOfEdges()
    {
        return numberOfEdges;
    }

    @Override
    public boolean mouseIn(int mouseXAxisVal, int mouseYAxisVal)
    {
        return (mouseXAxisVal<= xAxisVal + width && mouseXAxisVal >= xAxisVal && mouseYAxisVal <= yAxisVal + height && mouseYAxisVal >= yAxisVal);
    }

    @Override
    public void setNewAxisValues(int xAxisValOfMouse, int yAxisValOfMouse)
    {
        this.xAxisVal += xAxisValOfMouse;
        this.yAxisVal += yAxisValOfMouse;
    }
}

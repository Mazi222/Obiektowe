package lab6.zad1;

import java.awt.*;

public class Triangle extends Shape {

    private static final byte numberOfEdges = 3;
    private int xAxisValues[];
    private int yAxisValues[];

    private Polygon trianglePolygon;

    Triangle(int xAxisValues[],int yAxisValues[]) throws badLenghtOfArrayOfVertex {
        name="Triangle";
        this.xAxisValues=xAxisValues;
        this.yAxisValues=yAxisValues;
        if(xAxisValues.length !=3 || yAxisValues.length !=3)
        {
            throw new badLenghtOfArrayOfVertex(xAxisValues.length,yAxisValues.length);
        }
        trianglePolygon = new Polygon(this.xAxisValues,this.yAxisValues,3);
    }

    @Override
    public void draw(Graphics graphics)
    {
        Graphics2D graphics2D = (Graphics2D)graphics;

        graphics2D.setColor(new Color(0,0,0));
        graphics2D.fill(trianglePolygon);
        graphics2D.draw(trianglePolygon);
    }

    @Override
    public byte getNumberOfEdges() {
        return numberOfEdges;
    }

    @Override
    public boolean mouseIn(int mouseXAxisVal, int mouseYAxisVal)
    {
        return new Polygon(xAxisValues,yAxisValues,3).contains(mouseXAxisVal,mouseYAxisVal);
    }

    @Override
    public void setNewAxisValues(int xAxisValOfMouse, int yAxisValOfMouse)
    {
        for(int i=0;i<3;++i)
        {

            trianglePolygon.xpoints[i] += xAxisValOfMouse;
            trianglePolygon.ypoints[i] += yAxisValOfMouse;
            xAxisValues = trianglePolygon.xpoints;
            yAxisValues = trianglePolygon.ypoints;

        }
    }

}

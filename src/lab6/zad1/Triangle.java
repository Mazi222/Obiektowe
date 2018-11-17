package lab6.zad1;

import java.awt.*;

public class Triangle extends Shape {

    private static final byte numberOfEdges = 3;

    Triangle(){
        name="Triangle";
    }

    @Override
    public void draw(Graphics graphics)
    {

    }

    public byte getNumberOfEdges() {
        return numberOfEdges;
    }
}

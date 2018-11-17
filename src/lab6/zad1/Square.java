package lab6.zad1;

import java.awt.*;

public class Square extends Shape {
    private static final byte numberOfEdges = 4;

    Square(){
        name="Square";
    }

    @Override
    public void draw(Graphics graphics)
    {
    }

    public byte getNumberOfEdges() {
        return numberOfEdges;
    }
}

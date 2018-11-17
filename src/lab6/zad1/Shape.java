package lab6.zad1;

import java.awt.*;

public abstract class Shape {
    public String name;
    public abstract void draw(Graphics graphics);
    public abstract byte getNumberOfEdges();
}


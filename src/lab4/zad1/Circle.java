package lab4.zad1;

public class Circle extends Shape {
    private static final byte numberOfEdges = 0;

    Circle(){
        name="Circle";
    }

    @Override
    public void draw()
    {

    }

    public byte getNumberOfEdges() {
        return numberOfEdges;
    }
}

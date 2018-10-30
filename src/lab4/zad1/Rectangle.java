package lab4.zad1;

public class Rectangle extends Shape {

    private static final byte numberOfEdges = 4;

    Rectangle(){
        name="Rectangle";
    }

    @Override
    public void draw()
    {

    }

    public byte getNumberOfEdges() {
        return numberOfEdges;
    }
}

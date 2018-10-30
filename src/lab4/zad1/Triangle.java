package lab4.zad1;

public class Triangle extends Shape{

    private static final byte numberOfEdges = 3;

    Triangle(){
        name="Triangle";
    }

    @Override
    public void draw()
    {

    }

    public byte getNumberOfEdges() {
        return numberOfEdges;
    }
}

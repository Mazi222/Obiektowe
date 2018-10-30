package lab4.zad1;

public class Square extends Shape{
    private static final byte numberOfEdges = 4;

    Square(){
        name="Square";
    }

    @Override
    public void draw()
    {

    }

    public byte getNumberOfEdges() {
        return numberOfEdges;
    }
}

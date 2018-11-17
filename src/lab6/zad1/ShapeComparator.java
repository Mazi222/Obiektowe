package lab6.zad1;

public class ShapeComparator implements java.util.Comparator<Shape> {
    @Override
    public int compare(Shape shape, Shape shape2) {
        if(shape.getNumberOfEdges()<shape2.getNumberOfEdges())
            return -1;
        else if(shape.getNumberOfEdges()>shape2.getNumberOfEdges())
            return 1;
        return 0;
    }

}

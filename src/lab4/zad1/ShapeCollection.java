package lab4.zad1;

import java.util.Collections;
import java.util.LinkedList;

public class ShapeCollection {
    private LinkedList<Shape> shapesList = null;

    ShapeCollection(){
        shapesList = new LinkedList<>();
    }

    public void add(Shape toAdd){
        shapesList.add(toAdd);
    }

    public LinkedList<Shape> getShapesList(){
        return shapesList;
    }

    public void sortShapes(){
        ShapeComparator comparator = new ShapeComparator();
        for(Shape i : shapesList)
        {
            Collections.sort(shapesList, comparator);
        }
    }

    public void showShapesList(){
        for(Shape i : shapesList)
        {
            System.out.println(i.name);
        }
    }
}

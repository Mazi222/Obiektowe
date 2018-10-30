package lab4.zad1;

public class Main {
    public static void main(String [] argv)
    {
        ShapeCollection collection = new ShapeCollection();
        collection.add(new Square());
        collection.add(new Triangle());
        collection.add(new Square());

        for(Shape i : collection.getShapesList())
        {
            System.out.println(i.name);
        }
        collection.sortShapes();

        for(Shape i : collection.getShapesList())
        {
            System.out.println(i.name);
        }
    }
}

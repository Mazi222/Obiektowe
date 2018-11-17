package lab6.zad1;

public class badLenghtOfArrayOfVertex extends Exception{

    int xTableLenght;
    int yTableLenght;

    public badLenghtOfArrayOfVertex(int x, int y)
    {
        super();
        xTableLenght=x;
        yTableLenght=y;
    }

    public int getxTableLenght() {
        return xTableLenght;
    }
    public int getyTableLenght() {
        return yTableLenght;
    }
}

package lab2.Zad_2_3_4;


public class Prostokat extends Kwadrat{
    private double b;
    public Prostokat(double _a,double _b){
        super(_a);
        if(_b<0)
            System.out.println("Bledne dane");
        b=_b;
    }
    public double getB(){
        return b;
    }
    public void setB(double _b){
        b=_b;
    }

    public double area(){
        return getA()*b;
    }

    public boolean isBigger(Prostokat p2){
        return area()<p2.area();
    }

}


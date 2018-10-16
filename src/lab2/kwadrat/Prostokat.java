package lab2.kwadrat;


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
    public boolean isBigger(Prostokat p2){
        return a*b<p2.a*p2.b;
    }

}


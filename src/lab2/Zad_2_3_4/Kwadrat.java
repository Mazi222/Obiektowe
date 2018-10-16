package lab2.Zad_2_3_4;

public class Kwadrat {
    private double a;
    public Kwadrat(double _a){
        if(_a<0)
            System.out.println("Bledne dane"); // Tutaj powinien być wyjątek
        a=_a;
    }
    public double getA(){
        return a;
    }
    public void setA(double _a){
        a=_a;
    }
    public double area(){
        return a*a;
    }
    public boolean isBigger(Kwadrat k2)
    {
        return a<k2.a;
    }
}

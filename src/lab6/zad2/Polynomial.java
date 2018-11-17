package lab6.zad2;

/* Maksymalnie 4 stopnia (ax^4 + bx^3 + cx^2 +dx + e) */

public class Polynomial {
    double a;
    double b;
    double c;
    double d;

    public Polynomial()
    {
        this.a=0;
        this.b=0;
        this.c=0;
        this.d=0;
    }


    public Polynomial(double d,double c,double b,double a)
    {
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }



}

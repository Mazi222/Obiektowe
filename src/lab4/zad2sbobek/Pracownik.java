package lab4.zad2sbobek;

import lab1.Pesel.PESEL;


public abstract class Pracownik {
    private PESEL pesel;
    private double wynagrodzenieBrutto;

    Pracownik(PESEL _pesel, double _wynagrodzenieBrutto)
    {
        pesel=_pesel;
        wynagrodzenieBrutto=_wynagrodzenieBrutto;
    }
    public abstract double obliczWynagrodzenieNetto();

    public PESEL getPesel() {
        return pesel;
    }

    public void setPesel(PESEL pesel) {
        this.pesel = pesel;
    }

    public double getWynagrodzenieBrutto() {
        return wynagrodzenieBrutto;
    }

    public void setWynagrodzenieBrutto(double wynagrodzenieBrutto) {
        this.wynagrodzenieBrutto = wynagrodzenieBrutto;
    }

}

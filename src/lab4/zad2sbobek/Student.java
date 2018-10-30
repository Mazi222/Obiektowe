package lab4.zad2sbobek;

import lab1.Pesel.PESEL;

public class Student extends Pracownik{
    public Student(PESEL _pesel, double _wynagrodzenieBrutto) {
        super(_pesel,_wynagrodzenieBrutto);
    }

    @Override
    public double obliczWynagrodzenieNetto() {
        return getWynagrodzenieBrutto()-getWynagrodzenieBrutto()*0.144;
    }
}

package lab4.zad2sbobek;

import lab1.Pesel.PESEL;

public class PracownikEtatowy extends Pracownik{

    PracownikEtatowy(PESEL _pesel, double _wynagrodzenieBrutto)
    {
        super(_pesel,_wynagrodzenieBrutto);
    }

    @Override
    public double obliczWynagrodzenieNetto(){
        return getWynagrodzenieBrutto()-getWynagrodzenieBrutto()*0.144;
    }
}

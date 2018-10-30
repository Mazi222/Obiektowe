package lab4.zad2sbobek;

import lab1.Pesel.PESEL;

import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String [] argv)
    {
        String test = "98120103750";
        PESEL pesel = new PESEL(test);
        Kadry kadra = new Kadry();
        kadra.dodajPracownikaStudenta(pesel,100);

        String test2 = "98120103750";
        PESEL pesel2 = new PESEL(test);
        kadra.dodajPracownikaStudenta(pesel2,50);

        String test3 = "98120103750";
        PESEL pesel3 = new PESEL(test);
        kadra.dodajPracownikaStudenta(pesel3,150);

        for(Pracownik i : kadra.getListapracownikow())
        {
            System.out.println(i.getWynagrodzenieBrutto());
        }

        Comparator<Pracownik> pracownikComparator = new PracownikComparator();
        Collections.sort(kadra.getListapracownikow(), pracownikComparator);

        for(Pracownik i : kadra.getListapracownikow())
        {
            System.out.println(i.getWynagrodzenieBrutto());
        }

    }
}

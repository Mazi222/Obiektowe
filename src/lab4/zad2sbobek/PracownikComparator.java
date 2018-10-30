package lab4.zad2sbobek;

import java.util.Comparator;

public class PracownikComparator implements Comparator<Pracownik> {
    public int compare(Pracownik pracownik1, Pracownik pracownik2)
    {
        if(pracownik1.getWynagrodzenieBrutto()<pracownik2.getWynagrodzenieBrutto())
            return -1;
        if(pracownik1.getWynagrodzenieBrutto()>pracownik2.getWynagrodzenieBrutto())
            return 1;
        return 0;
    }
}

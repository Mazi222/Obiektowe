package lab4.zad2;

import lab1.Pesel.PESEL;

import java.util.LinkedList;

public class Kadry {
    private LinkedList<Pracownik> listapracownikow;

    Kadry()
    {
        listapracownikow = new LinkedList<>();
    }

    public void dodajPracownikaStudenta(PESEL _pesel, double _wynagrodzenieBrutto) {
        listapracownikow.add(new Student(_pesel, _wynagrodzenieBrutto));
    }

    public void dodajPracownikaEtatowego(PESEL _pesel, double _wynagrodzenieBrutto) {
        listapracownikow.add(new PracownikEtatowy(_pesel, _wynagrodzenieBrutto));
    }

    public void remove(PESEL pesel) {
        for(int i=0;i<listapracownikow.size();++i)
        {
            if(listapracownikow.get(i).getPesel().getPESEL().equals(pesel.getPESEL()))
            {
                listapracownikow.remove(i);
                break;
            }
        }
    }
    public double getWynagrodzenieBrutto(PESEL pesel)
    {
        for (Pracownik aListapracownikow : listapracownikow) {
            if (aListapracownikow.getPesel().getPESEL().equals(pesel.getPESEL())) {
                return aListapracownikow.getWynagrodzenieBrutto();
            }
        }
        return 0;
    }
    public double getWynagrodzenieNetto(PESEL pesel)
    {
        for (Pracownik aListapracownikow : listapracownikow) {
            if (aListapracownikow.getPesel().getPESEL().equals(pesel.getPESEL())) {
                return aListapracownikow.obliczWynagrodzenieNetto();
            }
        }
        return 0;
    }
    public boolean setWynagrodzenieBrutto(PESEL pesel,double noweWynagrodzenieBrutto)
    {
        for (Pracownik aListapracownikow : listapracownikow) {
            if (aListapracownikow.getPesel().getPESEL().equals(pesel.getPESEL())) {
                aListapracownikow.setWynagrodzenieBrutto(noweWynagrodzenieBrutto);
                return true;
            }
        }
        return false;
    }

    public LinkedList<Pracownik> getListapracownikow() {
        return listapracownikow;
    }

    public void setListapracownikow(LinkedList<Pracownik> listapracownikow) {
        this.listapracownikow = listapracownikow;
    }

}

package lab1.Pesel;

public class PESEL {

    private String pesel_numb;

    private static int [] wagi = {1,3,7,9,1,3,7,9,1,3,1};           //wagi poszczególnych cyfr peselu
    public static boolean check (String tocheck)
    {
        int suma=0;
        char [] digitChars= new char [11];

        if(tocheck.length() != 11) return false;                    //sprawdzanie długości
        tocheck.getChars(0,11,digitChars,0);            //zamiana stringa na chary
        if((digitChars[4]-'0')*10+(digitChars[5]-'0') > 31)     // jeżeli dzień przekroczy 31 to znaczy że jest błędny, podobnego rozumowania nie można przeprowadzić dla miesięcy gdyż z każdym stuleciem się one zmieniają
            System.out.println("Bledny dzien");
        for(int i=0;i<11;++i)
            suma+=((digitChars[i]-'0')*wagi[i]);
        return (suma%10 == 0);                                      //sprawdzenie sumy kontrolnej
    }


    public PESEL (String pesel_num)
    {
        pesel_numb = pesel_num;

    }

    public String getPESEL()
    {
        return pesel_numb;
    }

}

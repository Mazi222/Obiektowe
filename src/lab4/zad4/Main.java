package lab4.zad4;

public class Main {
    public static void main(String [] argv)
    {
        String aa ="0123456789";
        int [] tab = new int[9];
        for(int i=0;i<9;++i)
            tab[i]=i;
        System.out.println(tab[aa.charAt(2) -48]);

    }
}

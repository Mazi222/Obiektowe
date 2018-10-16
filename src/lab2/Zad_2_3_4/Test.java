package lab2.Zad_2_3_4;

import java.util.*;

public class Test {
    public static void main(String [] argv){
        LinkedList<Prostokat> figury = new LinkedList<Prostokat>();
        boolean quit =false;
        Scanner odczyt = new Scanner(System.in);
        while(!quit){
            System.out.print(
                    "1.Wczytaj prostokat\n" +
                            "2.Wyswietl wszystkie prostokaty\n" +
                            "3.Oblicz sume pol wszystkich prostokatow\n" +
                            "4.Zakoncz\n"
            );
            int wybor = odczyt.nextInt();
            if(1==wybor)
            {
                System.out.println("Podaj a,b: ");
                figury.add(new Prostokat(odczyt.nextDouble(),odczyt.nextDouble()));
            }
            else if(2==wybor)
            {
                int i=0;
                for(Prostokat it : figury)
                {
                    System.out.println("Prostokat nr "+ (++i) + ": a= " + it.getA() + ", b= " + it.getB());
                }
            }
            else if(3==wybor)
            {
                double suma=0;
                for(Prostokat it : figury)
                {
                    suma+=it.area();
                }
                System.out.println(suma);
            }
            else if(4==wybor)
            {
                quit=true;
            }
            else
            {
                System.out.println("Bledne dane");
            }
        }
    }
}
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
            byte wybor = odczyt.nextByte();
            switch(wybor)
            {
                case 1:
                    System.out.println("Podaj a,b: ");
                    figury.add(new Prostokat(odczyt.nextDouble(),odczyt.nextDouble()));
                    break;
                case 2:
                    int i=0;
                    for(Prostokat it : figury)
                    {
                        System.out.println("Prostokat nr "+ (++i) + ": a= " + it.getA() + ", b= " + it.getB());
                    }
                    break;
                case 3:
                    double suma=0;
                    for(Prostokat it : figury)
                    {
                        suma+=it.area();
                    }
                    System.out.println(suma);
                    break;
                case 4:
                    quit=true;
                    break;
                default:
                    System.out.println("Bledne dane");
                    break;
            }
        }
    }
}

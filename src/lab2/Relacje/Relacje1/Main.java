package lab2.Relacje.Relacje1;

import lab2.Relacje.Relacje2.*;

public class Main {
    public static void main(String [] argv){
        A testA = new A(12,"TestA");
        B testB = new B(19,"TestB");
        C testC = new C(3,"TestC");


        System.out.println("Przed zmianami: ");
        testA.print();
        testB.print();
        testC.print();

        testA.callDecrement();
        testB.callDecrement();
        testC.callDecrement();

        System.out.println("\nPo dekrementacji: ");
        testA.print();
        testB.print();
        testC.print();

        testA.callIncrement();
        testB.callIncrement();
        testC.callIncrement();

        System.out.println("\nPo dekrementacji i inkrementacji: ");
        testA.print();
        testB.print();
        testC.print();

        testA.callchangeName("TA");
        testB.callchangeName("TB");
        testC.callchangeName("TC");

        System.out.println("\nPo dekrementacji ,inkrementacji i zmianie nazwy: ");
        testA.print();
        testB.print();
        testC.print();
    }
}

package lab4.zad4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CryptoTest {
    public static void main(String [] argv)
    {
        byte szyfrowanie =0;
        byte algorytm = 0;
        File inputFile = new File(argv[0]);                    //Przygotowanie plików do odczytu i zapisu
        File outputFile = new File(argv[1]);

        Scanner odczyt = new Scanner(System.in);

        System.out.println("1.Szyfrowanie");                 // Wybór tego czy chcemy plik szyfrować czy deszyfrować
        System.out.println("2.Deszyfrowanie");
        String choice = odczyt.nextLine();

        if(choice.equals("1")) szyfrowanie=1;
        else if(choice.equals("2")) szyfrowanie=2;

        System.out.println("1.ROT11");                 // Wybór algorytmu
        System.out.println("2.Polibiusz");
        choice = odczyt.nextLine();

        try {
            if (choice.equals("1")) {
                if (szyfrowanie == 1)
                    Cryptographer.cryptfile(inputFile, outputFile, new ROT11());
                else if (szyfrowanie == 2)
                    Cryptographer.decryptfile(inputFile, outputFile, new ROT11());
            } else if (choice.equals("2")) {
                if (szyfrowanie == 1)
                    Cryptographer.cryptfile(inputFile, outputFile, new Polibiusz());
                else if (szyfrowanie == 2)
                    Cryptographer.decryptfile(inputFile, outputFile, new Polibiusz());
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

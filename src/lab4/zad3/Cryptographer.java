package lab4.zad3;

import java.io.*;
import java.util.Scanner;

public class Cryptographer {
    public static void cryptfile(File inputfile, File outputfile, Algorithm toalgorithm) throws IOException {
        FileWriter outputwrite = null;
        Scanner odczyt = null;

        try {
            odczyt = new Scanner(inputfile);
            outputwrite = new FileWriter(outputfile);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        while(odczyt.hasNextLine())
        {
            Scanner odczyt2 = new Scanner(odczyt.nextLine());
            while (odczyt2.hasNext())
            {
                String s = odczyt2.next();
                assert outputwrite != null;
                outputwrite.write(toalgorithm.crypt(s));
                outputwrite.write(" ");
            }
            outputwrite.write("\n");
        }

        outputwrite.close();
        odczyt.close();
    }
    public static void decryptfile(File inputfile, File outputfile, Algorithm toalgorithm) throws IOException {

        FileWriter outputwrite = null;
        Scanner odczyt = null;

        try {
            odczyt = new Scanner(inputfile);
            outputwrite = new FileWriter(outputfile);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        while(odczyt.hasNextLine())
        {
            Scanner odczyt2 = new Scanner(odczyt.nextLine());
            while (odczyt2.hasNext())
            {
                String s = odczyt2.next();
                outputwrite.write(toalgorithm.decrypt(s));
                outputwrite.write(" ");
            }
            outputwrite.write("\n");
        }

        outputwrite.close();
    }
}

package lab5.Napisy;

import java.io.IOException;

public class SubtitleTEST {
    public static void main(String [] argv)
    {
        SubtitleTimeChanger subtitleTimeChanger = new SubtitleTimeChanger();
        try
        {
            subtitleTimeChanger.delay(argv[0],argv[1],1000,24);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Nie znaleziono pliku lub nastąpił błąd przy otwarciu");
        }
        catch (WrongFramesException e)
        {
            e.printStackTrace();
        }
        catch (NoMatchFoundExepction e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println("Nieznany wyjatek w lini"+e.getStackTrace()[0].getLineNumber());
        }
        finally
        {
            System.out.println("Koniec");
        }
    }
}

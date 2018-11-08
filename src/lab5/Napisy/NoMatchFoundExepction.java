package lab5.Napisy;

public class NoMatchFoundExepction extends Exception {
    public NoMatchFoundExepction(String line)
    {
        super("Niemozna dopasowac wartosci klatek".concat(line));
    }
}

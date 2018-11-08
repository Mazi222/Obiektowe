package lab5.Napisy;

public class WrongFramesException extends Exception {
    public WrongFramesException(String line)
    {
        super("Nieodpowiedznie wartości klatek".concat(line));
    }
}

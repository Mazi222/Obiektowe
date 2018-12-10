package lab9;

import java.util.LinkedList;
import java.util.List;

public class DaneUzytkownika {
    private String idUzytkownika;
    private String password;
    private List<Message> listOfMessage;
    private boolean loggedOn; // true jezeli zalogowany

    DaneUzytkownika(String idUzytkownika, String password, Message message)
    {
        this.idUzytkownika=idUzytkownika;
        this.password=password;
        listOfMessage = new LinkedList<>();
        listOfMessage.add(message);
        this.loggedOn=true;
    }

    String getId()
    {
        return idUzytkownika;
    }
    String getPassword()
    {
        return password;
    }

    List<Message> getMessageList()
    {
        return listOfMessage;
    }
    void clearMessageList()
    {
        this.listOfMessage.clear();
    }
    void addToMessageList(String textMessage, Shape shape)
    {
        listOfMessage.add(new Message(textMessage, shape));
    }

    boolean getLoggedOn()
    {
        return loggedOn;
    }

    void setLoggedOn(boolean isLogged)
    {
        loggedOn=isLogged;
    }

}

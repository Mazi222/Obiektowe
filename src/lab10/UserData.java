package lab10;

import java.util.LinkedList;
import java.util.List;

public class UserData {
    private String userId;
    private String password;
    private List<Message> listOfMessage;
    private boolean loggedOn; // true jezeli zalogowany

    UserData(String userId, String password, Message message)
    {
        this.userId=userId;
        this.password=password;
        listOfMessage = new LinkedList<>();
        listOfMessage.add(message);
        this.loggedOn=true;
    }

    String getId()
    {
        return userId;
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

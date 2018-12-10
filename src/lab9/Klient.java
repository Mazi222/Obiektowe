package lab9;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

public class Klient {
    private String idUzytkownika;
    private String password;
    private Socket echoSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Klient(String idUzytkownika, String password) {
        this.idUzytkownika = idUzytkownika;
        this.password = password;
        connect();
    }


    public List<Message> getNewMessageList()
    {
        try {
            return (List<Message>) in.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void sendMessage(String textMessage, Shape shape)
    {
        try {
            out.writeObject(new InformationPackage(idUzytkownika,new Message(textMessage, shape)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect()
    {
        try {
            echoSocket = new Socket("localhost", 6666);
            in = new ObjectInputStream(echoSocket.getInputStream());
            out = new ObjectOutputStream(echoSocket.getOutputStream());
        }
        catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }

    }

    public void disconnect()
    {
        try {
            out.close();
            in.close();
            echoSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

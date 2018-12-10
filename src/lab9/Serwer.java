package lab9;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Serwer {

    private List<DaneUzytkownika> daneUzytkownika=null;
    private ServerSocket serverSocket;
    private List<Socket> clientSocket=null;

    Serwer()
    {
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }
    }

    void getAllMessageTo()
    {

    }

    void addMessageTo(Message message)
    {

    }

}

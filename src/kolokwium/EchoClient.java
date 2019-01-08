package kolokwium;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    private Socket echoSocket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;

    EchoClient(){}

    public void addPlayerToDataBase(String query){
        connectToServer();

        out.println(query);
        try {
            String msg = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        closeConnection();
    }
    /*public void getAllPlayers(String query)
    {
        connectToServer();

        out.print(query);
        while ()

        closeConnection();
    }*/

    public void connectToServer()
    {
        try {
            echoSocket = new Socket("localhost", 6666);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }
    }

    public void closeConnection()
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
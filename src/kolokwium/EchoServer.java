package kolokwium;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        short port = 6666;

        try(ServerSocket srv = new ServerSocket(port)){
            while(true) {
                Socket s = srv.accept();
                System.out.print("new connection accepted: ");
                System.out.println(s.getInetAddress());
                new Thread(new SockReader(s)).start();
            }
        }
    }
}

class SockReader implements Runnable {
    private Scanner in;
    private PrintStream out;
    private Socket s;
    private DataBase dataBase;

    public SockReader(Socket s) throws IOException {
        this(s.getInputStream(),s.getOutputStream());
        this.s = s;
    }

    public SockReader(InputStream input, OutputStream output) {
        in = new Scanner(input);
        out = new PrintStream(output);
        dataBase = new DataBase();
    }

    private void msg(String msg) {
        System.out.print("SRV: ");
        System.out.println(msg);
    }
    public void run() {
        msg("new connection");
        while( (!Thread.currentThread().isInterrupted()) && in.hasNext() ) {
            String query = in.nextLine();
            msg(query);
            dataBase.addPlayer(query);
            out.println(query);
        }
        try {
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        msg("connection closed");
    }
}
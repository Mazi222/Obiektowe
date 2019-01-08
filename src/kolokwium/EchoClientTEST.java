package kolokwium;

public class EchoClientTEST {
    public static void main(String[] args) {
        EchoClient echoClient = new EchoClient();
        String query ="INSERT INTO players VALUES('"+"aaaaa"+"','" +"bbbb"+"')";
        echoClient.addPlayerToDataBase(query);
    }
}

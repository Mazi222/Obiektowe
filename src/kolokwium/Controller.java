package kolokwium;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {

    @FXML private TextField tile00;
    @FXML private TextField tile01;
    @FXML private TextField tile02;

    @FXML private TextField tile10;
    @FXML private TextField tile11;
    @FXML private TextField tile12;

    @FXML private TextField tile20;
    @FXML private TextField tile21;
    @FXML private TextField tile22;

    private EchoClient echoClient = new EchoClient();

    short player=0;
    short count=0;

    private void changeValueOfTile(TextField tile)
    {
        if(tile.getText()=="") {
            if (player == 0) {
                player = 1;
                tile.setText("X");
            } else {
                player = 0;
                tile.setText("O");
            }
            if(++count==9)
                sendMessageToServer();
        }
    }

    private void sendMessageToServer()
    {
        //Zawsze takie samo zapytanie aby pokazac że baza danych działa
        String query ="INSERT INTO players VALUES('"+"player1"+"','"+"1"+"0"+"player2"+"')";
        echoClient.addPlayerToDataBase(query);
    }

    @FXML
    public void handletile00()
    {
        changeValueOfTile(tile00);
    }

    @FXML
    public void handletile01()
    {
        changeValueOfTile(tile01);
    }

    @FXML
    public void handletile02()
    {
        changeValueOfTile(tile02);
    }

    @FXML
    public void handletile10()
    {
        changeValueOfTile(tile10);
    }

    @FXML
    public void handletile11()
    {
        changeValueOfTile(tile11);
    }

    @FXML
    public void handletile12()
    {
        changeValueOfTile(tile12);
    }

    @FXML
    public void handletile20()
    {
        changeValueOfTile(tile20);
    }

    @FXML
    public void handletile21()
    {
        changeValueOfTile(tile21);
    }

    @FXML
    public void handletile22()
    {
        changeValueOfTile(tile22);
    }

}

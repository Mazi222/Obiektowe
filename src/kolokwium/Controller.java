package kolokwium;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class Controller {

    @FXML private TextField textfieldFindByAuthor;
    @FXML private TextField textfieldFindByISBN;

    @FXML private TextField textfieldAddISBN;
    @FXML private TextField textfieldAddTitle;
    @FXML private TextField textfieldAddAuthor;
    @FXML private TextField textfieldAddYear;

    @FXML private TextField textfieldDeleteByISBN;


    @FXML private TableView<Player> tableView;
    @FXML private TableColumn<Player, String> col1;
    @FXML private TableColumn<Player, String> col2;
    @FXML private TableColumn<Player, String> col3;
    @FXML private TableColumn<Player, String> col4;

    private EchoClient echoClient = new EchoClient();

    @FXML
    public void bClear(){
        tableView.getItems().clear();
    }

    @FXML
    public void addBookWhenButtonIsClick()
    {
        String query ="INSERT INTO players VALUES('"+player.getName()+"','" +player.getTest()+"')";
        echoClient.addPlayer();
    }

}

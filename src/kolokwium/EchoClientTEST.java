package kolokwium;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*

Aby klient zadziałał należy najpierw uruchomić serwer a następnie przeprowadzić pozorowaną rozgrywkę w kółko i krzyżyk,
która zwróci ustawione "na sztywno wartości".

*/

public class EchoClientTEST extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TicTacToe.fxml"));
        stage.setTitle("Kolko krzyzyk");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


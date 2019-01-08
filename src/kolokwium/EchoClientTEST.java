package kolokwium;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EchoClientTEST extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("TicTacToe.fxml"));
        stage.setTitle("DB");
        stage.setScene(new Scene(root,1024,400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


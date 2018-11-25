package lab7.zad2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Gallery extends Application {

    Stage stage;

    @Override
    public void start(Stage primaryStage){
        stage=primaryStage;

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        TilePane tile = new TilePane();
        tile.setPadding(new Insets(15, 15, 15, 15));
        tile.setHgap(15);

        addImagestToTile(tile);

        stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        stage.setHeight(Screen.getPrimary().getVisualBounds()
                .getHeight());
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(tile);
        Scene scene = new Scene(scrollPane);
        stage.setScene(scene);
        stage.show();


    }

    private void addImagestToTile(TilePane tilePane)
    {
        String path = getPathToImages();
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (final File file : listOfFiles) {
            ImageView imageView;
            imageView = createImageView(file);
            tilePane.getChildren().addAll(imageView);
        }
    }

    private String getPathToImages(){

        String path = new String();

        DirectoryChooser directory = new DirectoryChooser();
        File selected = directory.showDialog(stage);

        if(selected == null){
            path="zdjecia";
        }
        else{
            path = selected.getAbsolutePath();
        }

        return  path;
    }

    private ImageView createImageView(final File imageFile) {

        ImageView imageView = null;

        try {
            final Image image = new Image(new FileInputStream(imageFile), 150,0, true, true);
            imageView = new ImageView(image);
            imageView.setFitWidth(150);
            imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {

                    if(mouseEvent.getButton().equals(MouseButton.PRIMARY))
                    {
                        if(mouseEvent.getClickCount() == 1)
                        {
                            try {
                                BorderPane borderPane = new BorderPane();
                                ImageView imageView = new ImageView();
                                Image image = new Image(new FileInputStream(imageFile));
                                imageView.setImage(image);
                                imageView.setStyle("-fx-background-color: BLACK");
                                imageView.setFitHeight(stage.getHeight() - 10);
                                imageView.setPreserveRatio(true);
                                imageView.setSmooth(true);
                                imageView.setCache(true);
                                borderPane.setCenter(imageView);
                                borderPane.setStyle("-fx-background-color: BLACK");
                                Stage newStage = new Stage();
                                newStage.setWidth(stage.getWidth());
                                newStage.setHeight(stage.getHeight());
                                newStage.setTitle(imageFile.getName());
                                Scene scene = new Scene(borderPane, Color.BLACK);
                                newStage.setScene(scene);
                                newStage.showAndWait();
                            }
                            catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });

        }
        catch (Exception e)
        {

        }
        return imageView;
    }
    public static void main(String[] args) {
        launch(args);
    }
}

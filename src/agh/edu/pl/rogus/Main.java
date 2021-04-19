package agh.edu.pl.rogus;

import agh.edu.pl.rogus.constants.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(Constants.SOURCE_VIEW));
        stage.setTitle(Constants.TITLE);
        stage.setScene(new Scene(root, Constants.WIDTH, Constants.HEIGHT));
        stage.show();
    }
}
